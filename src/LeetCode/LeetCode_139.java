package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class LeetCode_139 {

    /**
     * 动态规划
     * 题目说：s 串能否分解为单词表里的单词，即：前 s.length 个字符的 s 串能否分解为单词表里的单词
     * 将大问题分解为子问题：
     * 前 x 个字符的子串能否分解成单词表里的单词 + 剩余子串是否为单词表中的单个单词
     *
     * 状态转移方程：
     * 用指针 j 去划分这两部分
     * [0, i] 区间子串 的 dp[i+1] 是否为真，取决于两部分：
     * 它的前缀子串 [0, j-1] 的 dp[j] 是否为真
     * 剩余子串 [j,i] 是否是一个合格的单词
     *
     * base case：
     * dp[0] = true。长度为 0 的子串是由单词表的单词组成的。是很诡异。
     * 但这纯粹是为了让边界情况也能满足状态转移方程，即上图：当黄色部分为空字符串时，dp[i+1]dp[i+1] 全然取决于 [0,i][0,i] 子串是否是单词表的单词
     * 所以我们让 dp[0] = true
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] == true) break; // 遇到 dp[i] == true ，直接break
                if (dp[j] == false) continue; //遇到 dp[j] == false， dp[i] 没有 true 的可能，continue，考察下一个 j
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
