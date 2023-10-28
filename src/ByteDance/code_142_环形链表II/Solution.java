package ByteDance.code_142_环形链表II;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * completion time = 2023.10.28
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        // slow 走了 s 步，fast走了 2s 步
        // fast 比 slow 多走了 n 个环，设非环部分长度为 a，环长度为 b，那么s = n*b
        // 随后让 fast 回到 head，fast和 slow每轮走 1 步，那么 a步之后
        // slow = n * b + a, fast = a
        // 当它们相遇时，a 就是第一个相交的点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
