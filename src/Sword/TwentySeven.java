package Sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 27、字符串的排列
 *
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
public class TwentySeven {

    /**
     * 字典序排列算法
     *
     * 运行时间：154ms
     * 占用内存：11776k
     *
     * 一个全排列可看做一个字符串，字符串可有前缀、后缀。
     * 生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
     * 这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
     *
     * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
     * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
     *
     *【例】 如何得到346987521的下一个
     *  1，从尾部往前找第一个P(i-1) < P(i)的位置
     *     3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     *     最终找到6是第一个变小的数字，记录下6的位置i-1
     *
     *  2，从i位置往后找到最后一个大于6的数
     *     3 4 6 -> 9 -> 8 -> 7 5 2 1
     *     最终找到7的位置，记录位置为m
     *
     *  3，交换位置i-1和m的值
     *     3 4 7 9 8 6 5 2 1
     *  4，倒序i位置后的所有数据
     *     3 4 7 1 2 5 6 8 9
     * 则347125689为346987521的下一个排列
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars =str.toCharArray();
        Arrays.sort(chars);//因为要使用字典序算法，所以必须排好序。
        list.add(String.valueOf(chars)); // 添加第一个增序情况（eg:123456789）
        int len = chars.length;
        while (true) {
            int i = len - 1;
            int m;
            //1，从尾部往前找第一个P(i-1) < P(i)的位置
            while (i >= 1 && chars[i - 1] >= chars[i]) {
                i--;
            }
            if (i == 0) { // 说明已经到了最后一种情况，逆序。（eg:987654321）
                break;
            }
            m = i;
            //2，从i位置往后找到最后一个大于P(i-1)的数
            while (m < len && chars[m] > chars[i - 1]) {
                m++;
            }
            //3，交换位置i-1和m-1的值
            swap(chars, i-1, m-1);
            //4，倒序i位置后的所有数据
            reverse(chars, i);

            list.add(String.valueOf(chars));
        }
        return list;
    }

    //反转字符串第K个字符开始的字符
    private static void reverse(char[] chars, int k) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int len = chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }
    }

    private static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Permutation(str));
    }
}
