package BasicCoding.day_15.code_445;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer l = new StringBuffer("");
        StringBuffer r = new StringBuffer("");
        ListNode l_now = l1;
        ListNode r_now = l2;
        while (l_now != null) {
            l.append(l_now.val);
            l_now = l_now.next;
        }
        while (r_now != null) {
            r.append(r_now.val);
            r_now = r_now.next;
        }
        l.reverse();
        r.reverse();
        int l_len = l.length();
        int r_len = r.length();
        int i = 0, j = 0;
        StringBuffer temp = new StringBuffer("");
        int sum = 0, carry = 0;
        while (i < l_len && j < r_len) {
            sum = (l.charAt(i) - '0' + r.charAt(j) - '0' + carry) % 10;
            carry = (l.charAt(i) - '0' + r.charAt(j) - '0' + carry) / 10;
            temp.append(sum);
            i++;
            j++;
        }
        while (i < l_len) {
            sum = (l.charAt(i) - '0' + carry) % 10;
            carry = (l.charAt(i) - '0' + carry) / 10;
            temp.append(sum);
            i++;
        }
        while (j < r_len) {
            sum = (r.charAt(j) - '0' + carry) % 10;
            carry = (r.charAt(j) - '0' + carry) / 10;
            temp.append(sum);
            j++;
        }
        if (carry != 0) {
            temp.append(carry);
        }
        ListNode ans = new ListNode(temp.charAt(temp.length() - 1) - '0');
        ListNode now = ans;
        for (int k = temp.length() - 2; k >= 0; k--) {
            now.next = new ListNode(temp.charAt(k) - '0');
            now = now.next;
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        System.out.println(solution.addTwoNumbers(l1, l2));
    }
}