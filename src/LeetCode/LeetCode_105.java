package LeetCode;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。

 * 例如，给出
 *  前序遍历 preorder = [3,9,20,15,7]
 *  中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode_105 {


    /**
     * 参考：
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    // 左闭右开
    public TreeNode dfs(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                        HashMap<Integer,Integer> map) {
        if (p_start >= p_end || i_start >= p_end) {
            return null;
        }
        // 创建根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int root_index = map.get(root_val);
        int left_num = root_index - i_start;

        //递归的构造左子树
        root.left = dfs(preorder, p_start + 1, p_start + 1 + left_num, inorder, i_start, root_index, map);
        //递归的构造右子树
        root.right = dfs(preorder, p_start + 1 + left_num, p_end, inorder, root_index + 1, i_end, map);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
