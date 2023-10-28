package ByteDance.code_25_K个一组翻转链表;

import java.util.List;

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

/**
 * completion time = 2023.8.18
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode now = head;
        while (now != null) {
            cnt++;
            now = now.next;
        }
        now = head;
        ListNode pre = new ListNode();
        ListNode res = pre;
        ListNode begin = null;
        for (int i = 0; i < cnt; i++) {
            // 先把 now.next 记录下来，不然反转后会变化
            ListNode next = now.next;
            if (i % k == 0) {
                begin = now;
            }
            if (i % k == k - 1) {
                ListNode reverse = reverse(begin, now.next);
                pre.next = reverse;
                pre = begin;
            }
            now = next;
        }
        return res.next;
    }

    // [head,tail)，反转链表，链表最后一个指向tail
    ListNode reverse(ListNode head, ListNode tail) {
        // 反转后，需要把头尾连接好
        ListNode pre = tail;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode pre = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode();
            node.val = arr[i];
            node.next = pre;
            pre = node;
        }
        System.out.println(new Solution().reverseKGroup(pre, 2));
    }
}
