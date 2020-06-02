package com.example.ise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Mydatabase.db";

    // Contacts table name
    private static final String TABLE_REGISTER= "register";
    private static final String DATABASE_PATH = "/data/data/com.example.ise/databases/";
    // public static final String TABLE_NAME="registeruser";
    public static final String KEY_ID = "ID";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_PASSWORD = "password";

    public static final String CREATE_TABLE="CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER_NAME + " TEXT," + KEY_PASSWORD + " TEXT " + ")";

    public DatabaseHelper(Context context, Object name,
                          Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }


    public void addregister(RegisterData registerdata)
    {
      SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME,registerdata.getUser_name()); // register first Name
        values.put(KEY_PASSWORD, registerdata.getPassword() ); // register last name

        // Inserting Row
        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection

    }
    String password;
    //code to get the register
    String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "password=?",new String[]{username},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;
    }
}
