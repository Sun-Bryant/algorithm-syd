package Sword;

import java.util.Stack;

/**
 * 15、反转链表
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Fifteen {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 借助栈结构实现反转
     *
     * 运行时间：44ms
     * 占用内存：9532k
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
//    public static ListNode ReverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode newHead = stack.pop();
//        ListNode node = newHead;
//        while (!stack.empty()) {
//            ListNode cur = stack.pop();//弹出节点
//            node.next = cur;
//            node = node.next;
//        }
//        node.next = null;
//        return newHead;
//    }

    /**
     * 原地反转
     *
     * 运行时间：25ms
     * 占用内存：9304k
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode end = null;
        ListNode p, q;
        p = head;
        while (p != null) {
            q = p.next;   // q指向下一个要遍历的节点
            p.next = end;  //反转链表操作
            end = p;
            p = q;
        }
        head = end;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode newHead = ReverseList(node1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
