package Random.code_19_删除链表的倒数第N个结点;


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode now = head;
        int count = 0;
        while (now != null) {
            count++;
            now = now.next;
        }
        // 注意删除的是头节点的情况
        if (count == n){
            return head.next;
        }
        int index = 0;
        now = head;
        ListNode pre = null;
        while (now != null) {
            index++;
            if (index == count - n + 1) {
                pre.next = now.next;
                break;
            }
            pre = now;
            now = now.next;
        }
        return head;
    }
}
