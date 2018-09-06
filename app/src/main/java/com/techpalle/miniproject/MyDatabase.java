package com.techpalle.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase {
    MyHelper mh;
    SQLiteDatabase sdb;

    public MyDatabase(Context c){
        mh = new MyHelper(c,"univ.db",null,1);
    }
    public void open(){
        sdb = mh.getWritableDatabase();
    }

    public void insertStudent(String sno,String sname,String mobile,String email,String course,String date){
        ContentValues cv = new ContentValues();
        cv.put("sno",sno);
        cv.put("sname",sname);
        cv.put("mobile",mobile);
        cv.put("email",email);
        cv.put("course",course);
        cv.put("date",date);
        sdb.insert("study",null,cv);
    }
    public Cursor queryTable(){
        Cursor c = sdb.query("study",null,null,null,null,null,null);
        return c;
    }
    public Cursor queryStudent(String course){
        Cursor c = sdb.query("study",null,"course=?",new String[]{course},null,null,null);
        return c;
    }
    public Cursor queryCustom(String namePh){
        Cursor c = sdb.query("study",null,"sname=? OR mobile=?",new String[]{namePh},null,null,null);
        return c;
    }
    public void close(){
        if (sdb != null){
            sdb.close();
        }
    }

    public class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table study(_id integer primary key,sno text,sname text,mobile text,email text,course text,date text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
