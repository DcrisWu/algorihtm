package BasicCoding.day_14.code_143;

import java.util.Stack;

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

    public void reorderList(ListNode head) {
        ListNode begin = head;
        int len = 1;
        while (begin.next != null) {
            begin = begin.next;
            len++;
        }
        begin = head;
        Stack<ListNode> stack = new Stack<>();
        //将前面一半先放入栈中
        for (int i = 0; i < len / 2; i++) {
            stack.add(begin);
            begin = begin.next;
        }
        ListNode ans = null;
        if (len % 2 == 1) {
            ans = begin;
            begin = begin.next;
            ans.next = null;
        }
        while (!stack.isEmpty()) {
            ListNode first = stack.pop();
            ListNode second = begin;
            begin = begin.next;
            first.next = second;
            second.next = ans;
            ans = first;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        solution.reorderList(node1);

    }
}
