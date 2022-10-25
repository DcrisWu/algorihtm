package TowardsOffer2.day_08_链表.code_024_反转链表;

/**
 * completion time = 2022.10.20
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode now = head.next;
        pre.next = null;
        while (now.next != null) {
            ListNode temp = now;
            now = now.next;
            temp.next = pre;
            pre = temp;
        }
        now.next = pre;
        return now;
    }
}
