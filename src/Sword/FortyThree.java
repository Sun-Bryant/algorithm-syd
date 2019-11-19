package Sword;

/**
 * 43、左旋转字符串
 *
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class FortyThree {

    /**
     * 思路："XYZdefabc"循环左移三位，可以变为 "XYZdefabcXYZdefabc"后，再截取n~(n+len)
     *
     * 运行时间：25ms
     * 占用内存：9568k
     */
    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        str += str;
        return str.substring(n, n + len);
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(LeftRotateString(str, 3));
    }
}