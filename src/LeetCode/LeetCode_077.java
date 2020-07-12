package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LeetCode_077 {

    // 回溯
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, n, k, 1);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int n, int k, int begin){
        if (path.size() == k) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            if (path.contains(i)) continue;
            // 做选择
            path.add(i);
            // 递归
            dfs(ans,path, n, k, i + 1); // 注意这里传入 i + 1, 不是begin + 1。
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
