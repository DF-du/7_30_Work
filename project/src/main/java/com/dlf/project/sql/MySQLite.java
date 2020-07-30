package com.dlf.project.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLite extends SQLiteOpenHelper {
    private Context context;
    private String name;
    private SQLiteDatabase.CursorFactory factory;
    private int version;

    /**
     * @param context 上下文
     * @param name    数据库名
     * @param factory
     * @param version 版本号
     */
    public MySQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        this.name = name;
        this.factory = factory;
        this.version = version;
    }

    /**
     * 当传进来的数据库名没找到时，创建该数据库，并执行方法
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //随机创建一张表
        String sql = "create table dlf(_id integer primary key autoincrement,desc text,url text)";
        db.execSQL(sql);
    }

    //更新版本时执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
