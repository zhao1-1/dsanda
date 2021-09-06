package datastructure;

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

}
