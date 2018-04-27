package com.example.srinath_pc.searchadderss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 19-01-2018.
 */

public class DataHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "Address";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";// incase of Cusrsor Adapter you have to use "_id" mandatort
    private static final String KEY_LOCALITY = "locality";
    private static final String KEY_LATITUDE = "latitude";
    private static final String kEY_LOGNITUDE = "lognitude";


    public DataHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER," + KEY_LOCALITY + " TEXT," + KEY_LATITUDE + " TEXT," + kEY_LOGNITUDE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }


    // Getting All Contacts
    public Cursor getAllData() {

        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }

    public void insert(int i, String entryaddress, String latitude, String longitude) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,i);//  i use this in case of Cursor Adapter
        values.put(KEY_LOCALITY, entryaddress);
        values.put(KEY_LATITUDE, latitude);
        values.put(kEY_LOGNITUDE,longitude);

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection


    }

}
