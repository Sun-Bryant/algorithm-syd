package Sword;

import com.sun.xml.internal.ws.server.ServerRtException;

/**
 * 49、把字符串转换成整数
 *
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入：+2147483647
 *      1a33
 * 输出：2147483647
 *      0
 */
public class FortyNine {

    /**
     * 这道题Java选手主要的问题可能大家都是在溢出那边出现问题。（int范围：-2147483648~2147483647）
     *
     * 可以发现每次循环时value的值都会扩大10倍，所以我们是否可以利用 INT_MAX/10 的值来提前一步判断是否会越界呢？答案是可以的。
     * 这里以正数的越界为例：
     * (1)当 value > INT_MAX/10 时，说明本轮扩大10倍后，value 必将越界（超过 INT_MAX）;
     *          eg : 214748365 > 214748364    ==>   214748365 * 10 > 2147483647     ==> 越界
     * (2)当 value == INT_MAX/10 时，说明扩大10倍后，value 可能越界，也可能不越界，需要利用当前位的数字 digit 的大小来进行进一步的判断：当 digit > 7 时，越界；否则，不越界。
     *          eg : 214748364  ==   214748364    ==>   2147483648 > 2147483647     ==> 越界
     * (3)否则，当 value < INT_MAX/10 时，本轮循环必不越界（扩大10倍后也小于 INT_MAX）
     *         eg : 214748363  <   214748364    ==>   214748363 * 10 > 2147483647    ==> 不越界
     *
     * 运行时间：13ms
     * 占用内存：9276k
     */
    public static int StrToInt(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean negative = false;// 判断是否为负数
        int start = 0;  //标记起始点
        if (chars[0] == '-') {
            negative = true;
            start = 1;
        } else if (chars[0] == '+') {
            start = 1;
        }
        int sum = 0;
        if (negative) { // 负数的处理
            for (int i = start; i < str.length(); i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    return 0;
                }
                // 判断的方法是，如果一个int类型的数值的绝对值已经大于“INT_MAX / 10”，或者它等于“INT_MAX / 10”
                // 但是其下一个将要相加的数字大于了8（因为int类型最小值 =-2147483648）,那就说明它溢出了。
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && chars[i] - '0' > 8)) {
                    return 0;
                }
                sum = sum * 10 + (chars[i] - '0');
            }
        } else { // 正数的处理
            for (int i = start; i < str.length(); i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    return 0;
                }
                //判断的方法是，如果一个int类型的数值的绝对值已经大于“INT_MAX / 10”，或者它等于“INT_MAX / 10”
                // 但是其下一个将要相加的数字大于了7（因为int类型最大值=2147483647）,那就说明它溢出了。
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)) {
                    return 0;
                }
                sum = sum * 10 + (chars[i] - '0');
            }
        }
        return (negative == true) ? -sum : sum;
    }

    /**
     * 将正数、负数的越界判断合并起来：
     * 为了保证代码简洁高效，这里我们不得不寻求一种方法，使正数、负数的越界判断可以合并起来进行（同样，这里我们也利用了数值化的正负标记位 isNegtive）：
     * 我们设置一个变量 overValue 来表示当前的值和 INT_MAX/10 的差，因为 INT_MAX/10 为正数，所以当当前值为负数时，需要统一转化为正数，故而有：
     * <p>
     * overValue = isNegtive*value - INT_MAX/10;
     * <p>
     * 这样，当 overValue > 0 时，越界，overValue < 0 时，不越界，而当 overValue == 0 时：
     * 正数时（isNegtive == 1），digit > 7 越界，负数时（isNegtive == -1），digit > 8 越界，通过 (isNegtive+1)/2 来将 -1、1转换为0、1，从而使有关 digit 的判断统一转化为：
     * <p>
     * 当 (isNegtive+1)/2 + digit > 8 时，数值越界；
     * 综上，令：
     * <p>
     * overValue = isNegtive*value - INT_MAX/10
     * + (((isNegtive+1)/2 + digit > 8) ? 1:0);
     * <p>
     * 则当 overValue > 0 时，数值将会越界，反之，则不会.
     * <p>
     * 数值越界，即大于 2147483647，或小于 -2147483648。
     * <p>
     * <p>
     * 运行时间：13ms
     * 占用内存：9400k
     */
//    public static int StrToInt(String str) {
//        if (str == null || "".equals(str)) {
//            return 0;
//        }
//        char[] chars = str.toCharArray();
//        int length = str.length();
//        //数值化的正负标记位 isNegtive
//        int isNegtive = 1, overValue = 0;
//        int digit = 0, value = 0;
//
//        if (length == 0) return 0;
//        else {
//            int idx = 0;
//            if (chars[0] == '-') { isNegtive = -1; idx = 1;}
//            else if (chars[0] == '+') {idx = 1;}
//
//            for (; idx<length; idx++) {
//                digit = chars[idx]-'0';
//                // overValue表示本轮循环是否会越界
//                overValue = isNegtive * value - Integer.MAX_VALUE / 10
//                        + (((isNegtive + 1) / 2 + digit > 8) ? 1 : 0);
//                if (digit < 0 || digit > 9) {
//                    return 0;
//                } else if (overValue > 0) {
//                    return 0;
//                }
//
//                value = value * 10 + isNegtive * digit;
//            }
//            return value;
//        }
//    }
    public static void main(String[] args) {

        System.out.println(StrToInt("+123"));
    }
}
