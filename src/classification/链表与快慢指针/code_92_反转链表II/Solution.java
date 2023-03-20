package classification.链表与快慢指针.code_92_反转链表II;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode now = head;
        ListNode first = null, last = null, begin = null;
        int count = 1;
        ListNode pre = null;
        /*
        关键是找到需要反转的链表的前一个和后一个
         */
        while (now != null) {
            if (count == left) {
                first = pre;
                begin = now;
            }
            if (count == right) {
                last = now.next;
                break;
            }
            pre = now;
            now = now.next;
            count++;
        }
        // 常规的反转链表
        pre = null;
        now = begin;
        while (now != last) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        // 需要反转的链表反转前的第一个节点，一定要指向last，last 可以为 null 也可以为一个普通的节点
        begin.next = last;
        // 如果first为null，那么直接返回反转链表后的第一个节点
        if (first == null){
            return pre;
        }
        // 否则，first.next = pre
        first.next = pre;
        return head;
    }
}
