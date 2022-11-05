package TowardsOffer2.day_26_排序.code_078_合并排序链表;

/**
 * completion time = 2022.11.5
 * 归并思路
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        return sort(lists, 0, lists.length - 1);
    }

    ListNode sort(ListNode[] lists, int begin, int end) {
        if (end - begin == 0) {
            return lists[begin];
        }
        if (end - begin == 1) {
            return merge(lists[begin], lists[end]);
        }
        ListNode left = sort(lists, begin, (begin + end) / 2);
        ListNode right = sort(lists, ((begin + end) / 2) + 1, end);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
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
                left = left.next;
            } else {
                now.next = right;
                right = right.next;
            }
            now = now.next;
        }
        if (left != null) {
            now.next = left;
        } else {
            now.next = right;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode[] listNodes = {null, listNode1};
        Solution solution = new Solution();
        System.out.println(solution.mergeKLists(listNodes));
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
