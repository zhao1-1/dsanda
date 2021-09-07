package datastructure;
import datastructure.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public ListNode removeElements_4(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != val) {
                newTail.next = curr;
                newTail = newTail.next;
            }
            curr = curr.next;
        }
        newTail.next = null;
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

    public ListNode deleteDuplicates_2(ListNode head) {
        // 初始值给-101，因为题中有每个节点的取值范围，如果范围固定的话，那就只能用我的穿针法了，或者不用虚拟头结点。
        ListNode newHead = new ListNode(-101);
        ListNode newTail = newHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != newTail.val) {
                newTail.next = curr;
                newTail = newTail.next;
            }
            curr = curr.next;
        }
        // 这里结束的时候，尾指针的next必须指向null，否则断不开，11233这种情况就打印1233了！
        newTail.next = null;
        this.printList(newHead.next);
        return newHead.next;
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
        if (head == null) return false;

        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        int[] listNode = new int[n];
        curr = head;
        int k = 0;
        while (curr != null && k < n) {
            listNode[k] = curr.val;
            curr = curr.next;
            k++;
        }
        int i = 0;
        int j = listNode.length - 1;
        while (i < j) {
            if (listNode[i] != listNode[j]) return false;
            i++;
            j--;
        }
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


    public boolean isPalindrome_4(ListNode head) {
        if (head == null) return false;

        ListNode curr = head;
        long s1 = 0;
        long s2 = 0;
        long t = 1;
        while (curr != null) {
            s1 = s1 * 10 + curr.val;
            s2 += curr.val * t;
            t *= 10;
            curr = curr.next;
        }
        return s1 == s2;
    }



    // 第一次想出来的方法各种p1，2，3的很容易p懵逼
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


    public ListNode oddEvenList_2(ListNode head) {
        if (head == null) return head;

        ListNode oddHead = head;
        ListNode oddTail = oddHead;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;
        ListNode temp;
        while (evenTail != null && evenTail.next != null) {
            temp = oddTail.next.next;
            oddTail.next = oddTail.next.next;
            oddTail = temp;

            temp = evenTail.next.next;
            evenTail.next = evenTail.next.next;
            evenTail = temp;
        }
        oddTail.next = evenHead;
        this.printList(oddHead);
        return oddHead;
    }



    public ListNode oddEvenList_3(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (count % 2 == 1) {
                oddTail.next = curr;
                curr = curr.next;
                oddTail = oddTail.next;
                oddTail.next = null;
            } else {
                evenTail.next = curr;
                curr = curr.next;
                evenTail = evenTail.next;
                evenTail.next = null;
            }
            count++;
        }
        oddTail.next = evenHead.next;
        this.printList(oddHead.next);
        return oddHead.next;
    }




    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        int i = 0;
        // 考虑fast!=null是为了避免k大于链表长度的问题，当大于长度时，就输出整个链表。
        while (i < k && latter != null) {
            latter = latter.next;
            i++;
        }
        while (latter != null) {
            latter = latter.next;
            former = former.next;
        }
        this.printList(former);
        return former;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode former = head;
        ListNode latter = head;
        int i = 0;
        while (i < n && latter != null) {
            latter = latter.next;
            i++;
        }
        if (latter == null) {
            this.printList(former.next);
            return former.next;
        } else {
            latter = latter.next;
        }
        while (latter != null) {
            former = former.next;
            latter = latter.next;
        }
        former.next = former.next.next;
        this.printList(head);
        return head;
    }


    // 解法1：【快慢针扣圈法】，不是环乌龟永远在兔子后面，是环的话，俩兽早晚相遇（扣圈）。
    public boolean hasCycle_1(ListNode head) {
        // 无需考虑特殊情况
        // if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 注意：这俩必须写在扣圈判断之前，否则起始的时候fast肯定等于slow都等于head！
            slow = slow.next;
            fast = fast.next.next;
            // 相遇了（扣圈了）
            if (slow == fast) return true;
        }
        return false;
    }


    public boolean hasCycle_1_2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != slow) {

        }
        return false;
    }


    // 解法2：【哈希表记录】，o(n)内存
    public boolean hasCycle_2(ListNode head) {
        Set<ListNode> nodePools = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!nodePools.add(curr)) return true;
            curr = curr.next;
        }
        return false;
    }





    // 解法2：【哈希表记录】
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        Set<ListNode> nodePools = new HashSet<>();
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            nodePools.add(currA);
            currA = currA.next;
        }
        while (currB != null) {
            if (!nodePools.add(currB)) return currB;
            currB = currB.next;
        }
        return null;
    }


    // 解法3：【循环计数】
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int nA = 0;
        int nB = 0;
        while (currA != null) {
            nA++;
            currA = currA.next;
        }
        while (currB != null) {
            nB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (nA >= nB) {
            for (int i = 0; i < nA - nB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < nB - nA; i++) {
                currB = currB.next;
            }
        }
        while (currA != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
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

    public void printList(ListNode head) {
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


    public ListNode buildCycleList(int[] inputArray, int pos) {
        if (null == inputArray || inputArray.length == 0) return null;

        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < inputArray.length; i++) {
            tail.next = new ListNode(inputArray[i]);
            tail = tail.next;
        }
        if (pos != -1) {
            ListNode curr = head.next;
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }
            tail.next = curr;
        }
        return head.next;
    }

}
