package com.cookandroid.modori;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModoriActivity extends AppCompatActivity {
    Button Diary;

    ArrayList<Modori> modoriArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modori);

        String dbName = "Modori.db";
        int dbVersion = 1;
        final ModoriDB modoriDB;

        Diary = findViewById(R.id.Diary);

        modoriDB = new ModoriDB(this, dbName, null, dbVersion);

        final SQLiteDatabase db = modoriDB.getReadableDatabase();

        final String sql = "SELECT * FROM Modori";
        Cursor cursor = db.rawQuery(sql, null);

        int cnt = cursor.getCount();

        try {
            if(cursor.getCount() > 0) {
                while(cursor.moveToNext()) {
                    Modori m = new Modori(cursor.getString(1), cursor.getString(2));
                    modoriArrayList.add(m);
                }
            }
        }finally {
            cursor.close();
        }

        final ListView listview = findViewById(R.id.list);
        ModoriAdapter modoriadapter = new ModoriAdapter(modoriArrayList, this);
        listview.setAdapter(modoriadapter);

        //다이어리 수정 화면으로 이동
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() { //리스트뷰 내 아이테 클릭시
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int check_position = listview.getCheckedItemPosition();
                Modori mo = (Modori)parent.getAdapter().getItem(position);

                String t_title = mo.getTitle();
                String c_contents = mo.getContents();

                Intent intent = new Intent(getApplicationContext(), Diary_updateActivity.class);
                intent.putExtra("title", t_title);
                intent.putExtra("contents", c_contents);
                intent.putExtra("position", position);

                startActivity(intent);
                finish();
            }
        });

        //다이어리 삭제
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { //롱클릭시 삭제
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                Modori mo = (Modori)parent.getAdapter().getItem(position);
                final String t_title = mo.getTitle();
                final String c_contents = mo.getContents();

                AlertDialog.Builder builder = new AlertDialog.Builder(ModoriActivity.this);

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //String content = c_contents.trim();
                        String sql2 = "DELETE FROM Modori WHERE title = '" + t_title + "';";
                        db.execSQL(sql2);

                        Toast.makeText(getApplicationContext(), "삭제 완료", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), ModoriActivity.class);
                        finish();
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setMessage("다이어리를 삭제하시겠습니까?");
                builder.setTitle("다이어리 삭제");
                builder.show();

                return true;
            }
        });

        Diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Diary_writeActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
