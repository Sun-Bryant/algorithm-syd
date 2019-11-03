package Sword;

/**
 * 2、替换空格
 *
 * 题目描述:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Two {

    /**
     *运行时间：22ms
     *占用内存：9544k
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "We Are Happy.";
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(replaceSpace(sb));
    }
}
