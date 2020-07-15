package LeetCode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class LeetCode_082 {

    // 双指针
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null) {
            int count = 1;
            ListNode temp = cur;
            while (temp.next != null && temp.val == temp.next.val) {
                count++;
                temp = temp.next;
            }
            if (count > 1) { // 有重复数字
                pre.next = temp.next;
                cur = pre.next;
            } else { // 没有重复数字
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
