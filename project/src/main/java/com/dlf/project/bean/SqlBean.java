package com.dlf.project.bean;

public class SqlBean {
    private Integer _id;
    private String desc;
    private String url;

    public SqlBean(){}
    public SqlBean(Integer _id, String desc, String url) {
        this._id = _id;
        this.desc = desc;
        this.url = url;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SqlBean{" +
                "_id=" + _id +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
