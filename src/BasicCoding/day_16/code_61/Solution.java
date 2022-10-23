package BasicCoding.day_16.code_61;

/**
 * completion time = 2022.10.9
 */
public class Solution {
    public static class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode end = head;
        int len = 1;
        while (end.next != null) {
            end = end.next;
            len++;
        }
        k %= len;
        if(k == 0){
            return head;
        }
        ListNode now = head;
        ListNode pre = null;
        for (int i = 0; i < len - k; i++) {
            pre = now;
            now = now.next;
        }
        if(pre != null){
            pre.next = null;
        }
        end.next = head;
        return now;
    }
}
