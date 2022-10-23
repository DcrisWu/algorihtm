package BasicCoding.day_15.code_2;

/**
 * completion time = 2022.10.9
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode now = new ListNode(sum);
        ListNode ans = now;
        ListNode l = l1.next;
        ListNode r = l2.next;
        while (l != null && r != null) {
            sum = (l.val + r.val + carry) % 10;
            carry = (l.val + r.val + carry) / 10;
            now.next = new ListNode(sum);
            now = now.next;
            l = l.next;
            r = r.next;
        }
        while (l != null){
            sum = (l.val + carry) % 10;
            carry = (l.val + carry) / 10;
            now.next = new ListNode(sum);
            now = now.next;
            l = l.next;
        }
        while (r != null){
            sum = (r.val + carry) % 10;
            carry = (r.val + carry) / 10;
            now.next = new ListNode(sum);
            now = now.next;
            r = r.next;
        }
        if(carry != 0){
            now.next = new ListNode(carry);
        }
        return ans;
    }
}
