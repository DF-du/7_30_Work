package com.dlf.project.sql;

import com.dlf.project.bean.SqlBean;

public class SQLUtil {
    public static void insert(String desc,String url) {
        String insert = "insert into dlf(desc,url) values(?,?)";
    }

    public static void delete(SqlBean sqlBean) {
        String delete = "delete from dlf where _id = ?";
    }

    public static void query(String desc,String url) {
        String query = "select * from dlf where _id = ?";
    }

    public static void query_where(int id) {
        String delete = "delete from dlf";
    }
}
