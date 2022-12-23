package TowardsOffer2_Special.day_26_排序.code_077_链表排序;

/**
 * completion time = 2022.11.5
 * 归并排序消耗的空间是O(1)，时间是O(nlog(n))
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    ListNode sort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail) {
                fast = fast.next;
            }
        }
        ListNode next = slow.next;
        ListNode left = sort(head, next);
        ListNode right = sort(next, tail);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode ans = null;
        if (left.val <= right.val) {
            ans = left;
            left = left.next;
        } else {
            ans = right;
            right = right.next;
        }
        ListNode now = ans;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                now.next = left;
                now = now.next;
                left = left.next;
            } else {
                now.next = right;
                now = now.next;
                right = right.next;
            }
        }
        if (left != null) {
            now.next = left;
        }else {
            now.next = right;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution solution = new Solution();
        ListNode sort = solution.sortList(n1);
        System.out.println(sort);
    }
}

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
