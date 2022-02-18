package pers.wmx.springbootfreemarkerdemo.alg.search;

/**
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class BinarySearch {
    public static int binarySearch(int []arr,int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch1(int []arr,int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // 整数溢出问题
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }

        return -1;
    }


    /*
     * 关于二分查找，如果条件稍微变换一下，
     * 比如：数组之中的数据可能可以重复，要求返回匹配的数据的最小（或最大）的下标；
     * 更近一步， 需要找出数组中第一个大于key的元素（也就是最小的大于key的元素的）下标，等等。
     * */

    //查找第一个与key相等的元素
    public static int binarySearchMin(int []arr,int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // 整数溢出问题
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                //如果mid已经到0了或者mid前面没有等于目标值得
                if(mid == 0 || arr[mid-1] != key){
                    return mid;
                }else {
                    // 前面还有相等的，继续往前推
                    high = mid -1;
                }
            }
        }

        return -1;
    }

    //查找最后一个与key相等的元素
    public static int binarySearchMax(int []arr,int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                //如果mid已经到0了或者mid前面没有等于目标值得
                if(mid == arr.length - 1 || arr[mid+1] != key){
                    return mid;
                }else {
                    // 前面还有相等的，继续往前推
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int []arr = {1, 1, 3, 5, 5, 8, 9};
        int index = binarySearch(arr, 5);
        System.out.println(index);

        int index1 = binarySearch1(arr, 3);
        System.out.println(index1);

        int indexMin = binarySearchMin(arr, 5);
        System.out.println(indexMin);

        int indexMax = binarySearchMax(arr, 5);
        System.out.println(indexMax);

    }
}