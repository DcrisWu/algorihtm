package ByteDance.code_82_删除排序链表中的重复元素II;

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
 * completion time = 2023.8.18
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode pre = res;
        ListNode now = head;
        while (now != null) {
            ListNode h = now;
            while (now.next != null && now.next.val == h.val) {
                now = now.next;
            }
            // 只有一个
            if (now == h) {
                pre = now;
            } else {
                // 存在重复，那就全部删除
                pre.next = now.next;
            }
            now = now.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode pre = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode();
            listNode.val = arr[i];
            listNode.next = pre;
            pre = listNode;
        }
        System.out.println(new Solution().deleteDuplicates(pre));
    }
}
