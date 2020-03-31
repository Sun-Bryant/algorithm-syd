package Sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 24、二叉树中和为某一值的路径
 *
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class TwentyFour {

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
     *
     * 这道题题目中要求 (注意: 在返回值的list中，数组长度大的数组靠前)
     * 应该将最后生成的list中的各个数组按照数组的长度由大到小排序，因为在递归方法中list中数组的添加顺序并不能保证一定是长度最长的先添加进list ！
     * 如果不考虑这点，测试是可以通过的！所以牛客上的测试用例是不全面的。
     *
     * 运行时间：32ms
     * 占用内存：9872k
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();

        helper(root, target, cur, list);

        //Comparator对象来控制sort的排序方法的底层逻辑是：如果compare的返回值为正数，就交换进行比较的两个元素的位置。
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size() < o2.size()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return list;
    }

    private void helper(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        int value = root.val;
        cur.add(value);
        // 当当前节点的val值等于目标数的剩余值并且没有左右子节点的情况下，添加
        if (target == value && root.left == null && root.right == null) {
            list.add(new ArrayList<>(cur));
        } else {
            helper(root.left, target - value, cur, list);
            helper(root.right, target - value, cur, list);
        }
        //移除当前节点，相当于回溯到上一个节点
        cur.remove(cur.size() - 1);
    }
}
