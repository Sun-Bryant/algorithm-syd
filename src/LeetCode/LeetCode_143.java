package LeetCode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class LeetCode_143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }
        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分成两个链表
        ListNode secondHead = slow.next;
        slow.next = null;
        // 反转链表
        secondHead = reverseLit(secondHead);
        //链表节点依次连接
        while(secondHead != null) {
            ListNode temp = secondHead.next;
            secondHead.next = head.next;
            head.next = secondHead;
            head = secondHead.next;
            secondHead = temp;
        }
    }
    // 头插法反转链表
    public ListNode reverseLit(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode t = newHead;
        ListNode p = head;
        while(p != null && p.next != null) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = t.next;
            t.next = temp;
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
