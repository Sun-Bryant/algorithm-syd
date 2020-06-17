package LeetCode;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *  输入: "()"
 *  输出: true
 *
 * 示例 2:
 *  输入: "()[]{}"
 *  输出: true
 *
 * 示例 3:
 *  输入: "(]"
 *  输出: false
 *
 * 示例 4:
 *  输入: "([)]"
 *  输出: false
 *
 * 示例 5:
 *  输入: "{[]}"
 *  输出: true
 */
public class LeetCode_020 {

    /**
     * 1.使用栈存放左括号
     *
     */
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) { // 奇数个字符的字符串 显然无法完成括号匹配
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false; // 栈中已无左括号，此时字符为右括号，无法匹配。
                char top = stack.peek();
                if ((top == '(' && cur == ')') || (top == '[' && cur == ']') || (top == '{' && cur == '}')) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }
        return stack.isEmpty();
    }


//    public boolean isValid(String s) {
//        if(s.length() == 0) {
//            return true;
//        }
//
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < s.length(); i++) {
//            if (stack.isEmpty()){
//                stack.push(s.charAt(i));
//            } else {
//                char top = stack.peek();
//                char cur = s.charAt(i);
//                if ((top == '(' && cur == ')') || (top == '[' && cur == ']') || (top == '{' && cur == '}')) {
//                    stack.pop();
//                } else {
//                    stack.push(cur);
//                }
//            }
//        }
//
//        return stack.isEmpty();
//    }


}
