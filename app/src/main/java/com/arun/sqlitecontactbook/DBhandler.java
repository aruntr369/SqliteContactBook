package com.arun.sqlitecontactbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "contact.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycontacts";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String NUMBER_COL = "number";
    private static final String EMAIL_COL = "email";


    public DBhandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + NUMBER_COL + " TEXT,"
                + EMAIL_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addContact(String name, String number, String email) {
    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL,name);
        values.put(NUMBER_COL,number);
        values.put(EMAIL_COL,email);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<ContactModel> readContact() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        ArrayList<ContactModel> contactModelArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do{
                contactModelArrayList.add(new ContactModel(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactModelArrayList;
    }
}
