package Sword;

import java.util.Stack;

/**
 * 20、包含min函数的栈
 *
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 */
public class Twenty {
    /**
     * 思路：push：采用辅助栈的方法。压栈的时候，如果辅助栈为空(第一次压栈)或压栈元素小于辅助栈的栈顶元素时，辅助栈也将新元素压栈，
     *          否则，则将辅助栈的栈顶元素再压栈一次。
     *      pop：主栈和辅助栈都弹出即可。
     *      top：将主栈的栈顶元素返回（不弹出）
     *      min：将辅助栈的栈顶元素返回（不弹出）
     *
     * 运行时间：20ms
     * 占用内存：9208k
     */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    // 注意，这个函数是peek，不是pop。
    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {


    }

}
