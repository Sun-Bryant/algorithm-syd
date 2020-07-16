package LeetCode;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class LeetCode_086 {

    // 两个子链表拼接
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode l = less;
        ListNode more = new ListNode(-1);
        ListNode m = more;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                m.next = head;
                m = m.next;
            }
            head = head.next;
        }
        m.next = null;  // 大于等于这条链表最后一位必须置空，防止出现环
        l.next = more.next;
        return less.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
