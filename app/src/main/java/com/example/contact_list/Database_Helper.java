package com.example.contact_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Book.db";
    private static final int DATABASE_VERSION = 1;

    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private final Context context;


    public Database_Helper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table contact(NAME TEXT,PHONE INTEGER)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addBook(String name,int phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        cv.put(PHONE,phone);

        long result = db.insert("contact",null,cv);

        if(result == -1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Added successfully",Toast.LENGTH_SHORT).show();
        }

        }
        Cursor readAllData()
        {
            String query = "Select * from contact";
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor = null;
            if(db != null)
            {
                cursor = db.rawQuery(query,null);
            }
            return cursor;
        }
}
