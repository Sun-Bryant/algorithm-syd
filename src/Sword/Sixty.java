package Sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 60、把二叉树打印成多行
 *
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Sixty {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 之字形打印用两个栈
     * 层次打印用两个队列
     *
     * 运行时间：20ms
     * 占用内存：9400k
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Queue<TreeNode> s1 = new LinkedList<>();
        s1.add(pRoot);
        //s2存偶数层节点
        Queue<TreeNode> s2 = new LinkedList<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (layer % 2 != 0) { // 奇数层
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.remove();
                    if (node != null) {
                        temp.add(node.val);
                        s2.add(node.left);
                        s2.add(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            } else { // 偶数层
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.remove();
                    if (node != null) {
                        temp.add(node.val);
                        s1.add(node.left);
                        s1.add(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            }
        }
        return list;
    }
}
