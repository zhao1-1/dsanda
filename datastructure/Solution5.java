package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/6 14:20
 */
public class Solution5 {

    /**
     * 解法一：【直接递归】
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }


    /**
     * 解法二：【缓存备忘录】
     * 用一个壳子函数包裹改造过的递归函数
     */
    private int[] cache;
    public int fib_2(int n) {
        cache = new int[n+1];
        return f(n);
    }
    private int f(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        if (cache[i] != 0) return cache[i];
        return f(i-1) + f(i-2);
    }



    private int[] cache2;
    public int climbStairs(int n) {
        cache2 = new int[n+1];
        return ff(n);
    }
    private int ff(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (cache2[i] != 0) return cache2[i];
        return ff(i-1) + ff(i-2);
    }


    public int callCellDivision(int hours) {
        if (hours == 0) return 1;
        if (hours == 1) return 2;
        if (hours == 2) return 4;
        if (hours == 3) return 7;
        return 2 * callCellDivision(hours - 1) - callCellDivision(hours - 4);
    }



    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        reverseTravel(head, result);
        int[] resultArray = new int[result.size()];
        int i = 0;
        for (Integer ele : result) {
            resultArray[i++] = ele;
        }
        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }
    private void reverseTravel(ListNode head, List<Integer> result) {
        if (head == null) return;
        reverseTravel(head.next, result);
        result.add(head.val);
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
//        if (head == null) return null;
//        if (head.next == null) return head;
        ListNode reverseNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = null;

        if (l1.val <= l2.val) {
            newHead = new ListNode(l1.val);
            newHead.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = new ListNode(l2.val);
            newHead.next = mergeTwoLists(l1, l2.next);
        }

        return newHead;
    }



    public double myPow(double x, int n) {
        if (n > 0)  return x * myPow(x, n-1);
        if (n < 0) return myPow(x, n+1) / x;
        return 1;
    }

    public double myPow_2(double x, int n) {
        return Math.pow(x, n);
    }



    // 用循环
    public int multiply_1(int A, int B) {
        int result = 0;
        if (A >= B) {
            for (int i = 0; i < B; i++) {
                result += A;
            }
        } else {
            for (int i = 0; i < A; i++) {
                result += B;
            }
        }
        return result;
    }

    // 本质就是利用递归实现循环
    public int multiply_2(int A, int B) {
        if (A == 0 || B == 0) return 0;
        return A > B ? A + multiply_2(A, B - 1) : B + multiply_2(B, A - 1);
    }



    // 位运算
//    public int multiply_3(int A, int B) {
//    }

}
