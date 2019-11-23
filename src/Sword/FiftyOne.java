package Sword;

/**
 * 51、构建乘积数组
 *
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class FiftyOne {

    /**
     * 思路一：暴力法
     *
     * 运行时间：16ms
     * 占用内存：9304k
     * 时间复杂度：O(n^2)
     */
//    public static int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        for (int i = 0; i < B.length; i++) {
//            B[i] = 1;
//            for (int j = 0; j < A.length; j++) {
//                if (j != i) {
//                    B[i] *= A[j];
//                }
//            }
//        }
//        return B;
//    }

    /**
     * 思路二：
     * B[i]的值可以看作下面的矩阵中每行的乘积.
     * 先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     *
     * 为方便理解，我没有举普遍性的例子，举了一个实际的例子：
     * B0行：  1  A1  A2  A3  A4
     * B1行：  A0  1  A2  A3  A4
     * B2行：  A0  A1  1  A3  A4
     * B3行：  A0  A1  A2  1  A4
     * B4行：  A0  A1  A2  A3  1
     *
     * 运行时间：29ms
     * 占用内存：9380k
     * 时间复杂度：O(n)
     */
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];

        if (len != 0) {
            B[0] = 1;
            // 先计算下三角
            for (int i = 1; i < len; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            //再计算上三角
            int temp = 1;
            for (int j = len - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 1, 4, 2, 5, 3};
        int[] B = multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
