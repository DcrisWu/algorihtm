package TowardsOffer2.day_09_链表.code_029_排序的循环链表;

/**
 * completion time = 2022.10.22
 */
class Solution {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node pre = head;
        Node next = head.next;
        while (next != head && !((insertVal >= pre.val && insertVal <= next.val) || (insertVal > pre.val && pre.val > next.val) || (insertVal < next.val && pre.val > next.val))) {
            next = next.next;
            pre = pre.next;
        }
        pre.next = new Node(insertVal, next);
        return head;
    }
}
