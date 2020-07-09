package LeetCode;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class LeetCode_059 {

    // 和54题思路一样。
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (true) {
            // 从左往右填充
            for (int i = left; i <= right; i++) ans[top][i] = num++;
            if (++top > bottom) break; // 重新设定上边界
            // 从上往下填充
            for (int i = top; i <= bottom; i++) ans[i][right] = num++;
            if (--right < left) break; // 重新设定右边界
            // 从右往左填充
            for (int i = right; i >= left; i--) ans[bottom][i] = num++;
            if (--bottom < top) break;  // 重新设定下边界
            // 从下往上填充
            for (int i = bottom; i >= top; i--) ans[i][left]= num++;
            if (++left > right) break; // 重新设定左边界
        }
        return ans;
    }
}
