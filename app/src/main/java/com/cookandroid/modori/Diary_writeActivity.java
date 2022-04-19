package com.cookandroid.modori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

//다이어리 작성
public class Diary_writeActivity extends AppCompatActivity {
    EditText login_name;
    ImageButton loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_write);

        final ModoriDB modoriDB;
        String dbName = "Modori.db";
        int dbVersion = 1;

        modoriDB = new ModoriDB(this, dbName, null, dbVersion);

        final EditText title = findViewById(R.id.et_title);
        final EditText contents = findViewById(R.id.et_contents);
        Button save_btn = findViewById(R.id.ib_save);
        ImageButton back_btn = findViewById(R.id.ib_back);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModoriActivity.class);
                startActivity(intent);
                finish();
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleStr = title.getText().toString();
                String contentsStr = contents.getText().toString();

                //String sql = "INSERT INTO testTBL(img1 , img2, img3, img4, img5, diarytext) VALUES('" + imgS1 + "', '" + imgS2 + "', '" + imgS3 + "', '" + imgS4 + "', '" + imgS5 + "', '" + diaryText + "');";

                //sqlDB.execSQL(sql);

                SQLiteDatabase db = modoriDB.getWritableDatabase();
                String sql = "INSERT INTO Modori (title, contents) VALUES('" + titleStr + "', '" + contentsStr + "');";
                db.execSQL(sql);

                Toast.makeText(getApplicationContext(), "저장되었습니다!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}