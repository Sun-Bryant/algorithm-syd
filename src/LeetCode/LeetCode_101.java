package LeetCode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class LeetCode_101 {

    /**
     * 左子树的左子树和右子树的右子树相同 ， 左子树的右子树和右子树的左子树相同即可
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

    public boolean process(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; //都为null，返回空。
        if(p == null || q == null) return false; // 其中一个为null，返回false
        if(p.val != q.val) {
            return false;
        }
        return process(p.left, q.right) && process(p.right, q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
