package Sword;

import java.util.Stack;

/**
 * 5、用两个栈实现队列
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class five {
    /**
     * 运行时间：15ms
     * 占用内存：9332k
     *
     * 思路：两个栈，一个popStack，专门用于弹栈，一个pushStack，专门用于进栈。
     * 要想实现队列的结构（先进先出），则需要这么两个栈配合，把进了pushStack的值都弹到popStack，这样就实现了先进先出。
     * 需要主要的是不是所有时候都可以弹栈pushStack，限制条件是popStack为空，
     * 这是因为只有当popStack不为空的时候，把值从pushStack都弹到popStack，就不能实现先进先出的队列结构。
     */

    Stack<Integer> popStack = new Stack<Integer>();
    Stack<Integer> pushStack = new Stack<Integer>();

    public void push(int node) {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        pushStack.push(node);
    }

    public int pop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public static void main(String[] args) {

    }
}
