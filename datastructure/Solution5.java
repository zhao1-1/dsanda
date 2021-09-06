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

}
