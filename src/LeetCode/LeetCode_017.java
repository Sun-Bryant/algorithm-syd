package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *  输入："23"
 *  输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode_017 {

    /**
     * 方法：回溯
     * 回溯是一种通过穷举所有可能情况来找到所有解的算法。
     * 如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
     *
     * 给出如下回溯函数 backtrack(combination, next_digits) ，
     * 它将一个目前已经产生的组合 combination 和接下来准备要输入的数字 next_digits 作为参数。
     *
     * 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
     * 如果还有数字需要被输入：
     * 遍历下一个数字所对应的所有映射的字母。
     * 将当前的字母添加到组合最后，也就是 combination = combination + letter 。
     * 重复这个过程，输入剩下的数字： backtrack(combination + letter, next_digits[1:]) 。
     *
     */
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> ans = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            process("",digits);
        }
        return ans;
    }

    public void process(String combination, String next_digit){
        if (next_digit.length() == 0){// if there is no more digits to check
            ans.add(combination);// the combination is done
        } else {// if there are still digits to check
            // iterate over all letters which map
            // the next available digit
            String digit = next_digit.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                process(combination + letter , next_digit.substring(1));
            }
        }
    }
}
