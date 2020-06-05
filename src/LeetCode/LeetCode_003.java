package LeetCode;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *  输入: "abcabcbb"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *  输入: "bbbbb"
 *  输出: 1
 *  解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *  输入: "pwwkew"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LeetCode_003 {

    /**
     * 这道题主要用到思路是：滑动窗口
     *
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的abcabcbb，进入这个队列（窗口）为abc满足题目要求，
     * 当再进入a，队列变成了abca,这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     * 我们只要把队列的左边的元素移出，直到满足题目要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：O(n)
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int start = 0, end = 0;
        for (end = 0; end <s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                // 必须是start和map.get(s.charAt(end))中的最大值，
                // 其实start相当于滑动窗口的一个左边界，如果你需要删除窗口左边的数据，则不能越过这个左边界。
                // 反例 eg: abba
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
