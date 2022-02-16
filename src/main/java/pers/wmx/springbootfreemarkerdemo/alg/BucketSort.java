package pers.wmx.springbootfreemarkerdemo.alg;

import static pers.wmx.springbootfreemarkerdemo.alg.XSimpleUtils.printArray;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 * 
 * 时间复杂度 O(n)
 */
public class BucketSort {
    public static void bucketSort(int[] a) {
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 需要准备max+1个桶来装数   比如最大值是6，你需要装0，1，2，3，4，5，6这7个数的桶
        // 恶心的是浪费了比较多的存储空间 =-=
        // FIXME: 空间复杂度
        int []bucket = new int[max + 1];

        for (int i = 0; i < a.length; i++) {
            // 填充桶
            bucket[a[i]] ++;
        }

        // 依据桶回填到数组，这样桶是从小到大的，回填后的数组也是有序的了
        int index = 0;
        for (int i = 0; i < bucket.length; i++){
            int bucketCount = bucket[i];

            // 桶是空的跳过
            if (bucketCount == 0) {
                continue;
            }

            for (int j = 0; j < bucketCount; j++) {

                // FIXME: 嵌套循环
                a[index] = i;
                index ++;
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 8, 8, 1};
        bucketSort(arr);
        printArray(arr);
    }

}
