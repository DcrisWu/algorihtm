package TowardsOffer.day_12_双指针_简单.code_25_合并两个排序的链表;

/**
 * completion time = 2022.12.2
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode now = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                now.next = l1;
                l1 = l1.next;
            } else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        while (l1 != null) {
            now.next = l1;
            l1 = l1.next;
            now = now.next;
        }
        while (l2 != null) {
            now.next = l2;
            l2 = l2.next;
            now = now.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
