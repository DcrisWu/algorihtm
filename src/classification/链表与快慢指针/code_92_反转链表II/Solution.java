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
        int count = 0;
        ListNode now = head;
        ListNode pre = null, tail = null;
        while (now != null) {
            count++;
            if (count == left - 1) {
                pre = now;
            }
            if (count == right + 1) {
                tail = now;
            }
            now = now.next;
        }
        // 主要需要判断一下，反转后前面是否还有节点
        if (pre == null) {
            return reverse(head, tail);
        }
        pre.next = reverse(pre.next, tail);
        return head;
    }

    // 将需要反转那部分链表抽象出来一个函数，传递开头以及一个终止符号
    ListNode reverse(ListNode root, ListNode end) {
        ListNode now = root;
        ListNode pre = end;
        while (now != end) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
