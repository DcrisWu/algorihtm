package TowardsOffer2_Special.day_08_链表.code_025_链表中的两数相加;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        s1.reverse();
        s2.reverse();
        int carry = 0;
        int sum = 0;
        int i = 0, j = 0;
        sum = (s1.charAt(i) - '0' + s2.charAt(j) - '0') % 10;
        carry = (s1.charAt(i) - '0' + s2.charAt(j) - '0') / 10;
        i += 1;
        j += 1;
        ListNode ans = new ListNode(sum);
        while (i < s1.length() && j < s2.length()) {
            sum = (s1.charAt(i) - '0' + s2.charAt(j) - '0' + carry) % 10;
            carry = (s1.charAt(i) - '0' + s2.charAt(j) - '0' + carry) / 10;
            ListNode now = new ListNode(sum);
            now.next = ans;
            ans = now;
            i += 1;
            j += 1;
        }
        while (i < s1.length()){
            sum = (s1.charAt(i) - '0' + carry) % 10;
            carry = (s1.charAt(i) - '0' + carry) / 10;
            ListNode now = new ListNode(sum);
            now.next = ans;
            ans = now;
            i += 1;
        }
        while (j < s2.length()){
            sum = (s2.charAt(j) - '0' + carry) % 10;
            carry = (s2.charAt(j) - '0' + carry) / 10;
            ListNode now = new ListNode(sum);
            now.next = ans;
            ans = now;
            j += 1;
        }
        if(carry != 0){
            ListNode listNode = new ListNode(carry);
            listNode.next = ans;
            ans = listNode;
        }
        return ans;
    }
}
