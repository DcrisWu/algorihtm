package Random.code_23_合并K个升序链表;

import Pack.Pair;

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

    public static void main(String[] args) {
        ListNode l3 = new ListNode(5);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(1, l5);

        ListNode l8 = new ListNode(6);
        ListNode l7 = new ListNode(2, l8);
        ListNode[] lists = {l1, l4, l7};
        Solution solution = new Solution();
        ListNode listNode = solution.mergeKLists(lists);
        int a = 0;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) >> 1;
        ListNode lList = mergeSort(lists, left, mid);
        ListNode rList = mergeSort(lists, mid + 1, right);
        if (lList == null) return rList;
        if (rList == null) {
            return lList;
        }
        ListNode head = null;
        if (lList.val < rList.val) {
            head = lList;
            lList = lList.next;
        } else {
            head = rList;
            rList = rList.next;
        }
        ListNode now = head;
        while (lList != null && rList != null) {
            if (lList.val < rList.val) {
                now.next = lList;
                lList = lList.next;
            } else {
                now.next = rList;
                rList = rList.next;
            }
            now = now.next;
        }
        if (lList != null) {
            now.next = lList;
        }
        if (rList != null) {
            now.next = rList;
        }
        return head;
    }
}