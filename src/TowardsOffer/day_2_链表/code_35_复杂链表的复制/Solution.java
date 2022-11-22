package TowardsOffer.day_2_链表.code_35_复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.11.22
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node begin = head;
        while (begin != null) {
            map.putIfAbsent(begin, new Node(begin.val));
            Node now = map.get(begin);
            if (begin.next != null) {
                // 假如这个节点还没被出来，就执行这一步
                map.putIfAbsent(begin.next, new Node(begin.next.val));
                now.next = map.get(begin.next);
            }
            if (begin.random != null) {
                map.putIfAbsent(begin.random, new Node(begin.random.val));
                now.random = map.get(begin.random);
            }
            begin = begin.next;
        }
        return map.get(head);
    }
}

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
