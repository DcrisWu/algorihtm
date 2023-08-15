package classification.链表与快慢指针.code_206_反转链表;

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
class Solution {
    /**
     * 反转链表的关键是需要记录三个节点: pre, now, next
     * 操作的关键是now
     * 因为要反转，即 now.next = pre，那么我们需要提前记录 next = now.next，再操作 now . next = pre
     * 然后 pre = now, now = next
     * 当 now == null 时候，说明已经反转完成，pre 就是反转链表的 head
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
