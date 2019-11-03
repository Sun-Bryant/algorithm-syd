package Sword;

/**
 *  1、二维数组中的查找
 *
 *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class One {

    /**
     * 运行时间：187ms
     * 占用内存：17344k
     * 暴力求解  O(n^2)
     */
//    public static boolean Find(int target, int [][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                if (array[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 运行时间：183ms
     * 占用内存：16100k
     * 时间复杂度：O(m+n)
     *
     * 思路：
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,即col--；
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,即row++；
     */
    public static boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target == array[i][j]) {
                return true;
            }
            if (target < array[i][j]) {
                j--;
                continue;
            }
            if (target > array[i][j]) {
                i++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(16, arr));
    }
}
