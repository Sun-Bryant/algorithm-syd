package Sword;

/**
 * 12、数值的整数次方
 *
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Twelve {

    /**
     * 第一种：调用API
     *
     * 运行时间：53ms
     * 占用内存：10120k
     */
//    public static double Power(double base, int exponent) {
//        return Math.pow(base, exponent);
//    }

    /**
     * 第二种：循环相乘
     *
     * 运行时间：60ms
     * 占用内存：10800k
     * 时间复杂度：O(n)
     */
//    public static double Power(double base, int exponent) {
//        double result = 1;
//        if (exponent >= 0) {
//            for (int i = 0; i < exponent; i++) {
//                result = result * base;
//            }
//        } else {
//            for (int i = 0; i < -exponent; i++) {
//                result = result * base;
//            }
//            result = 1.0 / result;
//        }
//        return result;
//    }

    /**
     * 第三种： 快速幂算法
     *
     * 运行时间：46ms
     * 占用内存：10456k
     *
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     *
     * 快速幂：https://www.cnblogs.com/yewanting/p/10743018.html
     */
    public static double Power(double base, int exponent) {
        double result = 1;
        double cur = base;
        int index = exponent;
        //全面考察指数的正负、底数是否为零等情况。
        if (exponent > 0) {
            index = exponent;
        } else if (exponent < 0) {
            index = -exponent;
        } else { // exponent == 0
            return 1;
        }

        while (index != 0) {
            if ((index & 1) == 1) {
                result *= cur;
            }
            cur *= cur;//翻倍
            index = index >> 1; // 右移一位
        }
        return exponent > 0 ? result : (1.0 / result);
    }


    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

}
