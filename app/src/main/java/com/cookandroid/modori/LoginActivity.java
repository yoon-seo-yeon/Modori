package com.cookandroid.modori;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//로그인 화면
public class LoginActivity extends AppCompatActivity {
    EditText Username, Userpass; //사용자의 이름, 사용자의 비밀번호
    Button Loginbtn; //로그인 버튼
    LoginDB logindb2;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Username = findViewById(R.id.Username);
        Userpass = findViewById(R.id.Userpass);
        Loginbtn = findViewById(R.id.Loginbtn);

        logindb2 = new LoginDB(this);
        sqlDB = logindb2.getWritableDatabase();

        Loginbtn.setOnClickListener(new View.OnClickListener() { //로그인 버튼 눌렀을 시
            @Override
            public void onClick(View view) {
                String uname = Username.getText().toString();
                String upass = Userpass.getText().toString();

                if(uname.length() == 0 || upass.length() == 0) { //이름이나 비밀번호 중 하나라도 입력을 안했을 시
                    Toast.makeText(getApplicationContext(), "이름과 비밀번호는 필수 입력사항입니다!", Toast.LENGTH_SHORT).show();
                }
                else { //둘 다 입력을 했다면
                    String sql = "select * from ModoriTBL where uname = '" + uname + "'and upass = '" + upass + "'";
                    Cursor cursor = sqlDB.rawQuery(sql, null);

                    while(cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        int pass = cursor.getInt(1);
                    }

                    if(cursor.getCount() == 1) { //해당 이름과 비밀번호가 있다면
                        Toast.makeText(getApplicationContext(), uname + "님 환영합니다!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Today_EmotionActivity.class);
                        startActivity(intent);

                    }else { //없다면
                        Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다!", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                }
            }
        });
    }
}