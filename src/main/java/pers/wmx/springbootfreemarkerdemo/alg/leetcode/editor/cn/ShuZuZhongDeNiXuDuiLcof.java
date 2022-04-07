package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 697 👎 0


public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private int counter = 0;

    public int reversePairs(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        merge(nums, low, high);
        return counter;
    }

    private void merge(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            merge(nums, low, mid);
            merge(nums, mid + 1, high);
            mergeSort(nums, low, mid, high);
        }
    }

        private void mergeSort(int[] nums, int low, int mid, int high) {
            int[] tempArr = new int[high - low + 1];

            int index = 0;
            int i = low;
            int j = mid + 1;

            while (i <= mid && j <= high) {
                if (nums[i] <= nums[j]) {
                    tempArr[index] = nums[i];
                    i++;
                    index++;
                } else {

                    //右边数组的元素小于左边,将右边数组的元素其放入结果数组中,并让索引j加1
                    //并且此时左边数组中的从i到m的所有数都是大于tmp[j]的
                    // (因为m左右的数组都是已经排好序的 !!!)
                    // 即此时有m-i+1个逆序对，加到res上即可

                    counter += (mid - i + 1);
                    tempArr[index] = nums[j];
                    j++;
                    index++;
                }
            }

            while (i <= mid) {
                tempArr[index] = nums[i];
                i++;
                index++;
            }

            while (j <= high) {
                tempArr[index] = nums[j];
                j++;
                index++;
            }

            for (int k = 0; k < tempArr.length; k++) {
                nums[k + low] = tempArr[k];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

} 

