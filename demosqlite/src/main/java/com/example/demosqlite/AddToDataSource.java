package com.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AddToDataSource extends DatabaseHelper {

    private String TAG = AddToDataSource.class.getCanonicalName();
    SQLiteDatabase database;
    Context context;

    private static final String TABLE_NAME_ADD = "addDB";
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
        long insertedId = database.insert(TABLE_NAME_ADD, null, contentValues);
        Log.i(TAG, "addData: " + insertedId);
    }
}
