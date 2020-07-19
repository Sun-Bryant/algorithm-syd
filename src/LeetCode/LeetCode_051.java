package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class LeetCode_051 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        // record[0] ?  record[1]  ?  record[2]
        int[] record = new int[n]; // record[i] -> i行的皇后，放在了第几列
        process1(0, record, n, ans);
        return ans;
    }

    // 潜台词：record[0..i-1]的皇后，任何两个皇后一定都不共行、不共列，不共斜线
    // 目前来到了第i行
    // record[0..i-1]表示之前的行，放了的皇后位置
    // n代表整体一共有多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    public int process1(int i, int[] record, int n, List<List<String>> ans) {
        if (i == n) { // 终止行
            List<String> list = new ArrayList<>();
            for (int x = 0; x < n; x++){
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    if (record[x] == y) { // 第x行皇后的位置 == y
                        sb.append('Q');
                        continue;
                    }
                    sb.append('.');
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前行在i行，尝试i行所有的列  -> j
            // 当前i行的皇后，放在j列，会不会和之前(0..i-1)的皇后，不共行共列或者共斜线，
            // 如果是，认为有效
            // 如果不是，认为无效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n, ans);
            }
        }
        return res;
    }

    // record[0..i-1]你需要看，record[i...]不需要看
    // 返回i行皇后，放在了j列，是否有效
    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

}
