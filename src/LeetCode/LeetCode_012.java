package LeetCode;

/**
 * 12. 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如，罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *  输入: 3
 *  输出: "III"
 *
 * 示例 2:
 *  输入: 4
 *  输出: "IV"
 *
 * 示例 3:
 *  输入: 9
 *  输出: "IX"
 *
 * 示例 4:
 *  输入: 58
 *  输出: "LVIII"
 *  解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 *  输入: 1994
 *  输出: "MCMXCIV"
 *  解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 */
public class LeetCode_012 {


    /**
     * 贪心思想。
     * 大佬的代码。
     * 其实思想都是一样的，就是自己实现的写的太多了。需要再多些一些代码。
     */
    // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
    // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 自己的代码
     */
//    public String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//        while (num != 0) {
//            if (num >= 1000) {
//                int index = num / 1000;
//                for (int i = 0; i < index; i++){
//                    sb.append('M');
//                }
//                num = num - 1000 * index;
//            } else if (num >= 900) {
//                sb.append('C');
//                sb.append('M');
//                num = num - 900;
//            } else if (num >= 500) {
//                sb.append('D');
//                num = num - 500;
//            } else if (num >= 400) {
//                sb.append('C');
//                sb.append('D');
//                num = num - 400;
//            } else if (num >= 100) {
//                int index = num / 100;
//                for (int i = 0; i < index; i++){
//                    sb.append('C');
//                }
//                num = num - 100 * index;
//            } else if (num >= 90) {
//                sb.append('X');
//                sb.append('C');
//                num = num - 90;
//            } else if (num >= 50) {
//                sb.append('L');
//                num = num - 50;
//            } else if (num >= 40) {
//                sb.append('X');
//                sb.append('L');
//                num = num - 40;
//            } else if (num >= 10) {
//                int index = num / 10;
//                for (int i = 0; i < index; i++){
//                    sb.append('X');
//                }
//                num = num - 10 * index;
//            } else if (num >= 9) {
//                sb.append('I');
//                sb.append('X');
//                num = num - 9;
//            } else if (num >= 5) {
//                sb.append('V');
//                num = num - 5;
//            } else if (num >= 4) {
//                sb.append('I');
//                sb.append('V');
//                num = num - 4;
//            } else {
//                for (int i = 0; i < num; i++) {
//                    sb.append('I');
//                }
//                num = 0 ;
//            }
//        }
//        return sb.toString();
//    }
}
