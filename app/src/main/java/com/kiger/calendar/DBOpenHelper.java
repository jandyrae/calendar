package com.kiger.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String CREATE_COURSES_TABLE = " create table " + DBStructure.COURSES_TABLE_NAME +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + DBStructure.COURSE + " TEXT, " + DBStructure.TIME +
            " TEXT, " + DBStructure.DATE + " TEXT, " + DBStructure.MONTH + " TEXT, " + DBStructure.YEAR + " TEXT)";
    private static final String DROP_EVENTS_TABLE = "DROP TABLE IF EXISTS " + DBStructure.COURSES_TABLE_NAME;

    public DBOpenHelper(@Nullable Context context) {
        super(context, DBStructure.DB_NAME, null, DBStructure.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COURSES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_EVENTS_TABLE);
        onCreate(db);
    }

    public void SaveCourse(String course, String time, String date, String month, String year, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBStructure.COURSE, course);
        contentValues.put(DBStructure.TIME, time);
        contentValues.put(DBStructure.DATE, date);
        contentValues.put(DBStructure.MONTH, month);
        contentValues.put(DBStructure.YEAR, year);
        database.insert(DBStructure.COURSES_TABLE_NAME, null, contentValues);


    }

    public Cursor ReadCourses(String date, SQLiteDatabase database) {
        String[] Projections = {DBStructure.COURSE, DBStructure.TIME, DBStructure.DATE, DBStructure.MONTH, DBStructure.YEAR};
        String Selection = DBStructure.DATE + "=?";
        String[] SelectionArgs = {date};

        return database.query(DBStructure.COURSES_TABLE_NAME, Projections, Selection, SelectionArgs, null, null, null);
    }

    public Cursor ReadCoursesPerMonth(String month, String year, SQLiteDatabase database) {
        String[] Projections = {DBStructure.COURSE, DBStructure.TIME, DBStructure.DATE, DBStructure.MONTH, DBStructure.YEAR};
        String Selection = DBStructure.DATE + "=? and " + DBStructure.YEAR + "=?";
        String[] SelectionArgs = {month, year};

        return database.query(DBStructure.COURSES_TABLE_NAME, Projections, Selection, SelectionArgs, null, null, null);
    }
}
