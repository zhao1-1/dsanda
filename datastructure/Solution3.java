package datastructure;
import datastructure.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 03-链表
 */
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

    /**
     *【3-1】移除链表元素
     * {力扣-203}
     * 解法1：虚拟头节点
     */
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

    /**
     *【3-1】移除链表元素
     * {力扣-203}
     * 解法2：【穿针法】（土办法，需要考虑特殊情况）
     */
    public ListNode removeElements_2(ListNode head, int val) {
        //（1）考虑：空节点
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        //（2）考虑：头节点
        if (val == head.val) head = head.next;
        this.printList(head);
        return head;
    }

    /**
     *【3-1】移除链表元素
     * {力扣-203}
     * 解法3：【辅助链表】（空间复杂度并没有提高，因为并没有新创建空间）
     *
     * == 改变链表的万能写法 ==
     */
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

    /**
     *【3-1】移除链表元素
     * {力扣-203}
     * 解法3.2：【辅助链表升级（推荐）】，无需临时结点！
     */
    public ListNode removeElements_3_2(ListNode head, int val) {
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
        // 亮点在这里，结束处理的时候，一定要把尾节点的next置为null！
        newTail.next = null;
        this.printList(newHead.next);
        return newHead.next;
    }



    /**
     *【3-2】删除排序链表中的重复元素
     * {力扣-83}
     * 解法1：【穿针法】
     * （p.next = p.next.next） ---- 自己想的，像缝针一样
     */
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

    /**
     *【3-2】删除排序链表中的重复元素
     * {力扣-87}
     * 解法2：【辅助链表（万能推荐）】
     */
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


    /**
     *【3-3】合并两个排序的链表
     * {剑指Offer-25}
     * 解法1：创建结果链表法即辅助链表法（自己的思路，难得的一把梭）
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //（1）创建虚拟头节点 + tail指针
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        //（2）确定初始条件、循环结束控制、核心逻辑
        ListNode p1 = l1;
        ListNode p2 = l2;
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

        //（3）这俩特殊边界条件的处理
        if (p1 == null) tail.next = p2;
        if (p2 == null) tail.next = p1;

        this.printList(newHead.next);
        return newHead.next;
    }



    /**
     *【3-4】两数相加/大数加法*
     * {力扣-2} {Tencent}
     * 解法1：直接按位相加
     */
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


    /**
     *【3-4】两数相加/大数加法*
     * {力扣-2} {Tencent}
     // 不能用这个思路，会出现溢出
        注意：不能考虑用int、long接收，因为会越界！！
     */
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


    /**
     *【3-5】链表的中间节点
     * {力扣-876}
     * 解法1：【快慢指针】
     */
    /*
    注意：
    这种解法和解法2，实际上执行的语句条数是一样的，并非解法1比解法2快一倍！！！
    并且即使是数组，也并非快两倍！！也就是说根本不存在性能优化！！
    */
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


    /**
     *【3-5】链表的中间节点
     * {力扣-876}
     * 解法2：先遍历找到中间的计数，再输出。（思路简单，实现复杂）
     */
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


    /**
     *【3-6】链表中倒数第k个节点
     * {剑指Offer-22} {Baidu}
     * 解法1-1：【前后指针法（former先走k个）】
     */
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


    /**
     *【3-6】链表中倒数第k个节点
     * {剑指Offer-22} {Baidu}
     * 解法1-2：【前后指针法（）】
     */

    /**
     *【3-6】链表中倒数第k个节点
     * {剑指Offer-22} {Baidu}
     * 解法2：【两次遍历】 ------ 时间复杂度一样的！
     * "两个指针走一遍和一个指针走两遍，实际上消耗的时间是一样的！"
     */


    /**
     *【3-7】删除链表倒数第N个结点
     * {力扣-19}
     * 解法1：【前后双指针 + 特殊情况特殊处理】  --- 自己想出来的
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这个地方不能返回head，而是需要返回null，因为有一个元素，且k最小是1，所以只有一个元素必被删！
        if (head == null || head.next == null) return null;

        ListNode former = head;
        ListNode latter = head;
        int i = 0;
        while (i < n && latter != null) {
            latter = latter.next;
            i++;
        }

        // 这一部分的考虑很牛逼，否则12345，删除倒数第五个，很容易仍输出12345
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


    /**
     *【3-7】删除链表倒数第N个结点
     * {力扣-19}
     * 解法2：【前后双指针 + prev前驱标记节点】
     */



    /**
     *【3-8】反转链表
     * {力扣-206} {Alibaba}
     * 解法1：【辅助三指针法】（原地反转）---自己想出来的，但是不通用，而且说不定下次再做就想不出来了。
     */
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


    /**
     *【3-8】反转链表
     * {力扣-206} {Alibaba}
     * 解法2：【头插法】（原地反转）--- 自己实现，不咋完美，很啰嗦，很容易出bug
     */
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

    /**
     *【3-8】反转链表
     * {力扣-206} {Alibaba}
     * 解法3：【头插法】（原地反转）---标准答案
     */
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


    /**
     *【3-9】回文链表*
     * {力扣-234} {蚂蚁金服}
     * 解法1：辅助数组
     * 空间复杂度：o(n)
     * 优点：就是思路清晰
     */
    /*
    （a）把链表转换成数组；
    （b）利用判断回文数组的算法。
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        // (a) 统计链表个数，创造数组，以免浪费，当然也可以动态扩容
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        int[] listNode = new int[n];

        // (b) 把链表的节点值复制给数组
        curr = head;
        int k = 0;
        while (curr != null && k < n) {
            listNode[k] = curr.val;
            curr = curr.next;
            k++;
        }

        // (c) 判断回文数组的方法
        int i = 0;
        int j = listNode.length - 1;
        while (i < j) {
            if (listNode[i] != listNode[j]) return false;
            i++;
            j--;
        }
        return true;
    }



    /**
     *【3-9】回文链表*
     * {力扣-234} {蚂蚁金服}
     * 解法2：利用反转链表
     * 空间复杂度：o(n)
     */
    /*
    （a）先复制原始链表；
    （b）反转原始链表；
    （c）遍历两个链表，比较值是否全部相同；
    */



    /**
     *【3-9】回文链表*
     * {力扣-234} {蚂蚁金服}
     * 解法3：反转中间往后的链表
     * 空间复杂度：o(1)（原地判断）
     */
    /*
    （a）利用快慢针找到中间节点；
    （b）反转中间节点往后的链表；
    （c）比对前后两部分的值是否全部相同；
    */
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

    /**
     *【3-9】回文链表*
     * {力扣-234} {蚂蚁金服}
     * 解法3-2：反转中间往前的链表
     * "反转前半部分链表 然后从中间向两边扩散遍历对比"
     */


    /**
     *【3-9】回文链表*
     * {力扣-234} {蚂蚁金服}
     * 解法4：利用回文数的判定方法
     */
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


    /**
     *【3-10】奇偶链表*
     * {力扣-328} {Tencent}
     // 第一次想出来的方法各种p1，2，3的很容易p懵逼
     */
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


    /**
     *【3-10】奇偶链表*
     * {力扣-328} {Tencent}
     * 解法2：【穿针法】---自己第二次想出来的
     */
    public ListNode oddEvenList_2(ListNode head) {
        // 只需考虑head==null这一种特殊情况即可，head为一个或者两个结点的情况，下面的逻辑都能覆盖。
        if (head == null) return head;

        ListNode oddHead = head;
        ListNode oddTail = oddHead;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;
        // 必须得用临时结点！！
        ListNode temp;

        // 边界条件不好找啊！
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


    /**
     *【3-10】奇偶链表*
     * {力扣-328} {Tencent}
     * 解法3:【两个辅助链表尾插法】
     * 时间、空间复杂度也没比原地的差，而且思路简单，实现逻辑清晰！
     * 非常推荐！！
     */
    /*
    这种思路相似的题：
    + 删除重复元素
    + 合并两个有序链表
    + 两数相加
    + 反转链表
    */
    public ListNode oddEvenList_3(ListNode head) {
        // 无需考虑特殊情况！
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


    /**
     *【3-12】环形链表
     * {力扣-141}
     // 解法1：【快慢针扣圈法】，不是环乌龟永远在兔子后面，是环的话，俩兽早晚相遇（扣圈）。
     * 空间复杂度：o(1)
     */
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


    /**
     *【3-12】环形链表
     * {力扣-141}
     * 解法1-2：【快慢针扣圈法】（仅仅是写法高级一点，本质一样）
     */
//    public boolean hasCycle_1_2(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != slow) {
//
//        }
//        return false;
//    }


    /**
     *【3-12】环形链表
     * {力扣-141}
     // 解法2：【哈希表记录】
     * 空间复杂度：o(n)
     */
    public boolean hasCycle_2(ListNode head) {
        Set<ListNode> nodePools = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!nodePools.add(curr)) return true;
            curr = curr.next;
        }
        return false;
    }




    /**
     *【3-13】相交链表
     * {力扣-160}
     // 解法1：【双指针循环遍历】（官方）
     // 解析过程见Leecode官方图解！
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    /**
     *【3-13】相交链表
     * {力扣-160}
     // 解法2：【哈希表记录】
     */
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


    /**
     *【3-13】相交链表
     * {力扣-160}
     // 解法3：【循环计数】
     * 时间复杂度同官方解法1，都是两个链表需要循环两遍
     */
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


    /**
     *【3-12.2】环形链表的生成
     */
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
