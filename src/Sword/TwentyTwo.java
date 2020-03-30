package Sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 22、从上往下打印二叉树
 *
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class TwentyTwo {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 广度优先搜索：BFS
     *
     * 广搜的套路就是用一个队列保存将要搜索的这一层的元素，然后逐个搜索；
     * 1、将第一个元素加入队列
     * 2、队列不为空时取队首元素
     * 3、将下一层元素加入队尾
     * 4、调到第二步，直到队列为空
     *
     * 运行时间：16ms
     * 占用内存：9452k
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
    }

}
