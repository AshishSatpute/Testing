package com.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AddToDataSource extends DatabaseHelper {

    private String TAG = AddToDataSource.class.getCanonicalName();
    SQLiteDatabase database;
    Context context;

    public static final String TABLE_NAME_ADD = "addDB";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";


    public static final String CREATE_TABLE_ADD = " CREATE TABLE " + TABLE_NAME_ADD
            + " ("
            + COLUMN_USERNAME
            + " TEXT NOT NULL, "
            + COLUMN_PASSWORD
            + " TEXT NOT NULL"
            + " );";

    public AddToDataSource(Context context) {
        super(context);
    }

    public void addData(AddDataModel addDataModel) {
        Log.i(TAG, "addData: ");
        database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, addDataModel.getName());
        contentValues.put(COLUMN_PASSWORD, addDataModel.getPassword());
        Log.i(TAG, addDataModel.getName().toString());
        Log.i(TAG, addDataModel.getPassword().toString());
        long insertedId = database.insert(TABLE_NAME_ADD, null, contentValues);
        Log.i(TAG, "addData: " + insertedId);
    }

    public List<AddDataModel> getAllNotes() {
        List<AddDataModel> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + AddToDataSource.TABLE_NAME_ADD + ";";

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddDataModel addDataModel = new AddDataModel();
                addDataModel.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                addDataModel.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                notes.add(addDataModel);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }
}
