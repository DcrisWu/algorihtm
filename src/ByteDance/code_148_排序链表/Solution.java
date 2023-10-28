package ByteDance.code_148_排序链表;

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
 * completion time = 2023.10.28
 */
class Solution {
    public static void main(String[] args) {
        ListNode res = new ListNode();
        ListNode pre = res;
        int[] arr = {4, 2, 1, 3};
        for (int i : arr) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        new Solution().sortList(res.next);
    }

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    // 归并排序
    ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode first = sort(head, slow);
        ListNode second = sort(slow, tail);
        return merge(first, second);
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode();
        ListNode prev = res;
        while (a != null && b != null) {
            if (a.val < b.val) {
                prev.next = a;
                prev = a;
                a = a.next;
            } else {
                prev.next = b;
                prev = b;
                b = b.next;
            }
        }
        if (a != null) {
            prev.next = a;
        }
        if (b != null) {
            prev.next = b;
        }
        return res.next;
    }
}