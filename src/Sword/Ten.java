package Sword;

/**
 * 10、矩形覆盖
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路:可以简单得知当n=1时，结果有1种;
 *               当n=2时，结果有2种;
 *               当n=3时，结果有3种;
 *               当n=4时，结果有5种;
 *                 | 1             ,(n=1 )
 *   于是推测 f(n)=  | 2             ,(n=2 )
 *                  | f(n-1)+f(n-2) ,(n>=3)
 */
public class Ten {
    /**
     * 递归版本
     *
     * 运行时间：521ms
     * 占用内存：9408k
     */
//    public static int RectCover(int target) {
//        if (target <= 0) {
//            return 0;
//        }
//        if (target == 1) {
//            return 1;
//        }
//        if (target == 2) {
//            return 2;
//        }
//        return RectCover(target - 1) + RectCover(target - 2);
//    }

    /**
     * 非递归版本
     *
     * 运行时间：19ms
     * 占用内存：9172k
     */
    public static int RectCover(int target) {
        int preNum = 2;
        int prePreNum = 1;
        int result = 0;
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        for (int i = 3; i <= target; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(RectCover(i));
        }
    }
}
