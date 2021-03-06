package Sword;

/**
 * 30、连续子数组的最大和
 *
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Thirty {

    /**
     * 动态规划：
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * res：所有子数组的和的最大值
     * res=max（res，F（i））
     *
     * 运行时间：15ms
     * 占用内存：9508k
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] f = new int[array.length];
        int res = array[0];
        f[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            f[i] = Math.max(f[i - 1] + array[i], array[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,1,5,9};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
