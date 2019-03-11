package com.example.dth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class OperationSource extends DatabaseHelper {

    public static final String TABLE_NAME = "tab";
    public static final String COLUMN_ONE = "one";
    public static final String COLUMN_TWO = "two";

    SQLiteDatabase sqLiteDatabase;
    public static final String selectQuery = "SELECT * FROM " + TABLE_NAME + ";";

    public static final String CREATE_TABLE_DO = "CREATE TABLE "
            + TABLE_NAME
            + "( "
            + COLUMN_ONE
            + " TEXT NOT NULL, "
            + COLUMN_TWO
            + " TEXT NOT NULL "
            + ");";

    public OperationSource(Context context) {
        super(context);
    }


    public void DoOperation(Model model) {
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ONE, model.getOne());
        contentValues.put(COLUMN_TWO, model.getTwo());
        Long data = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        Log.i("TAG", "DoOperation: " + data);
    }


    public ArrayList showList() {

        ArrayList<Model> models = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        while (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setOne(cursor.getString(cursor.getColumnIndex(COLUMN_ONE)));
                model.setTwo(cursor.getString(cursor.getColumnIndex(COLUMN_TWO)));
                models.add(model);
            } while (cursor.moveToNext());
        }
        return models;
    }
}
