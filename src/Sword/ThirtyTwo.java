package Sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 32、把数组排成最小的数
 *
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ThirtyTwo {

    /**
     * 主要考察比较器
     *
     * 运行时间：26ms
     * 占用内存：9720k
     */
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        // 先把int数组转为String数组
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        //采用自定义的比较方式比较
        // 若ab > ba 则 a > b，
        // 若ab < ba 则 a < b，
        // 若ab = ba 则 a = b；
        // 解释说明：比如 "3" < "32"但是 "332" > "323"，所以要将二者拼接起来进行比较
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String m1 = o1 + o2;
                String m2 = o2 + o1;
                return m1.compareTo(m2);
            }
        });
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));

    }
}
