package Sword;

import java.util.ArrayList;

/**
 * 19、顺时针打印矩阵
 *
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Nineteen {

    /**
     * 一圈一圈打印矩阵
     *
     * 运行时间：30ms
     * 占用内存：10676k
     *
     * 思想：用左上和右下的坐标定位出一次要旋转打印的数据，一次旋转打印结束后，往对角分别前进和后退一个单位。
     *      注意需要出现单行或者单列的情况。
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList list = new ArrayList();
        int a, b, c, d;//代表左上方点右下方点，这两个点确定一个矩形。
        a = 0; //左上方点的行
        b = 0; //左上方点的列
        c = matrix.length - 1;  //右下方点的行。
        d = matrix[0].length - 1;   //右下方点的列
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--, list);
        }
        return list;
    }

    private static void printEdge(int[][] matrix, int a, int b, int c, int d, ArrayList<Integer> list) {
        if (a == c) { //说明单行
            for (int i = b; i <= d; i++) {
//                System.out.println(matrix[a][i]);
                list.add(matrix[a][i]);
            }
        } else if (b == d) { //说明单列
            for (int i = a; i <= c; i++) {
//                System.out.println(matrix[i][b]);
                list.add(matrix[i][b]);
            }
        } else { //正常打印一圈
            for (int i = b; i < d; i++) {
//                System.out.println(matrix[a][i]);
                list.add(matrix[a][i]);
            }
            for (int i = a; i < c; i++) {
//                System.out.println(matrix[i][d]);
                list.add(matrix[i][d]);
            }
            for (int i = d; i >b; i--) {
//                System.out.println(matrix[c][i]);
                list.add(matrix[c][i]);
            }
            for (int i = c; i >a; i--) {
//                System.out.println(matrix[i][b]);
                list.add(matrix[i][b]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());

    }

}
