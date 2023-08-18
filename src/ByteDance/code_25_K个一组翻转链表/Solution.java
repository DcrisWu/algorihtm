package ByteDance.code_25_K个一组翻转链表;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        // 用一个节点，表示头，一定要初始化th.next = head
        ListNode th = new ListNode();
        th.next = head;
        ListNode start = null;
        // pre是用来表示反转后的前一段的最后节点
        ListNode pre = th;
        ListNode now = head;
        for (int i = 0; i <= count; i++) {
            if (i % k == 0) {
                if (start != null) {
                    ListNode nh = reverse(start, now);
                    pre.next = nh;
                    start.next = now;
                    pre = start;
                }
                start = now;
            }
            if (i < count){
                now = now.next;
            }
        }
        return th.next;
    }

    ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode pre = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode();
            node.val = arr[i];
            node.next = pre;
            pre = node;
        }
        System.out.println(new Solution().reverseKGroup(pre, 2));
    }
}
