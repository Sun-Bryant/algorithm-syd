package LeetCode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class LeetCode_114 {

    /**
     * 后序遍历，分治思想。
     *
     * 根据我们的观察，本题应该是使用深度优先搜索的方式来解决，我们看看是怎样变成一个列表的。
     *        1                 1                   1
     *       / \           2                         \
     *      2   5     -->   \        5      -->       2
     *     / \   \           3        \                \
     *    3   4   6           \        6                3
     *                         4                         \
     * 其实是分为三步：                                      4
     *  首先将根节点的左子树变成链表                            \
     *  其次将根节点的右子树变成链表                             5
     *  最后将变成链表的右子树放在变成链表的左子树的最右边            \
     *                                                       6
     *
     * 这就是一个递归的过程，递归的一个非常重要的点就是：不去管函数的内部细节是如何处理的，我们只看其函数作用以及输入与输出。对于函数flatten来说：
     * 函数作用：将一个二叉树，原地将它展开为链表
     * 输入：树的根节点
     * 输出：无
     * 那我们就直接根据三步来写程序就可以了
     *
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 将根节点的左子树变成链表
        flatten(root.left);
        // 将根节点的右子树变成链表
        flatten(root.right);
        TreeNode temp = root.right;
        // 将树的右边换成左边的链表
        root.right = root.left;
        // 将树的左边置空
        root.left = null;
        // 找到树的最右边节点，
        while (root.right != null) {
            root = root.right;
        }
        // 将右边的链表接到刚才树的最右边节点
        root.right = temp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
