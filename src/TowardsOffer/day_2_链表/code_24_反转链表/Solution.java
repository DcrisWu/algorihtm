package TowardsOffer.day_2_链表.code_24_反转链表;

/**
 * completion time = 2022.11.21
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode begin = pre.next;
        pre.next = null;
        while (begin.next != null) {
            ListNode next = begin.next;
            begin.next = pre;
            pre = begin;
            begin = next;
        }
        begin.next = pre;
        return begin;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}