package ByteDance.code_23_合并K个升序链表;

import java.util.*;

/**
 * completion time = 2022.12.9
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new ArrayDeque<>();
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        if (q.isEmpty()) {
            return null;
        }
        while (q.size() > 1) {
            int size = q.size();
            size = size % 2 == 0 ? size : size - 1;
            for (int i = 0; i < size; i++) {
                ListNode first = q.poll();
                i++;
                if (i < size) {
                    q.add(merge(first, q.poll()));
                }
            }

        }
        return q.poll();
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode();
        ListNode pre = res;
        while (a != null && b != null) {
            if (a.val < b.val) {
                pre.next = a;
                a = a.next;
            } else {
                pre.next = b;
                b = b.next;
            }
            pre = pre.next;
        }
        if (a != null) {
            pre.next = a;
        }
        if (b != null) {
            pre.next = b;
        }
        return res.next;
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