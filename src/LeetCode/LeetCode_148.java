package LeetCode;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class LeetCode_148 {

    //归并排序
    //用快慢指针把链表分为两部分
    //左边链表排序
    //右边链表排序
    //合并左右两个链表，返回链表头
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 递归结束条件
        if (head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // 快慢指针找到中间节点
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 把链表从中间断开
        ListNode tail = p1;
        p1 = p1.next;
        tail.next = null;

        // 左边排序后返回左链表的开头
        ListNode L = sortList(head);
        // 右边排序后返回右链表的开头
        ListNode R = sortList(p1);
        return merge(L, R);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        // 比较左右链表
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
