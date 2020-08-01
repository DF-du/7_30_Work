package com.dlf.project.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dlf.project.bean.FuliBean;

import java.util.ArrayList;
import java.util.List;


public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "dlf.db", null, 1);
    }


    /**
     * @param context 上下文
     * @param name    数据库名
     * @param factory
     * @param version 版本号
     */

    /**
     * 当传进来的数据库名没找到时，创建该数据库，并执行方法
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //随机创建一张表
        db.execSQL("create table dlf(_id text,url text,des text)");
    }

    //更新版本时执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserts(FuliBean.ResultsBean bean) {
        ContentValues valus = new ContentValues();
        valus.put("_id", bean.get_id());
        valus.put("url", bean.getUrl());
        valus.put("des", bean.getDesc());
        getWritableDatabase().insert("dlf", null, valus);
    }

    public void deletes(String id) {
        getWritableDatabase().delete("dlf", "_id = ?", new String[]{id});
    }

    public List<FuliBean.ResultsBean> queryAll() {
        List<FuliBean.ResultsBean> list = new ArrayList<>();
        Cursor dlf = getReadableDatabase().query("dlf", null, null, null, null, null, null);
        while (dlf.moveToNext()) {
            FuliBean.ResultsBean bean = new FuliBean.ResultsBean();
            bean.set_id(dlf.getString(dlf.getColumnIndex("_id")));
            bean.setUrl(dlf.getString(dlf.getColumnIndex("url")));
            bean.setDesc(dlf.getString(dlf.getColumnIndex("des")));
            list.add(bean);
        }
        return list;
    }

    public FuliBean.ResultsBean queryItem(String _id) {
        Cursor dlf = getReadableDatabase().query("dlf", null, "_id = ?", new String[]{_id}, null, null, null);
        FuliBean.ResultsBean bean = new FuliBean.ResultsBean();
        String id = dlf.getString(dlf.getColumnIndex("_id"));
        String url = dlf.getString(dlf.getColumnIndex("url"));
        String des = dlf.getString(dlf.getColumnIndex("des"));
        bean.set_id(id);
        bean.setUrl(url);
        bean.setDesc(des);
        return bean;
    }
}
