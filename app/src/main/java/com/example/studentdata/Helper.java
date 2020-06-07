package com.example.studentdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper {
    public static final String mydb = "mydb";
private Context context;
    public Helper(@Nullable Context context) {
        super(context, mydb, null, 1);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Student(FNAME TEXT,LNAME TEXT,CLASS TEXT,ROll INTEGER PRIMARY KEY,GRADE INTEGER,CONTACT INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Dataitem> listDetails(){
        String sql = "select * from " + "Student";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Dataitem> storeDetails = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{

                String fname = cursor.getString(0);
                String lname = cursor.getString(1);
                String grade=cursor.getString(4);
                storeDetails.add(new Dataitem(fname,lname,grade));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeDetails;
    }
    public boolean insert(String fname,String lname,String class_name, String roll, String grade,String contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", fname);
        contentValues.put("LNAME", lname);
        contentValues.put("CLASS", class_name);
        contentValues.put("ROLLNO", roll);
        contentValues.put("GRADE", grade);
        contentValues.put("CONTACT", contact);
        long result = sqLiteDatabase.insert("Student", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean LogInData(String roll,String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM Student WHERE ROLLNO=roll and PASSWORD=pass", null);

            return true;
        }


    public Cursor getAllData() {
        String query="SELECT * FROM Student";
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=null;

        if(database != null)
        {
            cursor=database.rawQuery(query,null);
        }
        return cursor;
    }



}
