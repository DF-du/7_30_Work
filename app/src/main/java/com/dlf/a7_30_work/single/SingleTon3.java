package com.dlf.a7_30_work.single;

/**
 * DCL:Double check lock 综合了懒汉饿汉的优点，解决了缺点
 * 优点：即延迟了对象的实例化，又保证线程的安全
 */
public class SingleTon3 {
    private volatile static SingleTon3 sSingleTon3;

    private SingleTon3() {
    }

    //同步之后，整个方法区域只能有一个线程进去
    //同步效率比较低，但是这个方法每次都要同步
    public static synchronized SingleTon3 getInstance() {
        //只需要在创建对象前同步
        //1.
        if (sSingleTon3 == null) {
            synchronized (SingleTon3.class) {
                if (sSingleTon3 == null) {
                    sSingleTon3 = new SingleTon3();
                }
            }
        }
        return sSingleTon3;
    }
}
