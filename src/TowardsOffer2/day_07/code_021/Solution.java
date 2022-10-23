package TowardsOffer2.day_07.code_021;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.19
 */
class Solution {
    private static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        int len = 0;
        ListNode now = head;
        while (now != null) {
            map.put(len++, now);
            now = now.next;
        }
        if (n == len) {
            return head.next;
        } else {
            ListNode pre = map.get(len - n - 1);
            ListNode next = map.getOrDefault(len - n + 1, null);
            pre.next = next;
            return head;
        }
    }
}
