package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_145 {

    /**
     * 非递归版本 --两个栈
     * 先序遍历可以得到”根左右“的顺序，因此可以也能得到到”根右左“的顺序(栈中先压左后压右)，再使用另一个栈记录，最后打印就是”左右根“
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                collect.push(node);
                if (node.left != null) {
                    s1.push(node.left);
                }
                if (node.right != null) {
                    s1.push(node.right);
                }
            }
            while (!collect.isEmpty()) {
                TreeNode node = collect.pop();
                ans.add(node.val);
            }
        }
        return ans;
    }

    //递归版本
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        process(root);
//        return ans;
//    }
//
//    public void process(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        process(root.left);
//        process(root.right);
//        ans.add(root.val);
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
