package LeetCode;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *  输入: 4
 *  输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class LeetCode_069 {

    // 二分法
    public int mySqrt(int x) {
        if (x == 0 || x == 1){ // 特殊数据的处理
            return x;
        }
        long left = 0;
        long right = x / 2;
        while (left < right) {
            long mid = left + (right - left + 1) / 2; //注意这里取右中位数，取左中位数会陷入死循环，比如x=9;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }
}
