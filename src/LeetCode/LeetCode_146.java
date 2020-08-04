package LeetCode;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2 是缓存容量 );
 *
 *       *cache.put(1,1);
 *       *cache.put(2,2);
 *       *cache.get(1);       // 返回  1
 *       *cache.put(3,3);    // 该操作会使得关键字 2 作废
 *       *cache.get(2);       // 返回 -1 (未找到)
 *       *cache.put(4,4);    // 该操作会使得关键字 1 作废
 *       *cache.get(1);       // 返回 -1 (未找到)
 *       *cache.get(3);       // 返回  3
 *       *cache.get(4);       // 返回  4
 */
public class LeetCode_146 {

    // 哈希链表
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LeetCode_146(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    class Node{
        private int key, val;
        private Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
        }
        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            if(size == 0) return null;
            Node last_node = tail.prev;
            remove(last_node);
            return last_node;
        }
        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }
}
