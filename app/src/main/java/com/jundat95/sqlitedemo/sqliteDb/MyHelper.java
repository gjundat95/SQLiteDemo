package com.jundat95.sqlitedemo.sqliteDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jundat95.sqlitedemo.model.ToDo;

/**
 * Created by tinhngo on 12/09/2017.
 */

public class MyHelper extends SQLiteOpenHelper {

    static final String DBName = "KTPM",
            TableName="Table1",
            Column1="Column1",
            Column2="Column2";

    static final String toDoTable = "toDoTable",
            key = "key",
            title = "title",
            description = "description",
            date = "date",
            status = "status";

    // create database
    public MyHelper(Context context, int version) {
        super(context, DBName , null, version);
        Log.d(DBName, "construct");
    }

    // create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "create table " + TableName + "("
                + Column1 + " text" + " primary key, "
                + Column2 + " text )";

        String createTableToDo = "create table " + toDoTable + " ( "
                + key + " text " + " primary key, "
                + title + " text, "
                + description + " text, "
                + date + " text , "
                + status + " text "
                + " )";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(createTableToDo);
        Log.d(DBName, "onCreate");


    }

    // update struct table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // drop table
        String drop = "drop table if exists " + TableName;
        String dropTableToDo = "drop table if exists " + toDoTable;
        sqLiteDatabase.execSQL(drop);
        sqLiteDatabase.execSQL(dropTableToDo);
        // check version if true => drop
        onCreate(sqLiteDatabase);

        Log.d(DBName, "onUpdate");


    }

    public long createData (String value1, String value2) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column1, value1);
        contentValues.put(Column2, value2);
        return sqLiteDatabase.insert(TableName, null, contentValues);
    }

    public long createDataToto (ToDo toDo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key, toDo.getKey());
        contentValues.put(title, toDo.getTitle());
        contentValues.put(description, toDo.getDescription());
        contentValues.put(date, toDo.getDate());
        contentValues.put(status, toDo.getStatus());
        return sqLiteDatabase.insert(toDoTable, null, contentValues);
    }

    public Cursor getDataToDoByKey (String key) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from "+ toDoTable +" where key = ? ";
        return sqLiteDatabase.rawQuery(query, new String[]{key});
    }

    public long createData (ContentValues contentValues) {
        return this.getWritableDatabase().insert(TableName, null, contentValues);
    }

    public long createData (String tableName, ContentValues contentValues) {
        return this.getWritableDatabase().insert(tableName, null, contentValues);
    }

    public Cursor selectData (String value) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.query(TableName, new String[]{ Column1, Column2}, Column1 + " = ? ", new String[]{value}, null, null, null);

    }

    public Cursor selectDataRaw () {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from " + TableName;
        return sqLiteDatabase.rawQuery(query, new String[]{});
    }

    public Cursor getDataToDo () {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from " + toDoTable;
        return sqLiteDatabase.rawQuery(query, new String[] {});
    }

}
