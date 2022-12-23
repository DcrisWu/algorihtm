package TowardsOffer2_Special.day_09_链表.code_027_回文链表;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.10.21
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

    public boolean isPalindrome(ListNode head) {
/*        StringBuilder sb = new StringBuilder("");
        while (head != null){
            sb.append(head.val);
            head = head.next;
        }
        StringBuilder rev = new StringBuilder(sb);
        rev.reverse();
        return sb.toString().equals(rev.toString());*/
        List<Integer> mark = new ArrayList<>();
        while (head != null) {
            mark.add(head.val);
            head = head.next;
        }
        Object[] array = mark.toArray();
        int i = 0, j = array.length - 1;
        while (i <= j){
            if(array[i] == array[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
