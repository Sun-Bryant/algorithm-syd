package LeetCode;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 *  输入: 1->2->3->4->5->NULL, k = 2
 *  输出: 4->5->1->2->3->NULL
 * 解释:
 *  向右旋转 1 步: 5->1->2->3->4->NULL
 *  向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *  输入: 0->1->2->NULL, k = 4
 *  输出: 2->0->1->NULL
 * 解释:
 *  向右旋转 1 步: 2->0->1->NULL
 *  向右旋转 2 步: 1->2->0->NULL
 *  向右旋转 3 步: 0->1->2->NULL
 *  向右旋转 4 步: 2->0->1->NULL
 */
public class LeetCode_061 {

    /**
     * 维护一个旋转窗口
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 先得到链表的长度
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        //取余后是真实要旋转的位置
        int realStep = k % len;
        // 维护一个旋转窗口，这个窗口是前开后闭。
        ListNode start = head, end = head;
        for (int i = 0; i < realStep; i++) {
            end = end.next;
        }
        // 移动窗口到最后。
        while (end.next != null) {
            end = end.next;
            start = start.next;
        }
        // 连接
        end.next = head;
        ListNode newHead = start.next;
        start.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
