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

        this.printList(newHead.next);

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

        this.printList(head);

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

        this.printList(newHead.next);

        return newHead.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        this.printList(slow);

        return slow;
    }


    public ListNode middleNode_2(ListNode head) {
        ListNode p = head;
        int pLoc = 0;
        int middleLoc = 0;
        while (p != null) {
            p = p.next;
            pLoc++;
        }
        int listLength = pLoc;
        middleLoc = listLength / 2;
        p = head;
        pLoc = 0;
        while (p != null && pLoc != middleLoc) {
            p = p.next;
            pLoc++;
        }
        this.printList(p);
        return p;
    }





    // ============= 公共方法 ==================

    public ListNode buildList(int[] inputArray) {
        if (null == inputArray || inputArray.length ==0) return null;
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < inputArray.length; i++) {
            p.val = inputArray[i];
            if (i != inputArray.length - 1) {
                p.next = new ListNode();
                p = p.next;
            }
        }
        p.next = null;
        return head;
    }

    private void printList(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            System.out.print(p.next.val);
            p = p.next;
        }
        System.out.println("");
        System.out.println("------------");
    }

}
