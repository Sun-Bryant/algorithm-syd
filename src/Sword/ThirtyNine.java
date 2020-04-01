package Sword;

/**
 * 39、平衡二叉树
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class ThirtyNine {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 最直接的做法，遍历每个结点，借助一个获取树深度的递归函数，根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
     *
     * 运行时间：20ms
     * 占用内存：9300k
     */
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        // 当前节点的左右子树的高度差不超过1 并且子树的左右子树也满足这个条件
//        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <=1 &&
//                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//
//    public int TreeDepth(TreeNode root) {
//        if (root == null) { // 当树为空直接返回0
//            return 0;
//        } else {
//            return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
//        }
//    }

    /**
     * 上面的做法有很明显的缺陷，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
     * 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     *
     * 运行时间：15ms
     * 占用内存：9424k
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
