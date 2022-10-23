package TowardsOffer2.day_07.code_022;

import java.util.*;

class Solution {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        /*Set<ListNode> set = new HashSet<>();
        ListNode ans = null;
        while (head != null) {
            if (set.contains(head)) {
                ans=  head;
                break;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return ans;*/

        //快慢指针，如果快慢指针相遇，说明存在环
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            //证明存在环
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
