package pers.wmx.springbootfreemarkerdemo.util;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wangmingxin03
 * Created on 2024-07-30
 */
public class ForkJoinPoolUtils {
    public static class FindNumberTask extends RecursiveTask<Integer> {
        private int[] arr;

        public FindNumberTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected Integer compute() {
            if (arr.length < 2) {
                if (arr.length == 1) {
                    return arr[0];
                } else {
                    return Math.max(arr[0], arr[1]);
                }
            } else {
                int mid = arr.length / 2;
                FindNumberTask left = new FindNumberTask(Arrays.copyOf(arr, mid));
                FindNumberTask right = new FindNumberTask(Arrays.copyOfRange(arr, mid, arr.length));
                invokeAll(left, right);
                return Math.max(left.join(), right.join());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 5, 9, 7, 6};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FindNumberTask task = new FindNumberTask(arr);
        forkJoinPool.invoke(task);
        System.out.println(task.join());
    }

}
