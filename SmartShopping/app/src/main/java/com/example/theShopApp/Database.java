package com.example.theShopApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NileshAgrawal on 7/6/14.
 */
public class Database extends SQLiteOpenHelper {


    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_PERSON = "CREATE TABLE "
            + Constants.TABLE_PERSON + "(" + Constants.KEY_PERSON_TABLE_ID + " INTEGER PRIMARY KEY,"
            + Constants.KEY_PERSON_FIRST_NAME + " TEXT,"
            + Constants.KEY_PERSON_LAST_NAME + " TEXT,"
            +Constants.KEY_PERSON_USERNAME   + " TEXT,"
            +Constants.KEY_PERSON_PASSWORD + " TEXT,"
            +Constants.KEY_PERSON_EMAILID+ " TEXT," + ")";


    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_PERSON);

        // create new tables
        onCreate(sqLiteDatabase);
    }


    /*
 * Creating a todo
 */
    public long createAccount(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(Constants.KEY_PERSON_TABLE_ID, person.);
        values.put(Constants.KEY_PERSON_FIRST_NAME,person.getFirstName() );
        values.put(Constants.KEY_PERSON_LAST_NAME,person.getLastName());
        values.put(Constants.KEY_PERSON_USERNAME,person.getUsername());
        values.put(Constants.KEY_PERSON_PASSWORD,person.getPassword());
        values.put(Constants.KEY_PERSON_EMAILID,person.getEmailid());
        // insert row
        long person_id = db.insert(Constants.TABLE_PERSON, null, values);

        return person_id;
    }


    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}

