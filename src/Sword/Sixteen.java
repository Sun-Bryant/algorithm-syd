package Sword;

/**
 * 16、合并两个排序的链表
 *
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Sixteen {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 归并排序思想
     *
     * 运行时间：28ms
     * 占用内存：9660k
     *
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1); //新建一个头节点，用来存合并的链表
        head.next = null;
        ListNode root = head; //用于最后返回结果的头结点
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        head.next = (list1 == null) ? list2 : list1;//把未结束的链表连接到合并后的链表尾部
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(5);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        ListNode head = Merge(node1, node6);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
