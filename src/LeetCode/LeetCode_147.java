package LeetCode;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class LeetCode_147 {

    /**
     * 解题思路
     * 关键是几个链表节点的作用：
     *
     * dummy指向第一个节点，一是用于结果输出，二是寻找插入位置时用于回到起点
     * cur用于遍历的节点
     * pre一是用于和当前节点作比较，二是做标记，让交换后的cur回到pre后面
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if (pre.val <= cur.val) { // 原本有序
                pre = cur;
                cur = cur.next;
            } else {  // 无序
                ListNode p = newHead;
                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }
                // pre 指针跳过cur，连接到cur后面一个节点处
                pre.next = cur.next;
                // 将cur插入到p和p.next之间
                cur.next = p.next;
                p.next = cur;
                // 完成插入后，cur回到pre后面
                cur = pre.next;
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
