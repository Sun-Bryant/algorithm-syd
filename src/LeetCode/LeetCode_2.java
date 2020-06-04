package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2. 两数相加
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 *
 */
public class LeetCode_2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int a1 = (p1 != null) ? p1.val : 0;
            int a2 = (p2 != null) ? p2.val : 0;
            int sum = a1 + a2 + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry == 1){
            p.next =  new ListNode(1); ;
        }
        return head.next;
    }

    /**
     * 利用辅助队列进行计算。
     *
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(-1);
//        ListNode p = head;
//        Queue<Integer> queue1 = new LinkedList<Integer>();
//        Queue<Integer> queue2 = new LinkedList<Integer>();
//        int a1;
//        int a2;
//
//        ListNode p1 = l1;
//        ListNode p2 = l2;
//        while (p1 != null) {
//            queue1.add(p1.val);
//            p1 = p1.next;
//        }
//        while (p2 != null) {
//            queue2.add(p2.val);
//            p2 = p2.next;
//        }
//        int jin = 0;
//        while (!queue1.isEmpty() || !queue2.isEmpty()) {
//            if (!queue1.isEmpty()){
//                a1 = queue1.poll();
//            } else {
//                a1 = 0;
//            }
//            if (!queue2.isEmpty()){
//                a2 = queue2.poll();
//            } else {
//                a2 = 0;
//            }
//            int sum = a1 + a2 + jin;
//            jin = sum >= 10 ? 1 : 0;
//            int bitResult = sum >= 10 ?  sum - 10 : sum;
//            ListNode node = new ListNode(bitResult);
//            p.next =  node ;
//            p = p.next;
//        }
//        if (jin == 1){ // 产生了额外进位的时候
//            ListNode node = new ListNode(1);
//            p.next =  node ;
//            p = p.next;
//        }
//        return head.next;
//    }
}
