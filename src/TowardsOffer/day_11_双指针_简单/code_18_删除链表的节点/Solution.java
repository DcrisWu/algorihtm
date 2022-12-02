package TowardsOffer.day_11_双指针_简单.code_18_删除链表的节点;

/**
 * completion time = 2022.12.1
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode now = head.next;
        while (now != null) {
            if (now.val == val) {
                pre.next = now.next;
                break;
            }
            pre = now;
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