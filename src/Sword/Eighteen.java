package Sword;

/**
 * 18、二叉树的镜像
 *
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Eighteen {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 递归
     *
     * 运行时间：23ms
     * 占用内存：9560k
     */
    public void Mirror(TreeNode root) {
        // 如果递归到null，直接返回
        if (root == null) {
            return;
        }
        // 否则，直接交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 分别递归左右子树
        Mirror(root.left);
        Mirror(root.right);
    }


}
