package Sword;


/**
 * 52、正则表达式匹配
 *
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class FiftyTwo {

    /**
     * 这里是剑指offer的解题思路 ： 先看 * 再看 匹配
     *     前提：当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
     *     1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
     *       一：当前匹配
     *          1.1 match(str,i + 1,pattern,j)//跳过str   相当于*匹配了1个或多个字符
     *              eg : str = aaa; pattern = a*    匹配两个a
     *          1.2 match(str,i,pattern,j + 2)//跳过pattern   相当于*匹配了0个字符
     *              eg : str = aab; pattern = c*aab   匹配一个c
     *          1.3 match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
     *       二：当前不匹配
     *          match(str,i,pattern,j + 2)//跳过pattern
     *     2.下一个不是 *
     *       当前匹配 return match(str,i + 1,pattern,j + 1)
     *
     * 运行时间：26ms
     * 占用内存：9284k
     */
    public static boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null) {
            return false;
        }
        return isMatch(str, 0, pattern, 0);
    }

    public static boolean isMatch(char[] str, int i, char[] pattern, int j) {
        if (pattern.length == j) { //当pattern字符串遍历完了
            return str.length == i;   // 如果str也完了，返回true，不然false
        }
        if (j < pattern.length - 1 && pattern[j + 1] == '*') { // 当前字符的下一个字符是*
            if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {   //当前字符匹配
                return isMatch(str, i, pattern, j + 2) // 说明*匹配了0个字符
                        || isMatch(str, i + 1, pattern, j);  //说明*匹配了1个或多个字符。
            } else {
                return isMatch(str, i, pattern, j + 2);
            }
        }
        if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {  // 当前字符的下一个字符不是* ，且当前字符匹配
            return isMatch(str, i + 1, pattern, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "aa.a".toCharArray();
        System.out.println(match(str,pattern));
    }
}
