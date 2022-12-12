package ByteDance.code_23_合并K个升序链表;

/**
 * completion time = 2022.12.9
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    ListNode divide(ListNode[] lists, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return lists[begin];
        }
        if (begin + 1 == end) {
            return merge(lists[begin], lists[end]);
        }
        int mid = (begin + end) >> 1;
        return merge(divide(lists, begin, mid), divide(lists, mid + 1, end));
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode begin = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                begin.next = l1;
                begin = begin.next;
                l1 = l1.next;
            } else {
                begin.next = l2;
                begin = begin.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            begin.next = l1;
        }
        if (l2 != null) {
            begin.next = l2;
        }
        return head;
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