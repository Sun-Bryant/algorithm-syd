package Sword;

/**
 * 53、表示数值的字符串
 *
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class FiftyThree {

    /**
     * 思路：正则表达式
     *
     * 运行时间：24ms
     * 占用内存：9368k
     *
     * []   :  字符集合
     * ()   :  分组
     * ?    :  重复0~1次
     * +    :  重复1~n次
     * *    :  重复0~n次
     * .    :  任意字符
     * \\.  :  转义后的.
     * \\d  :  数字
     *
     * 以下对正则进行解释:
     * [+-]?                -> 正或负符号出现与否
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
     *                         否则一起不出现
     * ([eE][+-]?\\d+)?     -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
     *                         紧接着必须跟着整数；或者整个部分都不出现
     */
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println(isNumeric(".".toCharArray()));
    }
}
