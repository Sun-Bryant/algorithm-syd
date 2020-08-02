package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class LeetCode_131 {

    /**
     * 参考题解：https://leetcode-cn.com/problems/palindrome-partitioning/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-7/
     * 回溯
     */
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        // 判断回文数的dp数组
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, 0, dp, new ArrayList<>(), ans);
        return ans;
    }

    private void partitionHelper(String s, int start, boolean[][] dp, List<String> path, List<List<String>> res) {
        //到了空串就加到最终的结果中
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
        }
        //在不同位置切割
        for (int i = start; i < s.length(); i++) {
            //如果是回文串就加到结果中
            if (dp[start][i]) {
                // 做选择
                String left = s.substring(start, i + 1);
                path.add(left);
                // 递归
                partitionHelper(s, i + 1, dp, path, res);
                //  撤销选择
                path.remove(path.size() - 1);
            }

        }
    }


}
