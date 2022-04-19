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

//회원가입 화면
public class RegisterActivity extends AppCompatActivity {
    EditText uName,uPass; //사용자의 이름, 비밀번호
    Button registerbtn; //회원가입버튼

    LoginDB logindb2;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //회원가입
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        uName = findViewById(R.id.uName);
        uPass = findViewById(R.id.uPass);
        registerbtn = findViewById(R.id.Registerbtn);

        logindb2 = new LoginDB(this);
        sqlDB = logindb2.getWritableDatabase();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = uName.getText().toString(); //이름
                String upass = uPass.getText().toString(); //비밀번호
                String register_sql = "select * from ModoriTBL where upass = '" + upass + "'";

                Cursor cursor = sqlDB.rawQuery(register_sql, null);

                if(cursor.getCount() == 1) { //해당 비밀번호가 있다면
                    Toast.makeText(getApplicationContext(), "이미 존재하는 비밀번호입니다!", Toast.LENGTH_SHORT).show();
                } else { //없다면
                    String sql2 = "insert into ModoriTBL(uname, upass)";
                    sql2 += "values('" + uname + "',";
                    sql2 += upass + ");";

                    sqlDB.execSQL(sql2);
                    Toast.makeText(getApplicationContext(), "회원가입 되었습니다!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}