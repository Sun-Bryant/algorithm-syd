package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_103 {

    /**
     * 解题思路
     * 思路： 交替使用两个栈遍历所有的层。
     *
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        //每次循环中，都是一个栈为空，一个栈不为空，结束的条件两个都为空
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> list = new ArrayList<>();// 存储这一个层的数据
            TreeNode node = null;
            if (!s1.isEmpty()) { //栈1不为空，则栈2此时为空，需要用栈2来存储从下一层从右到左的顺序
                while (!s1.isEmpty()) {
                    node = s1.pop();
                    if (node.left != null) s2.push(node.left);
                    if (node.right != null) s2.push(node.right);
                    list.add(node.val);
                }
                ans.add(list);
            } else { //栈2不为空，则栈1此时为空，需要用栈1来存储从下一层从左到右的顺序
                while (!s2.isEmpty()) {
                    node = s2.pop();
                    if (node.right != null) s1.push(node.right);
                    if (node.left != null) s1.push(node.left);
                    list.add(node.val);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
