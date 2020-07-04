package LeetCode;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class LeetCode_048 {

    // 先将最外围进行旋转 然后逐次到最内层
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        if (n <= 1) return;
        // 先将最外围进行旋转 然后逐次到最内层
        for (int i = 0; i < n >> 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j]; // 列变行 行变列 需要注意行列的特殊处理。
                // 举例 matrix[i][j] = matrix[n - 1 - j][i];
                // 1）列变行 行变列 matrix[j][i];  2) 行位置变了 所以matrix[i][j] = matrix[n - 1 - j][i]
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    // 转置 + 按列翻转
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        // 转置
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n ; j++) {
//                int temp = matrix[j][i];
//                matrix[j][i] = matrix[i][j];
//                matrix[i][j] = temp;
//            }
//        }
//        // 按列翻转
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n / 2 ; j++) {
//                int temp = matrix[i][n - 1 - j];
//                matrix[i][n - 1 - j] = matrix[i][j];
//                matrix[i][j] = temp;
//            }
//        }
//    }

    // 时候用额外数组，并不是原地翻转
//    public void rotate(int[][] matrix) {
//        int[][] temp = new int[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length ; j++) {
//                temp[j][matrix.length - 1 - i] = matrix[i][j];
//            }
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length ; j++) {
//                matrix[i][j] = temp[i][j];
//            }
//        }
//    }
}
