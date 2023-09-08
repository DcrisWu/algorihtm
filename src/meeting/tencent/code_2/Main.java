package meeting.tencent.code_2;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }


    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Main main = new Main();
        ListNode[] listNodes = main.quickSort(n1, null);
        ListNode head = listNodes[0];
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    // [头,尾]
    public ListNode[] quickSort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            return new ListNode[]{head, head};
        }
        ListNode lt = new ListNode();
        ListNode ltNode = lt;
        ListNode gt = new ListNode();
        ListNode gtNode = gt;
        ListNode now = head.next;
        // 不包括tail
        while (now != tail) {
            if (now.val <= head.val) {
                ltNode.next = now;
                ltNode = ltNode.next;
            } else {
                gtNode.next = now;
                gtNode = gtNode.next;
            }
            now = now.next;
        }
        ListNode[] leArr;
        ListNode[] gtArr;
        if (lt.next != null && gt.next != null){
            leArr = quickSort(lt.next, ltNode.next);
            gtArr = quickSort(gt.next, gtNode.next);
            leArr[1].next = head;
            head.next = gtArr[0];
            gtArr[1].next = null;
            return new ListNode[]{leArr[0], gtArr[1]};
        }else if (lt.next != null){
            leArr = quickSort(lt.next, ltNode.next);
            leArr[1].next = head;
            head.next = null;
            return new ListNode[]{leArr[0],head};
        }else {
            gtArr = quickSort(gt.next, gtNode.next);
            head.next = gtArr[0];
            gtArr[1].next = null;
            return new ListNode[]{head,gtArr[1]};
        }
    }

}
