package datastructure;
import datastructure.ListNode;

public class Solution3 {

//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) return null;
//        ListNode p = head;
//        ListNode q = p.next;
//        if (p.val == val) {
//            p.next = q.next;
//            q = q.next;
//        }
//        while (p != null || q != null) {
//            if (val == q.val) {
//                p.next = q.next;
//                q = q.next;
//            } else {
//                p = q;
//                q = q.next;
//            }
//        }
//        if (val == p.val) return null;
//        return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            if (val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        ListNode ppp = newHead.next;
        while (ppp.next != null) {
            System.out.println(ppp.val);
            ppp = ppp.next;
        }
        System.out.println("===========");

        return newHead.next;
    }

    public ListNode removeElements_2(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        if (val == head.val) head = head.next;

        ListNode ppp = head;
        while (ppp.next != null) {
            System.out.println(ppp.val);
            ppp = ppp.next;
        }
        System.out.println("===========");

        return head;
    }


    public ListNode removeElements_3(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            if (val != p.val) {
                newTail.next = p;
                newTail.next.next = null;
                newTail = p;
            }
            p = temp;
        }

        ListNode ppp = newHead.next;
        while (ppp.next != null) {
            System.out.println(ppp.val);
            ppp = ppp.next;
        }
        System.out.println("===========");

        return newHead.next;
    }

}
