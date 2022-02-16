package pers.wmx.springbootfreemarkerdemo.alg.sort;

import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.printArray;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 *
 * O(nlogn)
 * 最坏复杂度 O(n^2)
 *
 * 不是稳定的排序
 */
public class QuickSort {
    public static void quickSort(int[] a,int low,int high) {
        if (low < high) {
            int keyLocation = partition(a, low, high);
            quickSort(a, low, keyLocation - 1);
            quickSort(a, keyLocation + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high;

        // 找一个基准(就以第一个数为基准)，左边的数小于等于基准，右边的数大于等于基准
        int key = a[i];

        while (i < j) {
            while (i < j && a[j] >= key) {
                // a[j]大于基准，a[j]不动
                j--;
            }

            // 跳出循环 说明出现第一个小于key的数了，扔到key左边去
            // a[i] 本事是基准，被替换成比基准小的数了
            a[i] = a[j];

            while (i < j && a[i] <= key) {
                i++;
            }

            // 跳出循环 说明出现第一个大于key的数了，扔到key右边去，之前原a[j]值已经被扔到a[i]了
            a[j] = a[i];
        }

        // i、j碰面了，说明左边不存在大于key的数了，右边不存在小于key的数了
        // 以key为准，把数往2边扔，只能保证key相对于左区间、右区间有序，不能保证区间内有序
        // 因此还需要对左右区间做区间内排序
        a[i] = key;
        return i;
    }

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 4, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
