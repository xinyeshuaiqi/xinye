package pers.wmx.springbootfreemarkerdemo.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL(Java Object Layout)
 * 查看对象的内存布局、内存踪迹和引用
 *
 * @author wangmingxin03
 * Created on 2021-11-12
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Throwable.class).toPrintable());

        Object o = new Object();
        System.out.println(ClassLayout.parseClass(o.getClass()).toPrintable());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

//        synchronized (o) {
//            // System.out.println(ClassLayout.parseInstance(o).toPrintable());
//            System.out.println("lock " + Thread.currentThread());
//        }

        Thread t1 = new Thread(() -> {
            synchronized (o) {
                System.out.println("lock " + Thread.currentThread());
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println("lock " + Thread.currentThread());
            }
        });

        t1.start();
        t2.start();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }
}
