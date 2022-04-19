package com.cookandroid.modori;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Diary_updateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_update);

        final ModoriDB modoriDB;
        String dbName = "Modori.db";
        int dbVersion = 1;
        modoriDB = new ModoriDB(this, dbName, null, dbVersion);

        Intent intent = getIntent();
        final String got_title = intent.getStringExtra("title");
        final String got_contents = intent.getStringExtra("contents");
        int got_position = intent.getIntExtra("position", 0);

        final EditText title = findViewById(R.id.et_title);
        final EditText contents = findViewById(R.id.et_contents);
        Button save_btn = findViewById(R.id.ib_save);
        ImageButton back_btn = findViewById(R.id.ib_back);

        title.setText(got_title);
        contents.setText(got_contents);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = modoriDB.getWritableDatabase();
                String final_title = title.getText().toString();
                String final_content = contents.getText().toString();
                String sql = "UPDATE Modori SET title = '" + final_title + "', contents = '" + final_content + "'WHERE contents = '" + got_contents + "';";
                db.execSQL(sql);

                AlertDialog.Builder builder = new AlertDialog.Builder(Diary_updateActivity.this);

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setMessage("다이어리를 저장하시겠습니까?");
                builder.setTitle("Diary 저장");
                builder.show();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModoriActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
