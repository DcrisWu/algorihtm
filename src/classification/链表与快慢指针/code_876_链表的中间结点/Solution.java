package classification.链表与快慢指针.code_876_链表的中间结点;

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

/**
 * completion time = 2023.3.20
 */
class Solution {
    /**
     * 快慢指针，有两种情况：
     * 1. 奇数个节点：在一个循环中，fast走第一步后，发现自己是null，说明这个链表是奇数个节点，那么slow不用走了，就是中间节点，直接返回
     * 2. 偶数个节点：在循环结束后，开启一个新循环前条件判断 fast == null，说明有偶数个节点，那fast和slow都不用走了，直接返回
     * 只要正确处理奇数个还是偶数个节点就很简单，推荐在实际时候直接画图更容易理解
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}