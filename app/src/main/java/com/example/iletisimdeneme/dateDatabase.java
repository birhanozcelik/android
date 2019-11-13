package com.example.iletisimdeneme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.Nullable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class dateDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "kayitlar";
    public static final String TABLE_NAME = "kayit";
    public static final String ID="ID";
    public static final String TARIH = "tarih";
    public static final String ADET = "adet";

    public dateDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY,"
                + TARIH + " TEXT,"
                + ADET + " INTEGER)");
        db.execSQL("INSERT INTO " +TABLE_NAME+ "("+ ID + "," + ADET + ","+ TARIH +")" + "VALUES" + "(1 , 0, 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
    public void writeDb(int adetii){
        SQLiteDatabase dataB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        int adet;
        adet = adetii;
        cv.put(ID,1);
        cv.put(ADET,adet);
        String whereClause = "id=1";
        dataB.update(TABLE_NAME,cv,whereClause,null);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        String tarih = dateFormat.format(date);
        cv.put(TARIH,tarih);
        dataB.update(TABLE_NAME,cv,whereClause,null);
//        String query = "UPDATE " +DB_NAME+ "SET" + ADET + "=" + adet + "WHERE" + ID + "=1";
//        Cursor cursor = dataB.rawQuery(query,null);



//        ContentValues cv = new ContentValues();
//        cv.put(ADET,adet);
//        dataB.insert(TABLE_NAME,null,cv);
        //long deger = dataB.insert(TABLE_NAME,null,cv);
        // dataB.update(TABLE_NAME,cv, "ID = 1" , new String[] {ID});

    }
    public int getDB(){
        SQLiteDatabase dataB = this.getReadableDatabase();
        String query = "select " +ADET+ " from " +TABLE_NAME+ " where " +ID+ " = 1";
        Cursor cursor = dataB.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex(ADET));
        //int getDbGelen = cursor.getInt(cursor.getColumnIndex(ADET));
    }

    public String getDate(){
        SQLiteDatabase dataB = this.getReadableDatabase();
        String query = "select " +TARIH+ " from " +TABLE_NAME+ " where " +ID+ " = 1"; // tarih query
        Cursor cursor = dataB.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor.getString(cursor.getColumnIndex(TARIH));


    }



}
