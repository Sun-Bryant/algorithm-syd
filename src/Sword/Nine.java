package Sword;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 9、变态跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Nine {
    /**
     * 递归版本
     *
     * 运行时间：16ms
     * 占用内存：9220k
     */
//    public static int JumpFloorII(int target) {
//        if (target == 0) {
//            return 1;
//        }
//        if (target == 1) {
//            return 1;
//        }
//        return 2 * JumpFloorII(target - 1);
//    }

    /**
     * 非递归版本
     *
     * 运行时间：15ms
     * 占用内存：9300k
     */
    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return 1;
        }
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(JumpFloorII(i));
        }
    }

    /**
     * 关于本题，前提是n个台阶会有一次n阶的跳法。分析如下:
     * f(1) = 1
     * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
     * f(3) = f(3-1) + f(3-2) + f(3-3)
     * ...
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     * 说明：
     * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
     * 2） n = 1时，只有1种跳法，f(1) = 1
     * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     *     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     *     因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     *     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     *
     * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *     可以得出：
     *     f(n) = 2*f(n-1)
     * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *               | 1       ,(n=0 )
     *
     *    f(n) =     | 1       ,(n=1 )
     *
     *               | 2*f(n-1),(n>=2)
     */

}