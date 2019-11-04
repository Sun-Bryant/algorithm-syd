package Sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 3、从尾到头打印链表
 *
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Three {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 运行时间：32ms
     * 占用内存：9368k
     * 时间复杂度：O(N)
     *
     * 思路：利用栈结构
     * 1、先顺序遍历链表，在遍历的过程中，把当前指针所指的值压栈
     * 2、把栈里面的值依次弹出，并存入到ArrayLis集合中。
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur;
        Stack<Integer> stack = new Stack<>();
//        if (listNode == null) {
//            return null;
//        }
        cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(0);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;

        ListNode head = null;
        ArrayList<Integer> list = printListFromTailToHead(head);
        System.out.println(list.toString());

    }
}
