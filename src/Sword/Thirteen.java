package Sword;

/**
 * 13、调整数组顺序使奇数位于偶数前面
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Thirteen {

    /**
     * 第一种：再来一个辅助数组
     *
     * 运行时间：19ms
     * 占用内存：9168k
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
//    public static void reOrderArray(int[] array) {
//        int[] arr = new int[array.length];
//        int i = 0;
//        for (int j = 0; j < array.length; j++) {
//            if ((array[j] % 2) == 1) {
//                arr[i++] = array[j];
//            }
//        }
//        for (int j = 0; j < array.length; j++) {
//            if ((array[j] % 2) == 0) {
//                arr[i++] = array[j];
//            }
//        }
//        for (int j = 0; j < arr.length; j++) {
//            array[j] = arr[j];
//        }
//    }

    /**
     * 第二种：不使用辅助数组
     *
     * 运行时间：20ms
     * 占用内存：9252k
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.终止条件：j向后遍历查找失败。
     */
    public static void reOrderArray(int[] array) {
        int start = 0, end = 0;
        int temp;
        while (start < array.length) {
            while (start < array.length && array[start] % 2 == 1) { //找到第一个偶数
                start++;
            }
            end = start + 1;
            while (end < array.length && array[end] % 2 == 0) { //找到start位置后面的第一个奇数
                end++;
            }
            if (end < array.length) {
                temp = array[end];
                //从start到end往后移一位
                for (int i = end - 1; i >= start; i--) {
                    array[i + 1] = array[i];
                }
                array[start++] = temp;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4,5, 6, 7};
        reOrderArray(array);
    }

}
