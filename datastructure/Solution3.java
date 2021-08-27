package datastructure;
import datastructure.ListNode;

import java.util.List;

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



    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        this.printList(head);
        return head;
    }




    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 == null) tail.next = p2;
        if (p2 == null) tail.next = p1;
        this.printList(newHead.next);
        return newHead.next;
    }


    // 不能用这个思路，会出现溢出
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode p1 = l1;
//        ListNode p2 = l2;
//        ListNode rHead = new ListNode();
//        ListNode rTail = rHead;
//        long num1 = 0;
//        long num2 = 0;
//        long sum = 0;
//        int i1 = 0;
//        int i2 = 0;
//        while (p1 != null) {
//            num1 += p1.val * Math.pow(10, i1++);
//            p1 = p1.next;
//        }
//        while (p2 != null) {
//            num2 += p2.val * Math.pow(10, i2++);
//            p2 = p2.next;
//        }
//        sum = num1 + num2;
//        if (sum == 0) return new ListNode(0);
//        while (sum > 0) {
//            rTail.next = new ListNode((int) (sum % 10));
//            sum /= 10;
//            rTail = rTail.next;
//        }
//        this.printList(rHead.next);
//        return rHead.next;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int isTen = 0;
        ListNode rHead = new ListNode();
        ListNode rTail = rHead;
        int temp = 0;
        while (p1 != null && p2 != null) {
            temp = p1.val + p2.val + 1 * isTen;
            rTail.next = new ListNode(temp % 10);
            isTen = temp / 10;
            rTail = rTail.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            temp = p1.val + 1 * isTen;
            rTail.next = new ListNode(temp % 10);
            isTen = temp / 10;
            rTail = rTail.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            temp = p2.val + 1 * isTen;
            rTail.next = new ListNode(temp % 10);
            isTen = temp / 10;
            rTail = rTail.next;
            p2 = p2.next;
        }
        if (isTen != 0) rTail.next = new ListNode(1);
        this.printList(rHead.next);
        return rHead.next;
    }



    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;

        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head.next = null;
        this.printList(p2);
        return p2;
    }



    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode();
        ListNode p = head;
        ListNode temp = p.next;
        while (p.next != null) {
            p.next = newHead.next;
            newHead.next = p;
            p = temp;
            temp = temp.next;
        }
        p.next = newHead.next;
        newHead.next = p;
        this.printList(newHead.next);
        return newHead.next;
    }



    public ListNode reverseList_3(ListNode head) {
        ListNode newHead = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = temp;
        }
        this.printList(newHead);
        return newHead;
    }


    public boolean isPalindrome(ListNode head) {

        return true;
    }


    public boolean isPalindrome_3(ListNode head) {
        if (head == null) return false;

        ListNode halfNode = this.middleNode(head);
        ListNode halfReverseNode = this.reverseList(halfNode);
        ListNode firstTail = head;
        ListNode secondTail = halfReverseNode;
        // 注意：此处不能用firstTail来判断，因为first链的尾部没有与second没反转前的链表头部断开！！
        while (secondTail != null) {
            if (firstTail.val != secondTail.val) return false;
            firstTail = firstTail.next;
            secondTail = secondTail.next;
        }
        return true;
    }



    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        while (p3 != null && p3.next != null) {
            p1.next = p3;
            p2.next = p3.next;
            p1 = p3;
            p2 = p3.next;
            p3 = p3.next.next;
        }
        if (p3 == null)
            p1.next = evenNode;
        else
            p1.next = p3;
            p2.next = p3.next;
            p3.next = evenNode;
        this.printList(oddNode);
        return oddNode;
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
            System.out.print(p.next.val + " -> ");
            p = p.next;
        }
        System.out.print("NULL");
        System.out.println("");
        System.out.println("------------");
    }

}
