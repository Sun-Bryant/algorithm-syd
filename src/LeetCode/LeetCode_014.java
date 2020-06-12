package LeetCode;

/**
 * 14. 最长公共前缀 (LCP)
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *  输入: ["flower","flow","flight"]
 *  输出: "fl"
 *
 * 示例 2:
 *  输入: ["dog","racecar","car"]
 *  输出: ""
 *  解释: 输入不存在公共前缀。
 *
 * 说明:所有输入只包含小写字母 a-z 。
 *
 *
 */
public class LeetCode_014 {

    /**
     * 水平扫描
     * 我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）
     * 然后再进行对下一列的比较。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
