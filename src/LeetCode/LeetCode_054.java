package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LeetCode_054 {

    /**
     * 思路：
     * 首先设定上下左右边界
     * 其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
     * 判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
     * 若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
     * 不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        // 定义边界
        int top = 0; // 上边界
        int bottom = matrix.length - 1; // 下边界
        int left = 0;  // 左边界
        int right = matrix[0].length - 1;  // 右边界

        while(true) {
            // 从左往右移动
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            if (++top > bottom) break; // 重新设定上边界
            // 从上往下移动
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            if (--right < left) break;  // 重新设定右边界
            // 从右往左移动
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            if (--bottom < top) break;  // 重新设定下边界
            // 从下往上移动
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            if(++left > right) break; // 重新设定左边界
        }
        return list;
    }
}
