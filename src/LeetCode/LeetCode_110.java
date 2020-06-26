package LeetCode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 */
public class LeetCode_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isB;
    }

    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, true);
        }
        Info left = process(node.left);
        Info right = process(node.right);
        int height = Math.max(left.height, right.height) + 1;

        boolean isB = left.isB && right.isB && Math.abs(left.height - right.height) < 2;
        return new Info(height, isB);
    }

    public class Info {
        int height;
        boolean isB;

        public Info(int height, boolean isB) {
            this.height = height;
            this.isB = isB;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
