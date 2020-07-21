package LeetCode;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class LeetCode_125 {


    // 最简单的就是使用双指针，一个指向前，一个指向后，遇到空格以及特殊字符要跳过，然后判断
//    public boolean isPalindrome(String s) {
//        if (s.isEmpty())
//            return true;
//        int left = 0, right = s.length() - 1;
//        while (left < right) {
//            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
//                left++;
//            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
//                right--;
//            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
//                return false;
//            left++;
//            right--;
//        }
//        return true;
//    }

    public boolean isPalindrome(String s) {
        // 全部转化为大写字母
        String str = s.toUpperCase();
        // 把数字和字母加入到StringBuilder。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        // 双指针判断回文
        int i = 0;
        int j = sb.length() - 1;
        while(i <= j) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
