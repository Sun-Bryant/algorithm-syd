package LeetCode;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 */
public class LeetCode_058 {

    /**
     * 从右向左遍历，从第一个不是空格的字符开始计数，一旦开始计数，再遇到空格就结束了
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
}
