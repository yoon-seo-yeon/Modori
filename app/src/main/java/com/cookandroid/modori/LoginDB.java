package com.cookandroid.modori;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDB extends SQLiteOpenHelper {
    public LoginDB(Context context) {
        super(context, "ModoriDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE ModoriTBL(uid INTEGER PRIMARY kEY autoincrement, uname CHAR(20), upass INTEGER);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ModoriTBL");
        onCreate(sqLiteDatabase);
    }
}