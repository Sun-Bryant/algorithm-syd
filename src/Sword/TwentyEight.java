package Sword;

/**
 * 28、数组中出现次数超过一半的数字
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class TwentyEight {

    /**
     * 暴力法
     *
     * 运行时间：20ms
     * 占用内存：9252k
     * 时间复杂度：O(n^2)
     */
//    public static int MoreThanHalfNum_Solution(int [] array) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        for (int i = 0; i < array.length; i++) {
//            int count = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (array[i] == array[j]) {
//                    count++;
//                }
//            }
//            if (count > (array.length / 2)) {
//                return array[i];
//            }
//        }
//        return 0;
//    }

    /**
     *
     * 运行时间：18ms
     * 占用内存：9384k
     * 时间复杂度：O(n)
     *
     * 这道题可以大致想象成打牌游戏，相同数字最多的为一方（A队），其他数字为一方（B队）。
     * 假设存在数组中超过一半的数字，那么A对必然比B队多一个数。此时双方出牌，一边出一个来进行抵消操作。最后剩下的就肯定是目标数字。
     *
     * 来解释一下这题为什么可以这么做。
     * 首先第一个for循环结束后得到的num是什么？如果这个数组中存在个数大于数组长度一半的数，那么这个num一定是这个数，
     * 因为数组中所有不是num的数，一定会被这个数覆盖，所以最后得到的数是num。
     * 但是，如果这个数组中根本不存在个数大于数组长度一半的数，那么这个num就是一个不确定的值，
     * 这也是为什么找出num之后，还要再做一次循环验证这个数出现的个数是不是大于数组长度一半的原因。
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        //判断是否大于二分之一
        count = 0;
        for (int j = 0; j < array.length; j++) {
            if (num == array[j]) {
                count++;
            }
        }
        if (count > (array.length / 2)) {
            return num;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

}
