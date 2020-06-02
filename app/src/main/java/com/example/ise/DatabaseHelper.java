package com.example.ise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABSE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2="username";
    public static final String COL_3="password";

    public DatabaseHelper(@Nullable Context context)
    {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase  SQLiteDatabase )
    {
        SQLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT,username Text,passwod Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase , int i , int i1)
    {

        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(SQLiteDatabase);

    }

    public  long adduser(String user,String password)
    {
      SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res= db.insert("registeruser",null,contentValues);
        db.close();
        return res;

    }

    public boolean checkuser(String username, String password)
    {
        String[] columns= {COL_1};
        SQLiteDatabase db =getReadableDatabase();
        String selection=COL_2 +  "=?" + " and " +  COL_3 + "=?";
        String[] selectionargs={ username,password};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionargs,null,null,null);
        int count= cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)

                return true;
        else
                return false;

    }

}


