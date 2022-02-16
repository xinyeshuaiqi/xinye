package pers.wmx.springbootfreemarkerdemo.alg;

import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.printArray;
import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.swap;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 *
 * O（n^2）
 */
public class InsertSort {
    public static void insertSort(int []arr){

        // 我们认为左边是有序的,从有序的下一个开始往前插，和前面的一一对比
        for (int i = 1; i < arr.length; i++) {
            // 非有序区间的第一个数和有序区件最后一个数比较（即有序区最大的数）
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 8, 8, 1};
        insertSort(arr);
        printArray(arr);
    }
}
