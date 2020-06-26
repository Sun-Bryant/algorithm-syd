package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode_094 {

    /**
     * 第一种方法：使用二叉树的递归求解
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        inorderRecur(root, list);
//        return list;
//    }
//
//    public void inorderRecur(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        inorderRecur(root.left, list);
//        list.add(root.val);
//        inorderRecur(root.right, list);
//    }


    /**
     * 第二种方法：使用二叉树的非递归求解
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderUnRecur(root, list);
        return list;
    }
    public void inOrderUnRecur(TreeNode head, List<Integer> list) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || head != null) {   //将二叉树仅仅分为左中的概念。
                if (head != null) {  // 将二叉树左孩子入栈
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    list.add(head.val);
                    head = head.right;
                }
            }
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
