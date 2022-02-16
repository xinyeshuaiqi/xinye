package pers.wmx.springbootfreemarkerdemo.alg;

/**
 * @author wangmingxin03
 * Created on 2022-02-16
 */
public class BubbleSort {
    public static void bubbleSort(int []arr){
        int len = arr.length;

        //一共n-1躺排序（n个数需要n-1躺排序）  每一趟冒出来一个最大的数
        for (int i =0; i < len-1; i++) {
            //每过一趟排序，j的遍历范围缩减1  （最右边的坑已经被最大的数给占了，现在第二大的数准备入从右往左数的第二个坑...）
            for(int j = 0; j < len - 1 -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

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

    public static void main(String[] args) {
        int []arr = {3, 1, 5, 2, 4, 8, 1};
        bubbleSort(arr);
        printArray(arr);
    }

}
