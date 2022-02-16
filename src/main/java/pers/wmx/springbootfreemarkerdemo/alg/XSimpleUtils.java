package pers.wmx.springbootfreemarkerdemo.alg;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 */
public class XSimpleUtils {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] a) {
        for(int i = 0; i< a.length; i++) {
            System.out.print(a[i]);
        }
    }

}
