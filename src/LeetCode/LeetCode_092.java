package LeetCode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LeetCode_092 {

    /**
     * 双指针 -- 头插法
     * 思路：1、我们定义两个指针，分别称之为g(guard 守卫)和p(point)。
     * 我们首先根据方法的参数m确定g和p的位置。将g移动到第一个要反转的节点的前面，将p移动到第一个要反转的节点的位置上。我们以m=2，n=4为例。
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode t = newHead; // 要反转的节点的前面一个节点
        ListNode p = head;  // 反转部分的最后一个节点。
        int index = 1;
        while (p != null && index < m) {
            t = t.next;
            p = p.next;
            index++;
        }
        for (int i = m; i < n; i++) {  //
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
