package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class LeetCode_113 {

    /**
     * 方法2：递归 + 回溯
     * 注意，不要大量复制集合。那样效率会很低。
     * 在递归过程中，应该传递引用。
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, ans, list, sum);
        return ans;
    }
    public void  dfs(TreeNode root, List<List<Integer>> ans, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans.add(new ArrayList<>(list));
            }
        }
        dfs(root.left, ans, list, sum); // 传递list的引用
        dfs(root.right, ans, list, sum);
        list.remove(list.size() - 1); // 回溯
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
