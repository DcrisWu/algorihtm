package competition.leetcode_weekly.No_358_day_2023_8_13.code_6914_翻倍以链表形式表示的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.8.13
 */
class ListNode {
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

class Solution {
    public ListNode doubleIt(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode now = head;
        while (now != null) {
            list.add(now.val);
            now = now.next;
        }
        int carry = 0;
        ListNode last = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i) * 2 + carry;
            ListNode node = new ListNode(num % 10, last);
            carry = num / 10;
            last = node;
        }
        if (carry != 0) {
            last = new ListNode(carry, last);
        }
        return last;
    }
}
