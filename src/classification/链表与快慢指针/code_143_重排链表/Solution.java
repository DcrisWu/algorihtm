package classification.链表与快慢指针.code_143_重排链表;

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
 * completion time = 2023.8.15
 */
class Solution {
    public void reorderList(ListNode head) {
        // 快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == fast) {
            return;
        }
        ListNode tail = null;
        // 先对链表进行反转
        ListNode reverse = reverse(slow);
        ListNode n1 = head;
        ListNode n2 = reverse;
        // 将链表拼接
        while (n1 != reverse && n2 != null) {
            ListNode n1next = n1.next;
            ListNode n2next = n2.next;
            if (tail == null) {
                tail = n1;
            } else {
                tail.next = n1;
                tail = tail.next;
            }
            tail.next = n2;
            tail = tail.next;
            n1 = n1next;
            n2 = n2next;
        }
        // 如果是奇数个节点，就再加上
        if (n1 != slow) {
            tail.next = n1;
        }
    }

    ListNode reverse(ListNode root) {
        ListNode now = root;
        ListNode pre = null;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        new Solution().reorderList(n1);
    }
}
