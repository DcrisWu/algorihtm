package classification.链表与快慢指针.code_148_排序链表;

import java.util.ArrayList;
import java.util.Comparator;
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

class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort(Comparator.comparingInt(a -> a.val));
        int n = list.size();
        ListNode now = null;
        for (int i = n - 1; i >= 0; i--) {
            ListNode node = list.get(i);
            node.next = now;
            now = node;
        }
        return now;
    }
}
