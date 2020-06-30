package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class LeetCode_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length , postorder, 0, postorder.length , map);
    }

    // 左闭右开
    private TreeNode dfs(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end,                                    Map<Integer, Integer> map) {
        if (p_start >= p_end || i_start >= i_end) {
            return null;
        }
        int root_val = postorder[p_end - 1];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int root_index = map.get(root_val);
        int left_num = root_index - i_start;
        //递归的构造左子树
        root.left = dfs(inorder, i_start, root_index, postorder, p_start, p_start + left_num, map);
        //递归的构造右子树
        root.right = dfs(inorder, root_index + 1, i_end, postorder, p_start + left_num, p_end - 1, map);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
