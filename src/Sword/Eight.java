package Sword;

/**
 * 8、跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Eight {

    /**
     * 递归版本
     *
     * 运行时间：532ms
     * 占用内存：9472k
     */
//    public static int JumpFloor(int target) {
//        if (target == 0) {
//            return 1;
//        }
//        if (target == 1) {
//            return 1;
//        }
//        if (target == 2) {
//            return 2;
//        }
//        return JumpFloor(target - 1) + JumpFloor(target - 2);
//    }

    /**
     * 非递归版本
     *
     * 运行时间：19ms
     * 占用内存：9480k
     */
    public static int JumpFloor(int target) {
        int preNum = 1;
        int prePreNum = 1;
        int result = 0;
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return 1;
        }
        for (int i = 2; i <= target; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(JumpFloor(i));
        }

    }

}
