package TowardsOffer.day_2_链表.code_06_从尾到头打印链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}