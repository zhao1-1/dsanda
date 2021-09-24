package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/6 14:20
 * 05-递归和分治
 */
public class Solution5 {

    private int MOD = 1000000007;

    /**
     * 【5-1】斐波那契数列
     * {剑指Offer10-I}
     * 解法一：【直接递归】
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }


    /**
     * 【5-1】斐波那契数列
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


    /**
     * 【5-1】斐波那契数列
     * 解法三：循环
     */
    public int fib_3(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 2; i <= n ;i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }


    /**
     * 【5-2】青蛙跳台阶
     * {剑指Offer10-II} {力扣70}
     */
    private int[] cache2;
    public int climbStairs(int n) {
        cache2 = new int[n+1];
        return ff(n);
    }
    private int ff(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (cache2[i] != 0) return cache2[i];
        return (ff(i-1) + ff(i-2)) % MOD;
    }



    /**
     *【5-3】三步问题
     * {面金08.01}
     * 解法一：直接递归 + 备忘录
     * 时间复杂度：o(n)，如果不用备忘录，那么时间复杂度将是指数级
     * 空间复杂度：o(n)，值就是递归树的最大深度（函数调用栈） + 备忘录空间
     *
     * 因为数据规模 n 达到百万级别，此时虽然备忘录时间复杂度也是o(n)，但是函数调用的开销就会非常大，不得不考虑了，因此可能需要用循环了。
     */
    private int[] cache3;
    public int waysToStep(int n) {
        cache3 = new int[n+1];
        return waysToStepRecursion(n);
    }
    private int waysToStepRecursion(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (cache3[n] != 0) return cache3[n];
        // 不能直接return后面的，因为需要把结果存到缓存数组里！
        // 求模的方式需注意：
        cache3[n] = ((waysToStepRecursion(n-1) + waysToStepRecursion(n-2)) % MOD + waysToStepRecursion(n-3)) % MOD;
        return cache3[n];
    }


    /**
     *【5-3】三步问题
     * {面金08.01}
     * 解法二：非递归，for循环
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)，dp数组的开销
     */
    public int waysToStep_2(int n) {
        // 不能省略，否则会报数组越界，当n < 3，dp[3]数组越界
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % MOD + dp[i-3]) % MOD;
        }
        return dp[n];
    }

    /**
     *【5-3】三步问题
     * {面金08.01}
     * 解法三：for循环优化，去掉dp数组
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public int waysToStep_3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int a = 1;
        int b = 2;
        int c = 3;
        int temp = 6;
        for (int i = 4; i <= n; i++) {
            temp = ((a + b) % MOD + c) % MOD;
            a = b;
            b = c;
            c = temp;
        }
        return temp;
    }



    /**
     * 【5-4】从尾到头打印链表
     * {剑指Offer06}
     * 解法一：遍历链表，直接打印
     * 解法二：递归法
     */
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


    /**
     * 【5-5】反转链表
     * {剑指Offer24}
     * 前三个解法都是非递归，见【3-8】
     * 解法四：递归法
     * 时间复杂度：o(n)，不分叉的一根递归树
     * 空间复杂度：o(n)，注意，并非原地反转哦，虽然没有开辟新空间，但是存在函数栈调用。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
//        if (head == null) return null;
//        if (head.next == null) return head;
        ListNode reverseNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }


    /**
     * 【5-6】合并两个排序的链表*
     * {剑指Offer25} {力扣21}
     * 解法一：见【3-3】
     * 解法二：递归法
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     */
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


    /**
     * 【5-7】数值的整数次方*
       {剑指Offer16}
     * 解法一：循环
     * 注意：数据规模很大时，比如当 n == "2147483647"
       那么虽然空间复杂度是o(n)，但循环20亿次也会超时。
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public double myPow_1(double x, int n) {
        double result = 1;
        int N = Math.abs(n);
        for (int i = 0; i < N; i++) {
            result *= x;
        }
        if (n >= 0)
            return result;
        else
            return 1 / result;
    }

    /**
     * 【5-7】数值的整数次方*
     * 解法二：常规递归
     * 跟解法一思路一致
     */
    public double myPow_2(double x, int n) {
        if (n > 0)  return x * myPow_2(x, n-1);
        if (n < 0) return myPow_2(x, n+1) / x;
        return 1;
    }

    /**
     * 【5-7】数值的整数次方*
     * 解法三：数学分解（二分法） + 递归
       当数据规模很大时，比如2^31次方，将从20亿次运算骤降至31次运算。
       注意：（1）因为这是一个单支的树（千万别以为这个递归是二叉树），所有的子节点个数就是树的最大深度。
            （2）如果递归过程只调用一次递归函数，那都是单支树，调用几次，就是几叉树。
            （3）int类型取值范围：[-2^31, 2^31-1]（32位操作系统中最大的符号型整型常量）
     * 时间复杂度：o(logn)
     * 空间复杂度：o(logn)
     */
    public double myPow_3(double x, int n) {
        if (n >= 0)
            return rMyPow_3(x, n);
        else
            // x = 2.0000 n = -2147483648(-2^31)，{-1 * n == 2 ^ 31}导致int类型越界了！
            // return 1 / rMyPow_3(x, -1 * n);
            return 1 / (rMyPow_3(x, -1 * (n + 1)) * x);
    }
    private double rMyPow_3(double x, int n) {
        if (n == 0) return 1;
        double half = rMyPow_3(x, n/2);
        if (n % 2 == 1)
            return half * half * x;
        else
            return half * half;
    }

    /**
     * 【5-7】数值的整数次方*
     * 解法四（思想同解法三）：数学分解 + 循环
     * 时间复杂度：o(logn)
     * 空间复杂度：o(1)
     */
    public double myPow_4(double x, int n) {
        if (n == 0) return 1;
        long N = n;
        double result= 1.0;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            // 0&0=0; 0&1=0; 1&0=0; 1&1=1
            // 二进制整数奇偶数判断：最低位是1就是奇数,是0就是偶数
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            // 二进制数整数右移一位，N >> 1 == N / 2
            N >>= 1;
        }
        return result;
    }

    /**
     * 【5-7】数值的整数次方*
     * 解法五：直接调用Math函数
     */
    public double myPow_5(double x, int n) {
        return Math.pow(x, n);
    }



    /**
     *【5-8】递归乘法*
     * {面金08.05}
     * 解法一：循环
     * 但是当数据量很大的时候，循环性能不行！
     */
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

    /**
     *【5-8】递归乘法*
     * 解法二：普通递归
     * 时间复杂度：o(n)，性能也不行！
     * 本质就是利用递归实现循环
     */
    public int multiply_2(int A, int B) {
        if (A == 0 || B == 0) return 0;
        return A > B ? A + multiply_2(A, B - 1) : B + multiply_2(B, A - 1);
    }


    /**
     *【5-8】递归乘法*
     * 解法三：数学分解（二分法） + 递归 + 最小递归
     * 时间复杂度：o(logn)
     * 空间复杂度：o(logn)
     */
    public int multiply_3(int A, int B) {
        int a = Math.max(A, B);
        int b = Math.min(A, B);

        if (b == 0) return 0;
        int half =multiply_3(a, b/2);
        if ((b & 1) == 1)
            return (half << 1) + a;
        else
            return half << 1;
    }

    /**
     *【5-8】递归乘法*
     * 解法四：数学分解（二分法） + 循环
     * 时间复杂度：o(logn)
     * 空间复杂度：o(logn)
     */
//    public int multiply_4(int A, int B) {
//        if (A == 0 || B == 0) return 0;
//        int result = 0;
//        int i = 1;
//        while (i < B) {
//            A += A;
//            i *= 2;
//        }
//        if (i != B) result += A;
//        return result;
//    }

    /**
     *【5-8】递归乘法*
     * 解法五：位运算
     */
//    public int multiply_5(int A, int B) {
//    }



    /**
     * 【5-9】细胞分裂
     */
    public int callCellDivision(int hours) {
        if (hours == 0) return 1;
        if (hours == 1) return 2;
        if (hours == 2) return 4;
        if (hours == 3) return 7;
        return 2 * callCellDivision(hours - 1) - callCellDivision(hours - 4);
    }

}
