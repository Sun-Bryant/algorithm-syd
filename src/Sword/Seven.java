package Sword;

/**
 * 7、斐波那契数列
 *
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 斐波那契数列数列为：1、1、2、3、5、8、13、21、……
 */
public class Seven {


    /**
     * 递归版本
     *
     * 运行时间：1484ms
     * 占用内存：9428k
     *
     */
//    public static int Fibonacci(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
//    }

    /**
     * 非递归版本
     * 运行时间：18ms
     * 占用内存：9180k
     */
    public static int Fibonacci(int n) {
//        int[] arr = new int[40];
//        arr[0] = 0;
//        arr[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            arr[i] = arr[i - 1] + arr[i - 2];
//        }
//        return arr[n];
        int prePreNum = 0;
        int preNum = 1;
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = prePreNum + preNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 39; i++) {
            System.out.println(Fibonacci(3));
//        }
    }
}
