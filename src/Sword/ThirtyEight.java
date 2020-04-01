package Sword;

/**
 * 38、二叉树的深度
 *
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class ThirtyEight {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     *
     * 运行时间：13ms
     * 占用内存：9304k
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) { // 当树为空直接返回0
            return 0;
        } else {
            return Math.max(TreeDepth(root.left)+1, TreeDepth(root.right)+1);
        }
    }


}
