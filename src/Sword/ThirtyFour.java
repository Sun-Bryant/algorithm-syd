package Sword;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 34、第一个只出现一次的字符位置
 *
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回-1
 * （需要区分大小写）.
 */
public class ThirtyFour {

    /**
     * 解题思路：其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
     *
     * 运行时间：29ms
     * 占用内存：9104k
     * 时间复杂度：O(n)
     */
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        //为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
        //而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，
        int[] arr = new int[58];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 65]++;
        }
        //遍历一遍字符串，找出第一个数组内容为1的字母就可以了，
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解题思路：hash,自己第一次实现的，复杂度太高，不推荐。
     *
     * 运行时间：40ms
     * 占用内存：9684k
     * 时间复杂度：O(n)
     */
//    public static int FirstNotRepeatingChar(String str) {
//        if (str == null  || str.length() ==0) {
//            return -1;
//        }
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        int[][] arr = new int[52][2];
//        for (int i = 0; i < str.length(); i++) {
//            switch (str.charAt(i)) {
//                case 'A' : arr[0][0]++; arr[0][1] = i;break;
//                case 'B' : arr[1][0]++; arr[1][1] = i;break;
//                case 'C' : arr[2][0]++; arr[2][1] = i;break;
//                case 'D' : arr[3][0]++; arr[3][1] = i;break;
//                case 'E' : arr[4][0]++; arr[4][1] = i;break;
//                case 'F' : arr[5][0]++; arr[5][1] = i;break;
//                case 'G' : arr[6][0]++; arr[6][1] = i;break;
//                case 'H' : arr[7][0]++; arr[7][1] = i;break;
//                case 'I' : arr[8][0]++; arr[8][1] = i;break;
//                case 'J' : arr[9][0]++; arr[9][1] = i;break;
//                case 'K' : arr[10][0]++; arr[10][1] = i;break;
//                case 'L' : arr[11][0]++; arr[11][1] = i;break;
//                case 'M' : arr[12][0]++; arr[12][1] = i;break;
//                case 'N' : arr[13][0]++; arr[13][1] = i;break;
//                case 'O' : arr[14][0]++; arr[14][1] = i;break;
//                case 'P' : arr[15][0]++; arr[15][1] = i;break;
//                case 'Q' : arr[16][0]++; arr[16][1] = i;break;
//                case 'R' : arr[17][0]++; arr[17][1] = i;break;
//                case 'S' : arr[18][0]++; arr[18][1] = i;break;
//                case 'T' : arr[19][0]++; arr[19][1] = i;break;
//                case 'U' : arr[20][0]++; arr[20][1] = i;break;
//                case 'V' : arr[21][0]++; arr[21][1] = i;break;
//                case 'W' : arr[22][0]++; arr[22][1] = i;break;
//                case 'X' : arr[23][0]++; arr[23][1] = i;break;
//                case 'Y' : arr[24][0]++; arr[24][1] = i;break;
//                case 'Z' : arr[25][0]++; arr[25][1] = i;break;
//
//                case 'a' : arr[26][0]++; arr[26][1] = i;break;
//                case 'b' : arr[27][0]++; arr[27][1] = i;break;
//                case 'c' : arr[28][0]++; arr[28][1] = i;break;
//                case 'd' : arr[29][0]++; arr[29][1] = i;break;
//                case 'e' : arr[30][0]++; arr[30][1] = i;break;
//                case 'f' : arr[31][0]++; arr[31][1] = i;break;
//                case 'g' : arr[32][0]++; arr[32][1] = i;break;
//                case 'h' : arr[33][0]++; arr[33][1] = i;break;
//                case 'i' : arr[34][0]++; arr[34][1] = i;break;
//                case 'j' : arr[35][0]++; arr[35][1] = i;break;
//                case 'k' : arr[36][0]++; arr[36][1] = i;break;
//                case 'l' : arr[37][0]++; arr[37][1] = i;break;
//                case 'm' : arr[38][0]++; arr[38][1] = i;break;
//                case 'n' : arr[39][0]++; arr[39][1] = i;break;
//                case 'o' : arr[40][0]++; arr[40][1] = i;break;
//                case 'p' : arr[41][0]++; arr[41][1] = i;break;
//                case 'q' : arr[42][0]++; arr[42][1] = i;break;
//                case 'r' : arr[43][0]++; arr[43][1] = i;break;
//                case 's' : arr[44][0]++; arr[44][1] = i;break;
//                case 't' : arr[45][0]++; arr[45][1] = i;break;
//                case 'u' : arr[46][0]++; arr[46][1] = i;break;
//                case 'v' : arr[47][0]++; arr[47][1] = i;break;
//                case 'w' : arr[48][0]++; arr[48][1] = i;break;
//                case 'x' : arr[49][0]++; arr[49][1] = i;break;
//                case 'y' : arr[50][0]++; arr[50][1] = i;break;
//                case 'z' : arr[51][0]++; arr[51][1] = i; break;
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i][0] == 1 ) {
//                minHeap.add(arr[i][1]);
//            }
//        }
//        if (minHeap.isEmpty()) {
//            return -1;
//        }
//        return minHeap.peek();
//    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(FirstNotRepeatingChar("bcdefBCb")));
    }

}
