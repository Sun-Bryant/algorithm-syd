package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class LeetCode_022 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs("", n, n, ans);

        return ans;
    }
    public void dfs(String path, int left, int right, List<String> ans){
        if (left ==0 && right ==0){ // 左右括号都不剩余了，递归终止
            ans.add(path);
            return;
        }
        if (left > 0){ // 如果左括号还剩余的话，可以拼接左括号
            dfs(path + "(", left - 1, right, ans);
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(path + ")", left , right - 1, ans);
        }
    }
}
