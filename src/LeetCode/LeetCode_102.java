package LeetCode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LeetCode_102 {

    // BFS + 辅助Map。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();// 返回的答案集合
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<TreeNode, Integer> map = new HashMap<>();// 辅助Map，主要用于放置层数
        map.put(root, 1);
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列实现bfs。
        queue.add(root);
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
                ans.add(list);
                list = new ArrayList<>();
                curLevel = map.get(node);
            }
            list.add(node.val);
        }
        ans.add(list);
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
