package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 1:
 *  输入:
 *  [
 *    [1,1,1],
 *    [1,0,1],
 *    [1,1,1]
 *  ]
 *  输出:
 *  [
 *    [1,0,1],
 *    [0,0,0],
 *    [1,0,1]
 *  ]
 * 示例 2:
 *  输入:
 *  [
 *    [0,1,2,0],
 *    [3,4,5,2],
 *    [1,3,1,5]
 *  ]
 *  输出:
 *  [
 *    [0,0,0,0],
 *    [0,4,5,0],
 *    [0,3,1,0]
 *  ]
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class LeetCode_073 {
    /**
     * 思路二: 用O(1)额外空间
     * 关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位
     * 但是对于第一行,和第一列要设置一个标志位,为了防止自己这一行(一列)也有0的情况.注释写在代码里,直接看代码很好理解!
     *
     * 时间复杂度：O(M×N)，其中 M 和 N 分别对应行数和列数。
     * 空间复杂度：O(1)。
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean first_row_flag = false;
        boolean first_col_flag = false;
        // 第一行是否有0
        for (int i = 0; i < n; i++){
            if (matrix[0][i] == 0){
                first_row_flag = true;
                break;
            }
        }
        // 第一行是否有0
        for (int j = 0; j < m; j++) {
            if (matrix[j][0] == 0){
                first_col_flag = true;
                break;
            }
        }
        // 寻找0，并把第一行第一列作为标志位
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 置零
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 判断第一行是否需要置零
        if (first_row_flag) {
            for (int i = 0; i < n; i++) matrix[0][i] = 0;
        }
        // 判断第一列是否需要置零
        if (first_col_flag) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

    /**
     * 思路一: 用 O(m+n) 额外空间
     * 两遍扫matrix,第一遍用集合记录哪些行,哪些列有0;第二遍置0
     *
     * 时间复杂度：O(M×N)，其中 M 和 N 分别对应行数和列数。
     * 空间复杂度：O(M+N)。
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        // 第一遍遍历，把位置是0的行和列记录到集合中。
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // 第二遍遍历，置零。
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
