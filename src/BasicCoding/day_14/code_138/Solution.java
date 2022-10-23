package BasicCoding.day_14.code_138;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.9
 */
public class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> pre = new HashMap<>();
        Map<Integer, Node> brand = new HashMap<>();
        int index = 0;
        //如果不为空，就先讲第一个节点存进去
        pre.putIfAbsent(head, index);
        Node begin = new Node(head.val);
        brand.putIfAbsent(index++, begin);
        Node now = head;
        Node newNow = begin;
        while (now.next != null) {
            Node newNext = new Node(now.next.val);
            newNow.next = newNext;
            pre.putIfAbsent(now.next, index);
            brand.putIfAbsent(index++, newNext);
            now = now.next;
            newNow = newNow.next;
        }
        Node in = head;
        while (in != null) {
            Integer key = pre.get(in);
            //可能random指向null
            if (pre.containsKey(in.random)) {
                Integer randomKey = pre.get(in.random);
                brand.get(key).random = brand.get(randomKey);
            }
            in = in.next;
        }
        return begin;
    }
}
