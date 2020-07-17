package LeetCode;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class LeetCode_091 {

    /**
     * 动态规划
     * 用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式
     *
     * 题解：
     * https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
     */
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];  // 以当前位置i为起始点的总数。
        dp[len] = 1; // 初始化
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {  // 以0开始的，就是0；
                dp[i] = 0;
                continue;
            }
            int ans1 = dp[i + 1];  // 第一种情况，以当前位置i的数量。
            int ans2 = 0; // 第二种情况，以当前i位置和i+1位置合在一起的数量。
            int ten = s.charAt(i) - '0';
            int one = s.charAt(i + 1) - '0';
            int num = ten * 10 + one;
            if (num <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
