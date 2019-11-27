package Sword;

import java.util.List;

/**
 * 55、链表中环的入口结点
 *
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class FiftyFive {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思想：快慢指针 快指针一次走两步 慢指针一次走一步，同时开始走，如果有环，必定相遇。
     *             假设有环相遇之后，快指针回到头结点，和慢指针一样一次走一步，快慢指针再次相遇的时候，即为入环节点。
     * 运行时间：20ms
     * 占用内存：9440k
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast.next.next == null || slow.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        System.out.println(EntryNodeOfLoop(node1).val);
    }

}
