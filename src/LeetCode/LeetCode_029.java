package LeetCode;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 *  输入: dividend = 10, divisor = 3
 *  输出: 3
 *  解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 *  输入: dividend = 7, divisor = -3
 *  输出: -2
 *  解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * 提示：
 *  被除数和除数均为 32 位有符号整数。
 *  除数不为 0。
 *  假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 *  本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class LeetCode_029 {
    /**
     * 采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），同时 ans 每次加2^n
     *
     * 例如：   10   3
     *  第一次： 10 - 3*2^1 = 4       ans + 2^1
     *  第二次： 4 - 3*2^0 = 1        ans + 2^0
     *  第三次： 1 < 3        结束
     *
     *  将被除数和除数都转成正数或负数进行计算，
     *  由于在Java中，当t=Integer.MIN_VALUE时（t取相反数依旧是它本身）此时可能存在越界问题，
     *  因此都用负数进行计算。
     */
    public int divide(int dividend, int divisor) {
        // 当dividend=Integer.MIN_VALUE，divisor=-1时，结果越界，将该情况特殊处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        boolean flag = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int ans = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while(dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                temp = temp<<1;
                c = c<<1;
            }
            dividend = dividend - temp;
            ans += c;
        }
        return flag ? -ans : ans;
    }
}
