package LeetCode;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 *  解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class LeetCode_050 {

    /**
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     * 快速幂递归版
     */
//    public double myPow(double x, int n) {
//        long N = (long)n; //使用long ，是为了防止溢出。比如  -Integer.MIN_VALUE 就会超出int范围。
//        return n < 0 ? 1 / quickPow(x, -N) : quickPow(x, N);
//    }
//    public double quickPow(double x, long n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        double y = quickPow(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }

    /**
     * 快速幂迭代版 -- 位运算
     *
     * 假设求a^b,按照朴素算法就是把a连乘b次，这样一来时间复杂度是O(n)级，快速幂能做到O(logn)
     * 首先把b写成它的二进制形式，设该二进制数第i位的权值为2^(i-1)，i * 2^(i-1)是每一次要做的乘方次数
     * 那么假设b=11，11的二进制是1011，11 = 2³×1 + 2²×0 + 2¹×1 + 2º×1=2³+2¹+2º，所以：a¹¹= a^2º* a ^2¹ * a^2³
     *
     * 代码中n&1是取末位，只有当前位为1时才要乘； n/=2是将n右移一位，取新的位做末位；x*=x就是X^(2^i)，是下一次要乘的因子
     */
    public double myPow(double x, int n) {
        long N = (long)n;
        return n < 0 ? 1 / quickPow(x, -N) : quickPow(x, N);
    }
    public double quickPow(double x, long n) {
        double ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) { // n & 1 是为了取最末尾的数字。
                ans *= x;
            }
            x *= x;
            n = n >> 1;   // 右移
        }
        return ans;
    }


}
