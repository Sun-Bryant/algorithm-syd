package Sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 29、最小的K个数
 *
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class TwentyNine {

    /**
     * 排序之后，取前k个数。（另外还可以使用堆结构解决问题）
     *
     * 运行时间：39ms
     * 占用内存：9580k
     * 时间复杂度：O(n*logn)
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(arr,10));

    }

}
