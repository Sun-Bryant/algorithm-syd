package LeetCode;

/**
 *
 */
public class LeetCode_028 {

    /**
     * 截取子串逐一比较
     */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if(haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 双指针 + 回溯
     */
//    public int strStr(String haystack, String needle) {
//        int ans = -1;
//        if (haystack.length() < needle.length()) {
//            return -1;
//        }
//        if (needle.length() == 0) {
//            return 0;
//        }
//        int i = 0, j = 0;
//        while (i < haystack.length() && j < needle.length()) {
//            if (haystack.charAt(i) != needle.charAt(j)) {
//                i = i - j + 1;
//                j = 0;
//            } else {
//                i++;
//                j++;
//            }
//        }
//        if (j == needle.length()) {
//            return i - needle.length();
//        } else {
//            return ans;
//        }
//    }
}
