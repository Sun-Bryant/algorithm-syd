package LeetCode;

public class LeetCode_019 {

    /**
     * 采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。
     *
     * 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
     *
     * 设置虚拟节点 dummyHead 指向 head
     * 设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
     * 移动 q，直到 p 与 q 之间相隔的元素个数为 n
     * 同时移动 p 与 q，直到 q 指向的为 NULL
     * 将 p 的下一个节点指向下下个节点
     * 
     * 参考：
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p, q;
        p = newHead;
        q = newHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode del = p.next;
        p.next = del.next;
        return newHead.next;
    }

    /**
     * 两次遍历
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) {
//            return head;
//        }
//
//        ListNode p = head;
//        int count = 0;
//        while (p != null) {
//            count++;
//            p = p.next;
//        }
//        if (count == n){
//            return head.next;
//        }
//
//        ListNode q = head;
//        ListNode pre = null;
//        for (int i = 0; i < (count - n); i++){
//            pre = q;
//            q = q.next;
//        }
//
//        ListNode temp = q.next;
//        pre.next = temp;
//        return head;
//    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
