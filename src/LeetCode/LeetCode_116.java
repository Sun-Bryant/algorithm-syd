package LeetCode;

import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 示例：
 * 输入   [1,2,3,4,5,6,7]
 * 输出   [1,#,2,3,#,4,5,6,7,#]
 *
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class LeetCode_116 {

    // 递归
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    /**
     * 解题思路
     * 每个 node 左子树的 next , 就是 node 的右子树
     * 每个 node 右子树的 next, 就是 node next 的 左子树
     */
    private void dfs(Node node, Node next) {
        if (node != null) {
            node.next = next;
            dfs(node.left, node.right); // 每个 node 左子树的 next , 就是 node 的右子树
            dfs(node.right, node.next != null ? node.next.left : null); // 每个 node 右子树的 next, 就是 node next 的 左子树
        }
    }

    // bfs
//    public Node connect(Node root) {
//        if(root == null) return root;
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            Node pre = null;
//            for (int i = 0 ; i < size; i++) {
//                Node cur = queue.poll();
//                if (i > 0) { //从第二个节点开始，将前一个节点的 pre 指向当前节点
//                    pre.next = cur;
//                }
//                pre = cur;
//                if (cur.left != null) {
//                    queue.add(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.add(cur.right);
//                }
//            }
//        }
//        return root;
//    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
