package TowardsOffer.day_12_双指针_简单.code_52_两个链表的第一个公共节点;

/**
 * completion time = 2022.12.2
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        // 如果有相交部分，那么 a == b，跳出循环
        // 如果不想交, 那么移动 m+n次后，a 和 b 会同时等于 null，然后 a != b条件不满足，跳出循环
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}