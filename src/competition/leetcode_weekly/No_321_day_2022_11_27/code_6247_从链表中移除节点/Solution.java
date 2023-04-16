package competition.leetcode_weekly.No_321_day_2022_11_27.code_6247_从链表中移除节点;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.push(head);
        ListNode now = head.next;
        while (now != null) {
            while (!stack.isEmpty() && now.val > stack.peek().val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().next = now;
            }
            stack.push(now);
            now = now.next;
        }
        return stack.getLast();
    }
}

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