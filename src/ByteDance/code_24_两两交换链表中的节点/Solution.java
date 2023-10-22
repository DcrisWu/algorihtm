package ByteDance.code_24_两两交换链表中的节点;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * completion time = 2023.10.22
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        ListNode res = pre;
        res.next = head;
        ListNode now = head;
        while (now != null) {
            ListNode first = now;
            now = now.next;
            if (now != null) {
                first.next = now.next;
                now.next = first;
                pre.next = now;
                pre = first;
                now = first.next;
            }
        }
        return res.next;
    }
}
