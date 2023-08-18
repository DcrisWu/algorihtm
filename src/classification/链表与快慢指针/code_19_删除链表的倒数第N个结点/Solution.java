package classification.链表与快慢指针.code_19_删除链表的倒数第N个结点;

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
 * completion time = 2023.8.18
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode now = head;
        while (now != null) {
            count++;
            now = now.next;
        }
        now = head;
        ListNode pre = null;
        for (int i = 0; i < count - n; i++) {
            pre = now;
            now = now.next;
        }
        if (pre == null){
            return head.next;
        }
        pre.next = now.next;
        return head;
    }
}