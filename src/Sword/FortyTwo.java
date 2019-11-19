package Sword;

import java.util.ArrayList;

/**
 * 42、和为S的两个数字
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:对应每个测试案例，输出两个数，小的先输出。
 */

public class FortyTwo {

    /**
     * 思路：两边逼近法。
     *      数列满足递增，设两个头尾两个指针i和j，
     *      若ai + aj == sum，就是答案（相差越远乘积越小）
     *      若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     *      若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     *
     * 运行时间：25ms
     * 占用内存：9304k
     * 时间复杂度：O(n)
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length == 0 || array == null) {
            return res;
        }
        int len = array.length;
        int p2 = len - 1, p1 = 0;
        while (p1 < p2) {
            if (array[p1] + array[p2] == sum) {
                res.add(array[p1]);
                res.add(array[p2]);
                break;
            } else if (array[p1] + array[p2] > sum) {
                p2--;
            } else {
                p1++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(FindNumbersWithSum(arr, 11));
    }
}
