package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class LeetCode_093 {

    /**
     * 解题思路
     * 本题使用回溯和递归的思想复原 ip 地址
     *
     * 首先创建 ans 来接收复原后的所有 ip 地址，然后通过创建回溯方法进行筛选，最终返回 ans。
     * 创建回溯方法体需要传入四个参数进行把控：1.给定的数字字符串 s，2.回溯过程中遍历到的位置 pos，3.当前确定好的 ip 段的数量，4.收集结果的 ans
     * 考虑方法体出口：如果确定好 4 段并且遍历完整个 s,就将 cur 之间的段以 . 分隔开来放入 ans
     * 接下来对 s 进行筛选,其中注意每段的长度最大为 3,拆箱为 int 后的长度不超过 255,起始位置不能为 0
     * 控制好这些边界条件后就可以就可以正常的利用递归和回溯遍历字符串，具体可参考代码注释。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return ans;
        }
        dfs(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    // pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
    public void dfs (List<String> ans, List<String> cur, String s, int pos){
        if (cur.size() == 4) {
            // 如果此时 pos 也刚好遍历完整个 s
            if (pos == s.length()) {
                ans.add(String.join(".", cur));
            }
            return;
        }
        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 剪枝
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }
            // 将 s 的子串开始分段
            String segment = s.substring(pos, pos + i);
            // 剪枝条件：段的起始位置不能为 0，segment 拆箱成 int 类型 不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            // 做选择
            cur.add(segment);
            // 递归
            dfs(ans, cur, s, pos + i);
            // 撤销选择
            cur.remove(cur.size() - 1);
        }
    }
}
