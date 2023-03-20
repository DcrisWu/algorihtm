package classification.链表与快慢指针.code_141_环形链表;

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
    /**
     * 快慢指针总结：
     * 因为题目想要找的是是否存在一个环，如果存在环，那么每个节点 node.next != null，如果node.next == null，则说明不存在环，直接返回false即可
     * 因为快指针每次移动两个位置，慢指针只会移动一个位置，那么在每次移动中，快指针与慢指针的距离都会 + 1
     * 如果存在环，那么在循环 k 次后，快指针与慢指针的路程就会相差 k
     * 那么当 k = 链表中环的长度时候，快慢指针就会相遇，此时 slow == fast，就可以退出循环返回 true
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        if (slow.next == null) {
            return false;
        }
        ListNode fast = slow.next;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                return false;
            }
            fast = fast.next;
            if (fast == null){
                return false;
            }
        }
        return true;
    }
}
