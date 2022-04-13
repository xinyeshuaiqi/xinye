package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 数组 排序 
// 👍 65 👎 0


import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        Solution solution = new RemoveCoveredIntervals().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 按照区间起点升序，起点相同的话按照终点降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int needMergeIntervals = 0;

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            if (left <= curLeft && right >= curRight) {
                needMergeIntervals++;
            } else if (right >= curLeft && right <= curRight) {
                // 相交
                right = curRight;
            } else if (right < curLeft) {
                left = curLeft;
                right = curRight;
            }
        }

        return intervals.length - needMergeIntervals;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

