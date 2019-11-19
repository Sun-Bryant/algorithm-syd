package Sword;

import java.util.ArrayList;

/**
 * 41、和为S的连续正数序列
 *
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FortyOne {

    /**
     * 思路：双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
     *
     * 运行时间：35ms
     * 占用内存：9476k
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//存放结果
        int low = 1, high = 2;//两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        while (low < high) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {//相等，那么就将窗口范围的所有数添加进结果集
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            } else if (cur < sum) {//如果当前窗口内的值之和小于sum，那么右边窗口右移一下
                high++;
            } else {//如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));

    }
}
