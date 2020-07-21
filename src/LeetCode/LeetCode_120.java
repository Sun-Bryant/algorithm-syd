package LeetCode;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class LeetCode_120 {

    /**
     * 动态规划
     * 定义二维 dp 数组，「自底向上的递推」。
     *
     * 1、状态定义：
     * dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
     *
     * 2、状态转移：
     * dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 空间优化
     * 在上述代码中，我们定义了一个 N 行 N 列 的 dp 数组（N 是三角形的行数）。
     * 但是在实际递推中我们发现，计算 dp[i][j] 时，只用到了下一行的 dp[i + 1][j] 和 dp[i + 1][j + 1]。
     * 因此 dp 数组不需要定义 N 行，只要定义 1 行就阔以啦。
     * 所以我们稍微修改一下上述代码，将 i 所在的维度去掉（如下），就可以将 O(N^2)的空间复杂度优化成 O(N)
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[] dp = new int[n + 1];
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
//            }
//        }
//        return dp[0];
//    }

    /**
     * 动态规划  -- 自己写的 太烂了
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int[][] dp = new int[triangle.size()][triangle.size()];
//        for (int i = 0; i < triangle.size(); i++) {
//            for (int j = i + 1; j < triangle.size(); j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        dp[0][0] = triangle.get(0).get(0);
//        for (int i = 1; i < triangle.size(); i++) {
//            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
//            for (int j = 1; j <= i; j++) {
//                int m = dp[i - 1][j];
//                int n = dp[i - 1][j - 1];
//                dp[i][j] = triangle.get(i).get(j) + Math.min(m, n);
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < triangle.size(); i++) {
//            res = Math.min(res, dp[triangle.size() - 1][i]);
//        }
//        return res;
//    }
}
