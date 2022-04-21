package pers.wmx.springbootfreemarkerdemo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author wangmingxin03
 * Created on 2022-04-21
 */
public class ReferenceTest {
    public static void main(String[] args) {
//        SoftReference reference = new SoftReference(new byte[1024 * 1024 * 10]);
//
//        System.out.println("before GC: " + reference.get());
//        System.gc();
//        System.out.println("after GC: " + reference.get());
//
//        byte[] obj = new byte[1024 * 1024 * 10];
//        System.out.println("memory insufficient : " + reference.get());
//        System.out.println("memory insufficient : " + obj);

//        WeakReference weakReference = new WeakReference(new byte[1024 * 1024 * 10]);
//        System.out.println("before GC: " + weakReference.get());
//        System.gc();
//        System.out.println("after GC: " + weakReference.get());


        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference =
                new PhantomReference(new byte[1024 * 1024 * 10], referenceQueue);

        System.out.println("before GC: " + phantomReference.get());
        System.gc();
        System.out.println("after GC: " + phantomReference.get());

    }

}
