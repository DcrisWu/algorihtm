package ByteDance.code_82_删除排序链表中的重复元素II;

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
        ListNode nh = new ListNode();
        nh.next = head;
        ListNode pre = nh;
        ListNode now = head;
        while (now != null) {
            ListNode start = null;
            ListNode tail = null;
            while (now.next != null && now.val == now.next.val) {
                if (start == null) {
                    start = now;
                }
                tail = now.next;
                now = now.next;
            }
            if (start != null) {
                pre.next = tail.next;
            } else {
                pre = now;
            }
            now = now.next;
        }
        return nh.next;
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
