package Sword;


import java.util.Arrays;

/**
 * 4、重建二叉树
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Four {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 因为是树的结构，一般都是用递归来实现。
     *
     * 用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，那么我只要考虑将root的左右子树安上去即可。
     * 根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
     * 根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
     * 正如上面所说，只需要将确定的左右子树安到root上即可。递归要注意出口，假设最后只有一个元素了，那么就要返回。
     *
     * 运行时间：230ms
     * 占用内存：22428k
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //数组长度为0的时候要特殊处理
        if (pre.length == 0) {
            return null;
        }

        int rootVal = pre[0];

        // 递归出口
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 找到根节点在in数组中的位置。即确定好前序和中序中左子树和右子树序列的范围
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(pre,in).left.val);
    }
}
