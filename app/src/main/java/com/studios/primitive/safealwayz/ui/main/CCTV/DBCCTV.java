package com.studios.primitive.safealwayz.ui.main.CCTV;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBCCTV extends SQLiteOpenHelper {

    public static final String CAMERAS = "CAMERAS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";

    public DBCCTV(@Nullable Context context) {
        super(context, "cctv.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CAMERAS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT UNIQUE)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addCamera(CCTVModel cctvModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, cctvModel.getCameraName());
        long insert = db.insert(CAMERAS, null, cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<CCTVModel> getAllCameras(){
        List<CCTVModel> rtnList = new ArrayList<>();
        String queryCommand = "SELECT * FROM " + CAMERAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryCommand,null);
        if(cursor.moveToFirst()){
            do{
                int cameraID = cursor.getInt(0);
                String cameraName = cursor.getString(1);

                CCTVModel newCamera = new CCTVModel(cameraName);
                newCamera.setId(cameraID);
                rtnList.add(newCamera);

            }while(cursor.moveToNext());
        }else{
            //returns an empty list
        }
        cursor.close();
        db.close();
        return rtnList;
    }

    public CCTVModel getCamera(String name){
        CCTVModel camera = new CCTVModel();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryCommand = "SELECT * FROM " + CAMERAS + " WHERE "+ COLUMN_NAME + " = "+ "'" + name +"'";
        Cursor cursor = db.rawQuery(queryCommand,null);
        if(cursor.moveToFirst()){
            do{
                int cameraID = cursor.getInt(0);
                String cameraName = cursor.getString(1);

                camera.setId(cameraID);
                camera.setCameraName(cameraName);
            }while(cursor.moveToNext());
        }else{
            //returns an empty list
        }
        cursor.close();
        db.close();
        return camera;
    }

    public boolean deleteCamera(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryCommand = "DELETE FROM "+ CAMERAS + " WHERE " + COLUMN_NAME + " = " + name;
        Cursor cursor = db.rawQuery(queryCommand, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

}
