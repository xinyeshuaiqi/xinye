package pers.wmx.springbootfreemarkerdemo.alg.sort;

import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.printArray;
import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.swap;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 *
 * O(n^2)
 * 不是稳定排序
 */
public class SelectSort {
    public static void selectSort(int []arr){
        for (int i = 0; i < arr.length - 1; i++) {
            // i 表示第i轮，要从[i ~ arr.length)找到一个最小值，和i交换位置
            // i的左边有序区：从左到右都是每轮挑选的最小值
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 这里找到了一个最小的index
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 8, 8, 1};
        selectSort(arr);
        printArray(arr);
    }

}
