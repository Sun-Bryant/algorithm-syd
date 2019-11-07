package Sword;

/**
 * 14、链表中倒数第k个结点
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Fourteen {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 第一种：暴力法
     *
     * 运行时间：25ms
     * 占用内存：9472k
     * 时间复杂度：O(n)
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (head != null) { //求出链表长度。
            length++;
            head = head.next;
        }
        if (k > length) {
            return null;
        }
        for (int i = 0; i < length - k; i++) {   //遍历得到倒数第k个节点
            temp = temp.next;
        }
        return temp;
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
        FindKthToTail(node1, 4);
    }

}
