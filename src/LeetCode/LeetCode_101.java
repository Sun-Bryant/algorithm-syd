package LeetCode;

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
