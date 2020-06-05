package LeetCode;


public class LeetCode_005 {

    /**
     * 采用中心扩散思想，马拉车算法。
     *
     * 具体题解参考：
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1; // 记录回文串的最大长度，初始值为1.

        int start = 0;
        String newStr = addBoundaries(s, '#');
        for (int i = 0; i < newStr.length(); i++) {
            int len = centerSpread(newStr, i);
            if (len > maxLen) {
                maxLen = len;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     *
     * @param s
     * @param i
     * @return  返回值为中心扩散可以扩散的步数。
     */
    public int centerSpread(String s, int i) {
        int len = s.length();
        int left = i - 1;
        int right = i + 1;
        int step = 0;
        while(left >=0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            step++;
        }
        return step;
    }

    // 给字符串s添加边界。
    public String addBoundaries(String s, char divide) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(divide);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append(divide);
        }
        return sb.toString();
    }
}
