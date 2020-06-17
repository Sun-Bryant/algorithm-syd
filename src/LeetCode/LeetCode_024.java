package LeetCode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *  给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LeetCode_024 {

    /**
     * 我们把链表分为两部分，即奇数节点为一部分，偶数节点为一部分，
     * A指的是交换节点中的前面的节点，B指的是要交换节点中的后面的节点。
     * 再完成它们的交换，我们还得用 prevNode 记录 A 的前驱节点。
     *
     * 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(1)。
     */
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode first = p;
            ListNode second = p.next;

            // 交换
            pre.next = second;
            first.next = second.next;
            second.next = first;

            // 更改前驱节点和p
            pre = first;
            p = first.next;

        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
