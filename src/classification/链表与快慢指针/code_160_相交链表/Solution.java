package classification.链表与快慢指针.code_160_相交链表;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * completion time = 2023.3.20
 */
public class Solution {
    /*
    * 假设 A 和 B 有相交节点，则 A = a + c, B = b + c
    * A、B 把两条路径都走一遍后，A = a + c + b + c, B = b + c + a + c
    * 因此只要有相交节点，它们一定会相交
    * Attention:
    * 不可以用
    * while (a != b) {
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }
    * 因为A和B可能没有相交节点，如果用上述代码，A和B只能永远不断走下去，陷入死循环
    * 为避免这种情况，需要将null值也作为A和B走过的路径，即允许A和B的值为null
    * while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
