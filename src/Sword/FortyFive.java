package Sword;

import java.util.Arrays;

public class FortyFive {

    /**
     * 思路：排序后，开始比较，如果有对子直接返回false；如果出现中断的数字（eg：3，5之间缺少4）则用0去抵消。
     *
     * 运行时间：17ms
     * 占用内存：9280k
     * 时间复杂度：O(n*logn)
     */
//    public static boolean isContinuous(int [] numbers) {
//        int len = numbers.length;
//        if (len != 5 || numbers ==null) {
//            return false;
//        }
//
//        Arrays.sort(numbers);
//        int zero = 0, i = 0;
//        for (; i < len && numbers[i] == 0; i++) {
//                zero++;
//        }
//
//        for (; i < len-1 && zero >=0; i++) {
//            if (numbers[i] == numbers[i + 1]) {//有对子，则返回false
//                return false;
//            }
//            if (numbers[i] + 1 + zero >= numbers[i + 1]) {  //可以继续匹配
//                zero -= numbers[i + 1] - numbers[i] - 1;
//            } else {
//                return false;
//            }
//        }
//        if (i == len - 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    /**
     * 用数组d来判断是否有除了0以外的重复数（计数排序），max记录最大值，min记录最小值，在判断是否差<5
     *
     * 运行时间：17ms
     * 占用内存：9236k
     * 时间复杂度：O(n)
     *
     * max 记录 最大值
     * min 记录  最小值
     * min ,max 都不记0
     * 满足条件 1、max - min <5
     *        2、除0外没有重复的数字(牌)
     *        3、数组长度 为5
     */
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int[] d = new int[14];
        d[0] = -5;  // 初始化为5 是为了便于比较最大值和最小值  因为d[0]最多就是0，而min最小是1.
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) { // 说明出现了对子。
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 0, 0, 1, 0};
        System.out.println(isContinuous(numbers));
    }
}
