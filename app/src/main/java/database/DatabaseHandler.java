package database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 6;

    // Database Name
    private static final String DATABASE_NAME = "dataPengujian";

    // table name
    private static final String TABLE_SKENARIO_1 = "skenario1";
    private static final String TABLE_S1HASILENKRIPSI = "s1hasilenkripsi"; //AES
    private static final String TABLE_S1HASILENKRIPSIBLOWFISH = "s1hasilenkripsiblowfish"; //BLOWFISH
    private static final String TABLE_SKENARIO_2 = "skenario2";
    private static final String TABLE_S2HASILENKRIPSI = "s2hasilenkripsi"; //AES
    private static final String TABLE_S2HASILENKRIPSIBLOWFISH = "s2hasilenkripsiblowfish"; //BLOWFISH
    private static final String TABLE_SKENARIO_3 = "skenario3";
    private static final String TABLE_S3HASILENKRIPSI = "s3hasilenkripsi"; //AES
    private static final String TABLE_S3HASILENKRIPSIBLOWFISH = "s3hasilenkripsiblowfish"; //BLOWFISH
    //Skenario 1
    // Skenario 1 Table Columns names
    private static final String S1_KEY_ID = "id";
    private static final String S1_KEY_BYTES = "bytes";
    private static final String S1_KEY_TEKS = "teks";
    private static final String S1_KEY_KUNCI = "kunci";
    // S1HasilEnkripsi Table Columns names
    private static final String S1HE_KEY_ID = "ids1he";
    private static final String S1HE_KEY_ID_SKENARIO_1 = "idskenario1";
    private static final String S1HE_KEY_TEKSENKRIPSI = "teksenkripsi";
    private static final String S1HE_KEY_KUNCI = "kuncienkripsi";
    // S1HasilEnkripsi Table Columns names
    private static final String S1HEB_KEY_ID = "ids1heb";
    private static final String S1HEB_KEY_ID_SKENARIO_1 = "idskenario1b";
    private static final String S1HEB_KEY_TEKSENKRIPSI = "teksenkripsib";
    private static final String S1HEB_KEY_KUNCI = "kuncienkripsib";
    //Skenario 2
    // Skenario 2 Table Columns names
    private static final String S2_KEY_ID = "id";
    private static final String S2_KEY_BYTES = "bytes";
    private static final String S2_KEY_TEKS = "teks";
    private static final String S2_KEY_KUNCI = "kunci";
    // S1HasilEnkripsi Table Columns names
    private static final String S2HE_KEY_ID = "ids2he";
    private static final String S2HE_KEY_ID_SKENARIO_2 = "idskenario2";
    private static final String S2HE_KEY_TEKSENKRIPSI = "teksenkripsi";
    private static final String S2HE_KEY_KUNCI = "kuncienkripsi";
    // S1HasilEnkripsi Table Columns names
    private static final String S2HEB_KEY_ID = "ids2heb";
    private static final String S2HEB_KEY_ID_SKENARIO_2 = "idskenario2b";
    private static final String S2HEB_KEY_TEKSENKRIPSI = "teksenkripsib";
    private static final String S2HEB_KEY_KUNCI = "kuncienkripsib";
    //Skenario 3
    // Skenario 3 Table Columns names
    private static final String S3_KEY_ID = "id";
    private static final String S3_KEY_BYTES = "bytes";
    private static final String S3_KEY_TEKS = "teks";
    private static final String S3_KEY_KUNCI = "kunci";
    // S3HasilEnkripsi AES Table Columns names
    private static final String S3HE_KEY_ID = "ids3he";
    private static final String S3HE_KEY_ID_SKENARIO_3 = "idskenario3";
    private static final String S3HE_KEY_TEKSENKRIPSI = "teksenkripsi";
    private static final String S3HE_KEY_KUNCI = "kuncienkripsi";
    // S3HasilEnkripsi Blowfish Table Columns names
    private static final String S3HEB_KEY_ID = "ids3heb";
    private static final String S3HEB_KEY_ID_SKENARIO_3 = "idskenario3b";
    private static final String S3HEB_KEY_TEKSENKRIPSI = "teksenkripsib";
    private static final String S3HEB_KEY_KUNCI = "kuncienkripsib";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SKENARIO_1_TABLE = "CREATE TABLE " + TABLE_SKENARIO_1 + "("
                + S1_KEY_ID + " INTEGER PRIMARY KEY," + S1_KEY_BYTES + " INTEGER," + S1_KEY_TEKS + " TEXT,"
                + S1_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S1HASILENKRIPSI_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S1HASILENKRIPSI + "("
                + S1HE_KEY_ID + " INTEGER PRIMARY KEY,"+ S1HE_KEY_ID_SKENARIO_1 + " INTEGER," + S1HE_KEY_TEKSENKRIPSI + " TEXT,"
                +S1HE_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S1HASILENKRIPSIBLOWFISH_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S1HASILENKRIPSIBLOWFISH + "("
                + S1HEB_KEY_ID + " INTEGER PRIMARY KEY,"+ S1HEB_KEY_ID_SKENARIO_1 + " INTEGER," + S1HEB_KEY_TEKSENKRIPSI + " TEXT,"
                +S1HEB_KEY_KUNCI + " TEXT" + ")";
        String CREATE_SKENARIO_2_TABLE = "CREATE TABLE " + TABLE_SKENARIO_2 + "("
                + S2_KEY_ID + " INTEGER PRIMARY KEY," + S2_KEY_BYTES + " INTEGER," + S2_KEY_TEKS + " TEXT,"
                + S2_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S2HASILENKRIPSI_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S2HASILENKRIPSI + "("
                + S2HE_KEY_ID + " INTEGER PRIMARY KEY,"+ S2HE_KEY_ID_SKENARIO_2 + " INTEGER," + S2HE_KEY_TEKSENKRIPSI + " TEXT,"
                +S2HE_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S2HASILENKRIPSIBLOWFISH_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S2HASILENKRIPSIBLOWFISH + "("
                + S2HEB_KEY_ID + " INTEGER PRIMARY KEY,"+ S2HEB_KEY_ID_SKENARIO_2 + " INTEGER," + S2HEB_KEY_TEKSENKRIPSI + " TEXT,"
                +S2HEB_KEY_KUNCI + " TEXT" + ")";
        //--------
        String CREATE_SKENARIO_3_TABLE = "CREATE TABLE " + TABLE_SKENARIO_3 + "("
                + S3_KEY_ID + " INTEGER PRIMARY KEY," + S3_KEY_BYTES + " INTEGER," + S3_KEY_TEKS + " TEXT,"
                + S3_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S3HASILENKRIPSI_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S3HASILENKRIPSI + "("
                + S3HE_KEY_ID + " INTEGER PRIMARY KEY,"+ S3HE_KEY_ID_SKENARIO_3 + " INTEGER," + S3HE_KEY_TEKSENKRIPSI + " TEXT,"
                +S3HE_KEY_KUNCI + " TEXT" + ")";
        String CREATE_S3HASILENKRIPSIBLOWFISH_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_S3HASILENKRIPSIBLOWFISH + "("
                + S3HEB_KEY_ID + " INTEGER PRIMARY KEY,"+ S3HEB_KEY_ID_SKENARIO_3 + " INTEGER," + S3HEB_KEY_TEKSENKRIPSI + " TEXT,"
                +S3HEB_KEY_KUNCI + " TEXT" + ")";
        db.execSQL(CREATE_SKENARIO_1_TABLE);
        db.execSQL(CREATE_S1HASILENKRIPSI_TABLE);
        db.execSQL(CREATE_S1HASILENKRIPSIBLOWFISH_TABLE);
        db.execSQL(CREATE_SKENARIO_2_TABLE);
        db.execSQL(CREATE_S2HASILENKRIPSI_TABLE);
        db.execSQL(CREATE_S2HASILENKRIPSIBLOWFISH_TABLE);
        db.execSQL(CREATE_SKENARIO_3_TABLE);
        db.execSQL(CREATE_S3HASILENKRIPSI_TABLE);
        db.execSQL(CREATE_S3HASILENKRIPSIBLOWFISH_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKENARIO_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S1HASILENKRIPSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S1HASILENKRIPSIBLOWFISH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKENARIO_2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S2HASILENKRIPSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S2HASILENKRIPSIBLOWFISH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKENARIO_3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S3HASILENKRIPSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_S3HASILENKRIPSIBLOWFISH);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations Table Skenario 1
     */


    // Adding new data s1hasilenkripsi
    public void addS1HasilEnkripsi(S1HasilEnkripsi s1hasilenkripsi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S1HE_KEY_ID_SKENARIO_1, s1hasilenkripsi.getIDSkenario1());
        values.put(S1HE_KEY_TEKSENKRIPSI, s1hasilenkripsi.getTeksEnkripsi());
        values.put(S1HE_KEY_KUNCI, s1hasilenkripsi.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S1HASILENKRIPSI, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s1hasilenkripsi
    public List<S1HasilEnkripsi> getAllS1hasilenkripsi() {
        List<S1HasilEnkripsi> s1hasilenkripsiList = new ArrayList<S1HasilEnkripsi>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S1HASILENKRIPSI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S1HasilEnkripsi s1hasilenkripsi = new S1HasilEnkripsi();
                s1hasilenkripsi.setID(Integer.parseInt(cursor.getString(0)));
                s1hasilenkripsi.setIDSkenario1(Integer.parseInt(cursor.getString(1)));
                s1hasilenkripsi.setTeksEnkripsi(cursor.getString(2));
                s1hasilenkripsi.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s1hasilenkripsiList.add(s1hasilenkripsi);
            } while (cursor.moveToNext());
        }

        // return skenario 1 list
        return s1hasilenkripsiList;
    }

    // Deleting all data s1 hasilenkripsi
    public void deleteAllS1hasilenkripsi() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S1HASILENKRIPSI);
        db.close();
    }
    //--
    // Adding new data s1hasilenkripsiBlowfish
    public void addS1HasilEnkripsiBlowfish(S1HasilEnkripsiBlowfish s1hasilenkripsib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S1HEB_KEY_ID_SKENARIO_1, s1hasilenkripsib.getIDSkenario1());
        values.put(S1HEB_KEY_TEKSENKRIPSI, s1hasilenkripsib.getTeksEnkripsi());
        values.put(S1HEB_KEY_KUNCI, s1hasilenkripsib.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S1HASILENKRIPSIBLOWFISH, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s1hasilenkripsi
    public List<S1HasilEnkripsiBlowfish> getAllS1hasilenkripsiBlowfish() {
        List<S1HasilEnkripsiBlowfish> s1hasilenkripsiblowfishList = new ArrayList<S1HasilEnkripsiBlowfish>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S1HASILENKRIPSIBLOWFISH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S1HasilEnkripsiBlowfish s1hasilenkripsib = new S1HasilEnkripsiBlowfish();
                s1hasilenkripsib.setID(Integer.parseInt(cursor.getString(0)));
                s1hasilenkripsib.setIDSkenario1(Integer.parseInt(cursor.getString(1)));
                s1hasilenkripsib.setTeksEnkripsi(cursor.getString(2));
                s1hasilenkripsib.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s1hasilenkripsiblowfishList.add(s1hasilenkripsib);
            } while (cursor.moveToNext());
        }

        // return skenario 1 list
        return s1hasilenkripsiblowfishList;
    }

    // Deleting all data s1 hasilenkripsi
    public void deleteAllS1hasilenkripsiblowfish() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S1HASILENKRIPSIBLOWFISH);
        db.close();
    }
    //--

    // Adding new data skenario 1
    public void addSkenario1(Skenario1 skenario1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S1_KEY_BYTES, skenario1.getBytes()); // Skenario 1 Bytes
        values.put(S1_KEY_TEKS, skenario1.getTeks()); // Skenario 1 Teks
        values.put(S1_KEY_KUNCI, skenario1.getKunci()); // Skenario 1 Kunci

        // Inserting Row
        db.insert(TABLE_SKENARIO_1, null, values);
        db.close(); // Closing database connection
    }

    // Getting single data skenario 1
    Skenario1 getSkenario1(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SKENARIO_1, new String[] { S1_KEY_ID,
                        S1_KEY_BYTES, S1_KEY_TEKS, S1_KEY_KUNCI }, S1_KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Skenario1 skenario1 = new Skenario1(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return skenario1;
    }

    // Getting All data Skenario 1
    public List<Skenario1> getAllSkenario1() {
        List<Skenario1> skenario1List = new ArrayList<Skenario1>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SKENARIO_1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Skenario1 skenario1 = new Skenario1();
                skenario1.setID(Integer.parseInt(cursor.getString(0)));
                skenario1.setBytes(Integer.parseInt(cursor.getString(1)));
                skenario1.setTeks(cursor.getString(2));
                skenario1.setKunci(cursor.getString(3));
                // Adding contact to list
                skenario1List.add(skenario1);
            } while (cursor.moveToNext());
        }

        // return skenario 1 list
        return skenario1List;
    }

    // Updating single data skenario 1
    public int updateSkenario1(Skenario1 skenario1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S1_KEY_BYTES, skenario1.getBytes());
        values.put(S1_KEY_TEKS, skenario1.getTeks());
        values.put(S1_KEY_KUNCI, skenario1.getKunci());

        // updating row
        return db.update(TABLE_SKENARIO_1, values, S1_KEY_ID + " = ?",
                new String[] { String.valueOf(skenario1.getID()) });
    }

    // Deleting single data skenario 1
    public void deleteSkenario1(Skenario1 skenario1) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SKENARIO_1, S1_KEY_ID + " = ?",
                new String[]{String.valueOf(skenario1.getID())});
        db.close();
    }

    // Deleting all data skenario 1
    public void deleteAllSkenario1() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_SKENARIO_1);
        db.close();
    }


    // Getting skenario 1 data Count
    public int getSkenario1Count() {
        String countQuery = "SELECT  * FROM " + TABLE_SKENARIO_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations Table Skenario 2
     */


    // Adding new data s2hasilenkripsi
    public void addS2HasilEnkripsi(S2HasilEnkripsi s2hasilenkripsi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S2HE_KEY_ID_SKENARIO_2, s2hasilenkripsi.getIDSkenario2());
        values.put(S2HE_KEY_TEKSENKRIPSI, s2hasilenkripsi.getTeksEnkripsi());
        values.put(S2HE_KEY_KUNCI, s2hasilenkripsi.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S2HASILENKRIPSI, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s1hasilenkripsi
    public List<S2HasilEnkripsi> getAllS2hasilenkripsi() {
        List<S2HasilEnkripsi> s2hasilenkripsiList = new ArrayList<S2HasilEnkripsi>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S2HASILENKRIPSI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S2HasilEnkripsi s2hasilenkripsi = new S2HasilEnkripsi();
                s2hasilenkripsi.setID(Integer.parseInt(cursor.getString(0)));
                s2hasilenkripsi.setIDSkenario2(Integer.parseInt(cursor.getString(1)));
                s2hasilenkripsi.setTeksEnkripsi(cursor.getString(2));
                s2hasilenkripsi.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s2hasilenkripsiList.add(s2hasilenkripsi);
            } while (cursor.moveToNext());
        }

        // return skenario 2 list
        return s2hasilenkripsiList;
    }

    // Deleting all data s2 hasilenkripsi
    public void deleteAllS2hasilenkripsi() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S2HASILENKRIPSI);
        db.close();
    }
    //--
    // Adding new data s2hasilenkripsiBlowfish
    public void addS2HasilEnkripsiBlowfish(S2HasilEnkripsiBlowfish s2hasilenkripsib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S2HEB_KEY_ID_SKENARIO_2, s2hasilenkripsib.getIDSkenario2());
        values.put(S2HEB_KEY_TEKSENKRIPSI, s2hasilenkripsib.getTeksEnkripsi());
        values.put(S2HEB_KEY_KUNCI, s2hasilenkripsib.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S2HASILENKRIPSIBLOWFISH, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s1hasilenkripsi
    public List<S2HasilEnkripsiBlowfish> getAllS2hasilenkripsiBlowfish() {
        List<S2HasilEnkripsiBlowfish> s2hasilenkripsiblowfishList = new ArrayList<S2HasilEnkripsiBlowfish>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S2HASILENKRIPSIBLOWFISH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S2HasilEnkripsiBlowfish s2hasilenkripsib = new S2HasilEnkripsiBlowfish();
                s2hasilenkripsib.setID(Integer.parseInt(cursor.getString(0)));
                s2hasilenkripsib.setIDSkenario2(Integer.parseInt(cursor.getString(1)));
                s2hasilenkripsib.setTeksEnkripsi(cursor.getString(2));
                s2hasilenkripsib.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s2hasilenkripsiblowfishList.add(s2hasilenkripsib);
            } while (cursor.moveToNext());
        }

        // return skenario 2 list
        return s2hasilenkripsiblowfishList;
    }

    // Deleting all data s2 hasilenkripsi
    public void deleteAllS2hasilenkripsiblowfish() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S2HASILENKRIPSIBLOWFISH);
        db.close();
    }
    //--

    // Adding new data skenario 2
    public void addSkenario2(Skenario2 skenario2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S2_KEY_BYTES, skenario2.getBytes()); // Skenario 2 Bytes
        values.put(S2_KEY_TEKS, skenario2.getTeks()); // Skenario 2 Teks
        values.put(S2_KEY_KUNCI, skenario2.getKunci()); // Skenario 2 Kunci

        // Inserting Row
        db.insert(TABLE_SKENARIO_2, null, values);
        db.close(); // Closing database connection
    }

    // Getting single data skenario 2
    Skenario2 getSkenario2(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SKENARIO_2, new String[] { S2_KEY_ID,
                        S2_KEY_BYTES, S2_KEY_TEKS, S2_KEY_KUNCI }, S2_KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Skenario2 skenario2 = new Skenario2(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return skenario2;
    }

    // Getting All data Skenario 2
    public List<Skenario2> getAllSkenario2() {
        List<Skenario2> skenario2List = new ArrayList<Skenario2>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SKENARIO_2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Skenario2 skenario2 = new Skenario2();
                skenario2.setID(Integer.parseInt(cursor.getString(0)));
                skenario2.setBytes(Integer.parseInt(cursor.getString(1)));
                skenario2.setTeks(cursor.getString(2));
                skenario2.setKunci(cursor.getString(3));
                // Adding contact to list
                skenario2List.add(skenario2);
            } while (cursor.moveToNext());
        }

        // return skenario 2 list
        return skenario2List;
    }

    // Updating single data skenario 2
    public int updateSkenario2(Skenario2 skenario2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S2_KEY_BYTES, skenario2.getBytes());
        values.put(S2_KEY_TEKS, skenario2.getTeks());
        values.put(S2_KEY_KUNCI, skenario2.getKunci());

        // updating row
        return db.update(TABLE_SKENARIO_2, values, S2_KEY_ID + " = ?",
                new String[] { String.valueOf(skenario2.getID()) });
    }

    // Deleting single data skenario 2
    public void deleteSkenario2(Skenario2 skenario2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SKENARIO_2, S2_KEY_ID + " = ?",
                new String[]{String.valueOf(skenario2.getID())});
        db.close();
    }

    // Deleting all data skenario 2
    public void deleteAllSkenario2() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_SKENARIO_2);
        db.close();
    }


    // Getting skenario 2 data Count
    public int getSkenario2Count() {
        String countQuery = "SELECT  * FROM " + TABLE_SKENARIO_2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations Table Skenario 3
     */


    // Adding new data s3hasilenkripsi
    public void addS3HasilEnkripsi(S3HasilEnkripsi s3hasilenkripsi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S3HE_KEY_ID_SKENARIO_3, s3hasilenkripsi.getIDSkenario3());
        values.put(S3HE_KEY_TEKSENKRIPSI, s3hasilenkripsi.getTeksEnkripsi());
        values.put(S3HE_KEY_KUNCI, s3hasilenkripsi.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S3HASILENKRIPSI, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s1hasilenkripsi
    public List<S3HasilEnkripsi> getAllS3hasilenkripsi() {
        List<S3HasilEnkripsi> s3hasilenkripsiList = new ArrayList<S3HasilEnkripsi>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S3HASILENKRIPSI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S3HasilEnkripsi s3hasilenkripsi = new S3HasilEnkripsi();
                s3hasilenkripsi.setID(Integer.parseInt(cursor.getString(0)));
                s3hasilenkripsi.setIDSkenario3(Integer.parseInt(cursor.getString(1)));
                s3hasilenkripsi.setTeksEnkripsi(cursor.getString(2));
                s3hasilenkripsi.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s3hasilenkripsiList.add(s3hasilenkripsi);
            } while (cursor.moveToNext());
        }

        // return skenario 3 list
        return s3hasilenkripsiList;
    }

    // Deleting all data s3 hasilenkripsi
    public void deleteAllS3hasilenkripsi() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S3HASILENKRIPSI);
        db.close();
    }
    //--
    // Adding new data s3hasilenkripsiBlowfish
    public void addS3HasilEnkripsiBlowfish(S3HasilEnkripsiBlowfish s3hasilenkripsib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S3HEB_KEY_ID_SKENARIO_3, s3hasilenkripsib.getIDSkenario3());
        values.put(S3HEB_KEY_TEKSENKRIPSI, s3hasilenkripsib.getTeksEnkripsi());
        values.put(S3HEB_KEY_KUNCI, s3hasilenkripsib.getKunciEnkripsi());

        // Inserting Row
        db.insert(TABLE_S3HASILENKRIPSIBLOWFISH, null, values);
        db.close(); // Closing database connection
    }

    // Getting All data s3hasilenkripsi
    public List<S3HasilEnkripsiBlowfish> getAllS3hasilenkripsiBlowfish() {
        List<S3HasilEnkripsiBlowfish> s3hasilenkripsiblowfishList = new ArrayList<S3HasilEnkripsiBlowfish>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_S3HASILENKRIPSIBLOWFISH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                S3HasilEnkripsiBlowfish s3hasilenkripsib = new S3HasilEnkripsiBlowfish();
                s3hasilenkripsib.setID(Integer.parseInt(cursor.getString(0)));
                s3hasilenkripsib.setIDSkenario3(Integer.parseInt(cursor.getString(1)));
                s3hasilenkripsib.setTeksEnkripsi(cursor.getString(2));
                s3hasilenkripsib.setKunciEnkripsi(cursor.getString(3));
                // Adding contact to list
                s3hasilenkripsiblowfishList.add(s3hasilenkripsib);
            } while (cursor.moveToNext());
        }

        // return skenario 3 list
        return s3hasilenkripsiblowfishList;
    }

    // Deleting all data s3 hasilenkripsi
    public void deleteAllS3hasilenkripsiblowfish() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_S3HASILENKRIPSIBLOWFISH);
        db.close();
    }
    //--

    // Adding new data skenario 3
    public void addSkenario3(Skenario3 skenario3) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S3_KEY_BYTES, skenario3.getBytes()); // Skenario 3 Bytes
        values.put(S3_KEY_TEKS, skenario3.getTeks()); // Skenario 3 Teks
        values.put(S3_KEY_KUNCI, skenario3.getKunci()); // Skenario 3 Kunci

        // Inserting Row
        db.insert(TABLE_SKENARIO_3, null, values);
        db.close(); // Closing database connection
    }

    // Getting single data skenario 3
    Skenario3 getSkenario3(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SKENARIO_3, new String[] { S3_KEY_ID,
                        S3_KEY_BYTES, S3_KEY_TEKS, S3_KEY_KUNCI }, S3_KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Skenario3 skenario3 = new Skenario3(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return skenario3;
    }

    // Getting All data Skenario 3
    public List<Skenario3> getAllSkenario3() {
        List<Skenario3> skenario3List = new ArrayList<Skenario3>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SKENARIO_3;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Skenario3 skenario3 = new Skenario3();
                skenario3.setID(Integer.parseInt(cursor.getString(0)));
                skenario3.setBytes(Integer.parseInt(cursor.getString(1)));
                skenario3.setTeks(cursor.getString(2));
                skenario3.setKunci(cursor.getString(3));
                // Adding contact to list
                skenario3List.add(skenario3);
            } while (cursor.moveToNext());
        }

        // return skenario 3 list
        return skenario3List;
    }

    // Updating single data skenario 3
    public int updateSkenario3(Skenario3 skenario3) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(S3_KEY_BYTES, skenario3.getBytes());
        values.put(S3_KEY_TEKS, skenario3.getTeks());
        values.put(S3_KEY_KUNCI, skenario3.getKunci());

        // updating row
        return db.update(TABLE_SKENARIO_3, values, S3_KEY_ID + " = ?",
                new String[] { String.valueOf(skenario3.getID()) });
    }

    // Deleting single data skenario 3
    public void deleteSkenario3(Skenario3 skenario3) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SKENARIO_3, S3_KEY_ID + " = ?",
                new String[]{String.valueOf(skenario3.getID())});
        db.close();
    }

    // Deleting all data skenario 3
    public void deleteAllSkenario3() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_SKENARIO_3);
        db.close();
    }


    // Getting skenario 3 data Count
    public int getSkenario3Count() {
        String countQuery = "SELECT  * FROM " + TABLE_SKENARIO_3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    //-----
    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }
}