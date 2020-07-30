package com.dlf.a7_30_work.single;


/**
 * 1.饿汉式:不管需不需要，直接将对象提前创建好
 * 好处：线程安全
 * 缺点：浪费内存
 */
public class SingleTon {
    private SingleTon sSingleTon = new SingleTon();
    private SingleTon() {
    }

    public SingleTon getsSingleTon() {
        if (sSingleTon == null) {
            sSingleTon = new SingleTon();
        }
        return sSingleTon;
    }
}
