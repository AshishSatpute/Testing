package com.example.new_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

class AddToDataSource extends DatabaseHelper {

    private SQLiteDatabase sqLiteDatabase;

    public static final String TABLE_NAME = "data";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASS = "pass";

    public static final String CREATE_TABLE_ADD = "CREATE TABLE " + TABLE_NAME +
            "("
            + COLUMN_NAME
            + " TEXT NOT NULL, "
            + COLUMN_PASS
            + " TEXT NOT NULL "
            + " );";

    public static final String selectQuery = "SELECT * FROM " + TABLE_NAME + ";";


    public AddToDataSource(Context context) {
        super(context);
    }


    public void addData(Module module) {
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, module.getName());
        contentValues.put(COLUMN_PASS, module.getPass());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList showList() {
        ArrayList<Module> lists = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Module module = new Module();
                module.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                module.setPass(cursor.getString(cursor.getColumnIndex(COLUMN_PASS)));
                lists.add(module);
            } while (cursor.moveToNext());
        }

        return lists;
    }
}
