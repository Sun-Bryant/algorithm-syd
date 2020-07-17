package LeetCode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class LeetCode_206 {

    /**
     * 双指针 -- 头插法
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode t = newHead;
        ListNode p = head;
        while(p !=null && p.next != null){
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = t.next;
            t.next = temp;
        }
        return newHead.next;
    }

    /**
     * 双指针迭代
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
