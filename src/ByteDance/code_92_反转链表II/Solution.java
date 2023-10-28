package ByteDance.code_92_反转链表II;

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
 * completion time = 2023.10.28
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode now = head;
        int cnt = 0;
        while (now != null) {
            cnt++;
            now = now.next;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode last = null, begin = null, tail = null;
        now = res;
        for (int i = 0; i <= cnt; i++) {
            if (i == left - 1) {
                last = now;
            }
            if (i == left) {
                begin = now;
            }
            if (i == right) {
                tail = now.next;
            }
            now = now.next;
        }
        ListNode pre = tail;
        now = begin;
        while (now != tail) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        last.next = pre;
        return res.next;


    }
}