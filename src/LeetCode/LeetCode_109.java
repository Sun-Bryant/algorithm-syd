package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LeetCode_109 {

    /**
     * 第二种解法：快慢指针
     * 时间复杂度：O(N*LogN)
     */
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        return dfs(head, null);
//    }
//
//    public TreeNode dfs(ListNode start, ListNode end) {
//        if (start == end) {
//            return null;
//        }
//        ListNode slow = start;
//        ListNode fast = start;
//        while (fast != end && fast.next != end) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        TreeNode root = new TreeNode(slow.val);
//        root.left = dfs(start, slow);
//        root.right = dfs(slow.next, end);
//        return root;
//    }

    /**
     * 第一种方法：单链表转换为数组
     * 空间换时间
     * 时间复杂度：O(n)
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] nums = new int[len];
        p = head;
        int count = 0;
        while(p != null) {
            nums[count++] = p.val;
            p = p.next;
        }
        return dfs(nums, 0, len - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

//    public TreeNode sortedListToBST(ListNode head) {
//        List<Integer> nums = new ArrayList<Integer>();
//        ListNode p = head;
//        int count = 0;
//        while(p != null) {
//            nums.add(p.val);
//            p = p.next;
//        }
//        return dfs(nums, 0, nums.size() - 1);
//    }
//
//    public TreeNode dfs(List<Integer> nums, int left, int right) {
//        if (left > right) {
//            return null;
//        }
//        int mid = (left + right) / 2;
//        TreeNode root = new TreeNode(nums.get(mid));
//        root.left = dfs(nums, left, mid - 1);
//        root.right = dfs(nums, mid + 1, right);
//        return root;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
