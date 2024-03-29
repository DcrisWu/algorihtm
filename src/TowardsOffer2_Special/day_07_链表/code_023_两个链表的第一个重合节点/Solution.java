package TowardsOffer2_Special.day_07_链表.code_023_两个链表的第一个重合节点;


/**
 * completion time = 2022.10.20
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*Set<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            System.out.println(headA.val);
            System.out.println(headB.val);
            if (set.contains(headA)) {
                return headA;
            } else {
                set.add(headA);
                headA = headA.next;
            }
            if (set.contains(headB)) {
                return headB;
            } else {
                set.add(headB);
                headB = headB.next;
            }
        }
        while (headA != null) {
            System.out.println(headA.val);
            if (set.contains(headA)) {
                return headA;
            } else {
                set.add(headA);
                headA = headA.next;
            }
        }
        while (headB != null) {
            System.out.println(headB.val);
            if (set.contains(headB)) {
                return headB;
            } else {
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;*/

        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        boolean ma = false, mb = false;
        while (pa != pb) {
            if (pa.next == null) {
                //如果已经被改过，说明这时候不会相交
                if (!ma) {
                    pa = headB;
                    ma = true;
                } else {
                    return null;
                }
            } else {
                pa = pa.next;
            }
            if (pb.next == null) {
                if (!mb) {
                    pb = headA;
                    mb = true;
                } else {
                    return null;
                }

            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
