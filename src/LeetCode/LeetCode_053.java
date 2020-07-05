package LeetCode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class LeetCode_053 {

    /**
     * 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
     * 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
     * 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
     * 该算法可看成动态规划的一个例子。
     * 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
     * 其中(sum[i]记录以a[i]为子序列末端的最大子序列连续和)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int[] dp = new int[nums.length]; // dp数组保存每一个以当前节点结束的最大子序列连续和。
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    /**
     * 考虑到 f(i) 只和 f(i - 1) 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i - 1) 的值是多少，
     * 从而让空间复杂度降低到 O(1)O(1)，
     */
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int ans = nums[0];
//        int pre = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            pre = Math.max(pre + nums[i], nums[i]);
//            if (pre > ans) {
//                ans = pre;
//            }
//        }
//        return ans;
//    }
}
