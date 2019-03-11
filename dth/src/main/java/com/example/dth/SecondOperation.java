package com.example.dth;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SecondOperation extends DatabaseHelper {

    public static final String Query = "SELECT * FROM tab;";

    public SecondOperation(Context context) {
        super(context);
    }

    public ArrayList showList() {

        ArrayList<Model> models = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Query, null);

        while (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setOne(cursor.getString(cursor.getColumnIndex("one")));
                model.setTwo(cursor.getString(cursor.getColumnIndex("two")));
                models.add(model);
            } while (cursor.moveToNext());
        }
        return models;
    }

}
