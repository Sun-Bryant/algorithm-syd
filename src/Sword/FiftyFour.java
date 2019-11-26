package Sword;

/**
 * 54、字符流中第一个不重复的字符
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FiftyFour {
    /**
     * 思路：
     * 利用一个int型数组表示256个字符，这个数组初值置为0.
     * 每读出一个字符，将该字符的位置(从1开始)存入字符对应数组下标中.
     * 若值为0标识第一次读入，>0表示不是第一次读入，将值改为-1.
     * 之后在数组中找到>0的最小值，该数组下标对应的字符为所求.
     *
     * 运行时间：20ms
     * 占用内存：9384k
     */
    private int[] flag = new int[256];
    private int index = 1;

    /**
     * 每读出一个字符，将该字符的位置(从1开始)存入字符对应数组下标中.
     * 若值为0标识第一次读入，>0表示不是第一次读入，将值改为-1.
     */
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (flag[ch] == 0) {
            flag[ch] = index;
        } else if (flag[ch] > 0) {
            flag[ch] = -1;
        }
        index++;
    }

    /**
     * 之后在数组中找到>0的最小值，该数组下标对应的字符为所求.
     */
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (flag[i] > 0 && flag[i] < minIndex) {
                ch = (char) i;
                minIndex = flag[i];
            }
        }
        if (ch == '\0') {
            return '#';
        }
        return ch;
    }

    public static void main(String[] args) {

    }
}
