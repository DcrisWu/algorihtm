package ByteDance.code_25_K个一组翻转链表;

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
        if (k == 1) {
            return head;
        }
        int cnt = 0;
        ListNode now = head;
        while (now != null) {
            cnt++;
            now = now.next;
        }
        now = head;
        ListNode h = null;
        ListNode pre = new ListNode();
        ListNode res = pre;
        for (int i = 0; i < cnt; i++) {
            ListNode next = now.next;
            if (i % k == 0) {
                h = now;
            } else if (i % k == k - 1) {
                ListNode reverse = reverse(h, now.next);
                pre.next = reverse;
                pre = h;
            }
            now = next;
        }
        return res.next;
    }

    // [head,tail)，反转链表，链表最后一个指向tail
    ListNode reverse(ListNode head, ListNode tail) {
        ListNode now = head;
        ListNode pre = tail;
        while (now != tail) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
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
