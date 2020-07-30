package com.dlf.a7_30_work.single;

/**
 * 1.懒汉式：
 * 需要的时候才会创建
 * 优点：延迟了对象的实例化
 * 缺点：线程不安全
 */
public class SingleTon2 {
    //java里面的成员变量都有默认值（一般为null）
    //int ，short, double, float (默认值为0或0.0)
    //boolean:(默认为false)
    //引用类型：null
    private static SingleTon2 sSingleTon2;
    private SingleTon2(){}

    public static SingleTon2 getInstance() {
        if (sSingleTon2 == null) {
            sSingleTon2 = new SingleTon2();
        }
        return sSingleTon2;
    }
}
