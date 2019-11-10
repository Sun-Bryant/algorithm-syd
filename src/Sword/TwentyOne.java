package Sword;

import java.util.Stack;

/**
 * 21、栈的压入、弹出序列
 *
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class TwentyOne {

    /**
     * 模拟入栈与出栈的过程，进而判断是否存在这样的序列。
     *
     * 运行时间：17ms
     * 占用内存：9344k
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
//    public static boolean IsPopOrder(int [] pushA,int [] popA) {
//        //判断两个数组是否值相等，如果不等，直接返回false。 eg：[1],[2]
//        for (int m = 0; m < popA.length; m++) {
//            boolean f = false;
//            for (int n = 0; n < pushA.length; n++) {
//                if (popA[m] == pushA[n]) {
//                    f = true;
//                    continue;
//                }
//            }
//            if (f == false) {
//                return false;
//            }
//        }
//        // 借用一个栈结构
//        Stack<Integer> help = new Stack<>();
//        // 标识数组：用来标识pushA数组是否已经入栈。
//        boolean[] pushFlag = new boolean[pushA.length];
//        int i = 0;
//        int j = 0;
//        for (i = 0; i < popA.length; i++) {
//            // 依序找到出栈序列的每一位在pushA数组中的位置
//            for (j = 0; j < pushA.length; j++) {
//                if (popA[i] == pushA[j]) {
//                    break;
//                }
//            }
//            // 如果标识位为true，说明当前数已经进栈，此时弹出栈顶元素进行比较，相等继续，不等直接返回false。
//            if (pushFlag[j] == true) {
//                int temp = help.pop();
//                if (popA[i] != temp) {
//                    return false;
//                }
//            } else if (pushFlag[j] == false) { // 如果标识位为false，说明当前数未进栈，则把当前数之前的数字都进栈并且标记为true。
//                pushFlag[j] = true;
//                for (int k = 0; k <j; k++) {
//                    if (pushFlag[k] == false) {
//                        help.push(pushA[k]);
//                        pushFlag[k] = true;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    /**
     *【思路】借用一个辅助的栈，遍历压栈顺序，先将第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，
     * 很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
     * 这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     *
     * 举例：
     * 入栈1,2,3,4,5
     * 出栈4,5,3,2,1
     * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
     * 此时栈顶2≠4，继续入栈3
     * 此时栈顶3≠4，继续入栈4
     * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
     * 此时栈顶3≠5，继续入栈5
     * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
     *  …  …  …
     * 依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
     *
     * 运行时间：18ms
     * 占用内存：9196k
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> help = new Stack();
        int popIndex = 0;//用于标识弹出序列的位置
        for (int i = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            //如果栈不为空，且栈顶元素相等，则弹出序列
            while (!help.isEmpty() && (help.peek() == popA[popIndex])) {
                help.pop();
                popIndex++;
            }
        }
        return help.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA));
    }

}
