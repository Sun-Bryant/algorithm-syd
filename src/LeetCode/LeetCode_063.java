package LeetCode;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *  输入:
 *  [
 *    [0,0,0],
 *    [0,1,0],
 *    [0,0,0]
 *  ]
 *  输出: 2
 * 解释:
 *  3x3 网格的正中间有一个障碍物。
 *  从左上角到右下角一共有 2 条不同的路径：
 *  1. 向右 -> 向右 -> 向下 -> 向下
 *  2. 向下 -> 向下 -> 向右 -> 向右
 */
public class LeetCode_063 {

    // 动态规划
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][]  dp = new int[n][m];
        // 初始化行
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 初始化列
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0}, {1, 0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }
}