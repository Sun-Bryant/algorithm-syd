package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 *
 * 示例 1:
 *  输入: s = "LEETCODEISHIRING", numRows = 3
 *  输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 *  输入: s = "LEETCODEISHIRING", numRows = 4
 *  输出: "LDREOEIIECIHNTSG"
 *  解释:
 *  L     D     R
 *  E   O E   I I
 *  E C   I H   N
 *  T     S     G
 *
 */
public class LeetCode_006 {

    /**
     * 解题思路：
     * 算法流程： 按顺序遍历字符串 s；
     *      1、把每个字符c填入对应行;
     *      2、更新当前字符 c 对应的行索引；
     *      3、flag = - flag： 在达到 Z 字形转折点时，执行反向。
     * 复杂度分析：
     * 时间复杂度 O(N) ：遍历一遍字符串 s；
     * 空间复杂度 O(N) ：各行字符串共占用 O(N) 额外空间。
     *
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows ; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == (numRows - 1)) flag = -flag;
            i += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb);
        }
        return ans.toString();
    }

}
