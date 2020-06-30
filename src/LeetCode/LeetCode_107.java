package LeetCode;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
public class LeetCode_107 {

    // BFS + 辅助Map（记录层数） + 栈（反转）
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();// 返回的答案集合
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<TreeNode, Integer> map = new HashMap<>();// 辅助Map，主要用于放置层数
        map.put(root, 1);
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列实现bfs。
        queue.add(root);
        Stack<List> stack = new Stack<>();
        int curLevel = 1;
        TreeNode node = null;
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (left != null) {
                queue.add(left);
                map.put(left, map.get(node) + 1);
            }
            if (right != null) {
                queue.add(right);
                map.put(right, map.get(node) + 1);
            }
            if (map.get(node) > curLevel) {
                stack.push(list);
                list = new ArrayList<>();
                curLevel = map.get(node);
            }
            list.add(node.val);
        }
        stack.push(list);
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode node = q.poll();
//                tmp.add(node.val);
//                if (node.left != null) {
//                    q.add(node.left);
//                }
//                if (node.right != null) {
//                    q.add(node.right);
//                }
//            }
//            // 在索引 0 的位置加入一维数组 tmp
//            // 每次新的数组进来都会被放在开始的位置
//            ans.add(0, tmp);
//        }
//        return ans;
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
