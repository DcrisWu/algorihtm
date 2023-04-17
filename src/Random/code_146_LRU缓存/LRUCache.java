package Random.code_146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题的关键是，使用双向链表模拟最近被使用的时间
 * 使用HashMap快速定位该键值对所在的节点
 * 每次 get()/put()都将链表中最后一个节点删除，然后再加入到链表的头部
 * 淘汰的时候，只需要将链表最后一个节点删除，然后同时淘汰HashMap中的键值对
 * <p>
 * completion time = 2023.4.17
 */
class LRUCache {

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    void delete(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    void addTail(Node node) {
        Node pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1, head, null);
        head.next = tail;
        this.head = head;
        this.tail = tail;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        addTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 如果键已经存在，就变更数值
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            addTail(node);
        } else {
            // 如果容量已经满了，就需要淘汰一个
            if (map.size() >= capacity) {
                Node last = head.next;
                delete(last);
                map.remove(last.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addTail(node);
        }
    }
}
