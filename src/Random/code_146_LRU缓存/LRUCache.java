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
 * <p>
 * LRU需要用链表来快速删除节点，同时添加到头节点
 * 第二次做题 completion time = 2023.7.27
 */
class LRUCache {

    private class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }

    private void addPeek(Node node) {
        Node temp = head.next;
        head.next = node;
        temp.pre = node;
        node.pre = head;
        node.next = temp;
    }

    // 淘汰最后一个，并返回最后一个的key
    private int deleteTail() {
        Node needDelete = end.pre;
        needDelete.pre.next = end;
        end.pre = needDelete.pre;
        return needDelete.key;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // head和end不作为实际使用
    private Node head;
    private Node end;
    private int capacity;
    private Map<Integer, Node> lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lru = new HashMap<>();
        head = new Node();
        end = new Node();
        head.next = end;
        end.pre = head;
    }

    public int get(int key) {
        if (!lru.containsKey(key)) {
            return -1;
        }
        Node node = lru.get(key);
        deleteNode(node);
        addPeek(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (lru.containsKey(key)) {
            Node node = lru.get(key);
            node.val = value;
            deleteNode(node);
            addPeek(node);
        } else {
            // 直接插入就可以
            if (lru.size() < capacity) {
                Node node = new Node();
                node.key = key;
                node.val = value;
                lru.put(key, node);
                addPeek(node);
            } else {
                // 需要淘汰最后一个再插入
                int lastKey = deleteTail();
                lru.remove(lastKey);
                Node node = new Node();
                node.key = key;
                node.val = value;
                lru.put(key, node);
                addPeek(node);
            }
        }
    }
}
