package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class LeetCode_138 {

    // 第一种方法：哈希表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 第二种方法：复制
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        //第一步，在每个原节点后面创建一个新节点
//        //1->1'->2->2'->3->3'
//        Node cur = head;
//        while (cur != null) {
//            Node node = new Node(cur.val);
//            node.next = cur.next;
//            cur.next = node;
//            cur = cur.next.next;
//        }
//        // 第二步，设置新节点的随机节点
//        cur = head;
//        while (cur != null) {
//            if (cur.random != null) {
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//        //第三步，将两个链表分离
//        cur = head;
//        Node newHead = new Node(-1);
//        Node p = newHead;
//        while (cur != null) {
//            p.next = cur.next;
//            p = p.next;
//            cur.next = p.next;
//            cur = cur.next;
//        }
//        return newHead.next;
//    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
