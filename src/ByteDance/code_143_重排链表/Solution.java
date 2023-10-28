package ByteDance.code_143_重排链表;

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 使用快慢指针，获取中间节点
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        // 将后半部分节点反转
        ListNode a = head;
        ListNode b = reverse(slow);
        while (a != null && b != null) {
            ListNode na = a.next;
            ListNode nb = b.next;
            a.next = b;
            b.next = na;
            a = na;
            b = nb;
        }
        // 一定要将最后一个节点指向null，否则会出现循环链表
        if (a != null) {
            a.next = null;
        }
        if (b != null) {
            b.next = null;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
