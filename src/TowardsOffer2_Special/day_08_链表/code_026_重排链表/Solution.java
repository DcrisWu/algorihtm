package TowardsOffer2_Special.day_08_链表.code_026_重排链表;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * completion time = 2022.10.20
 */
public class Solution {

    public class ListNode {
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

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }
        ListNode ans = deque.pollFirst();
        ListNode tail = ans;
        if (!deque.isEmpty()) {
            ans.next = deque.pollLast();
            tail = ans.next;
        }
        tail.next = null;
        while (!deque.isEmpty()) {
            ListNode now = deque.pollFirst();
            now.next = null;
            if (!deque.isEmpty()) {
                now.next = deque.pollLast();
            }
            tail.next = now;
            tail = Objects.requireNonNullElse(now.next, now);
            tail.next = null;
        }
    }
}
