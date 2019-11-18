package Sword;

/**
 * 36、两个链表的第一个公共结点
 *
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class ThirtySix {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 让长的先走两个链表的长度差，然后再一起走。
     *
     * 运行时间：30ms
     * 占用内存：9600k
     * 时间复杂度：O(n)
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len,len1 = 0, len2 = 0;
        ListNode result = null;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        len = len1 > len2 ? len1 - len2 : len2 - len1;
        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < len; i++) {
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                result = p1;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        node8.next = node5;

        System.out.println(FindFirstCommonNode(node1,node7).val);
    }
}
