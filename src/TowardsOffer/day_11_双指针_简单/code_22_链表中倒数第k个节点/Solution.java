package TowardsOffer.day_11_双指针_简单.code_22_链表中倒数第k个节点;

/**
 * completion time = 2022.12.2
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode begin = head;
        ListNode tail = head;
        for (int i = 0; i < k - 1 && tail.next != null; i++) {
            tail = tail.next;
        }
        while (tail.next != null){
            begin = begin.next;
            tail = tail.next;
        }
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
