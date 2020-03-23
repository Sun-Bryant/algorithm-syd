package Sword;

import java.util.ArrayList;

/**
 * 64、滑动窗口的最大值
 *
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class SixtyFour {

    /**
     *
     * 运行时间：16ms
     * 占用内存：9420k
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || size < 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0)
            return list;
        for (int i = 0; i < num.length - size + 1; i++) {
            int maxNum = num[i];
            for (int j = i; j < i + size; j++) {
                if (num[j] > maxNum) {
                    maxNum = num[j];
                }
            }
            list.add((maxNum));
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = new int[]{10,14,12,11};
        int size = 0;
        System.out.println(maxInWindows(num, size));

    }
}
