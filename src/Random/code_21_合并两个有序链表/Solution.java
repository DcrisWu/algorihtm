package Random.code_21_合并两个有序链表;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode now = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                now.next = list1;
                list1 = list1.next;
            } else {
                now.next = list2;
                list2 = list2.next;
            }
            now = now.next;
        }
        if (list1 != null){
            now.next = list1;
        }
        if (list2 != null){
            now.next = list2;
        }
        return head;
    }
}
