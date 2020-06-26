package LeetCode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class LeetCode_098 {

    /**
     * 使用二叉树的套路求解，即分别向两颗子树要信息。
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBST;
    }

    public ReturnData process(TreeNode x) {
        if(x == null) {
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        int min = x.val;
        int max = x.val;
        if(leftData!=null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData!=null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isBST = false;
        if(
                (leftData != null ? (leftData.isBST  &&  leftData.max < x.val) : true)
                        &&
                        (rightData !=null ? (rightData.isBST  && rightData.min > x.val) : true)
                ) {
            isBST = true;
        }
        return new ReturnData(isBST, min, max);
    }

    public class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
