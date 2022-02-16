package pers.wmx.springbootfreemarkerdemo.alg.sort;

import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.printArray;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 *
 * 稳定排序
 * O(nlogn)
 *
 * 分而治之
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int l, int h) {
        if (l == h) {
            return;
        }

        int mid = (l + h) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);
        merge(arr, l, mid, h);
    }

    private static void merge(int[] arr, int l, int mid, int h) {
        // arr[l ~ mid] merge arr[mid+1 ~ h]

        int[] temp = new int[h - l + 1];

        // 临时数组的增长指针
        int index = 0;

        // 2个有序数组的指针
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= h) {
            if (arr[p1] <= arr[p2]) {
                temp[index] = arr[p1];
                index ++;
                p1 ++;
            } else if (arr[p1] > arr[p2]) {
                temp[index] = arr[p2];
                index ++;
                p2 ++;
            }
        }

        while (p1 <= mid) {
            temp[index] = arr[p1];
            index ++;
            p1 ++;
        }

        while (p2 <= h) {
            temp[index] = arr[p2];
            index ++;
            p2 ++;
        }

        // 重新给 arr[l~r] 赋值
        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 4, 8, 1};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
