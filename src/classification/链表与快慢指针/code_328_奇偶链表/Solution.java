package classification.链表与快慢指针.code_328_奇偶链表;

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

/**
 * completion time = 2023.3.20
 */
class Solution {
    /**
     * 奇偶链表，只要将链表分为一个奇链表和一个偶链表，然后再将奇链表的尾部连上偶链表的头部即可
     * Attention: 偶链表的尾部最后要指向null，不然会存在循环
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode now = head;
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode odd = null;
        ListNode even = null;
        int i = 1;
        while (now != null) {
            if (i == 1) {
                oddHead = now;
                odd = now;
            } else if (i == 2) {
                evenHead = now;
                even = now;
            } else if (i % 2 == 1) {
                odd.next = now;
                odd = odd.next;
            } else {
                even.next = now;
                even = even.next;
            }
            now = now.next;
            i++;
        }
        if (oddHead == null) {
            return null;
        }
        odd.next = evenHead;
        if (even != null){
            even.next = null;
        }
        return oddHead;
    }
}
