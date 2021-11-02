package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Test14 {

    public static void main(String[] args) {
        Solution14 sl14 = new Solution14();

        /**
         *【例A】背包问题 - 最值
         */
//        System.out.println(sl14.knapsackA4bt(new int[]{2, 2, 4, 6, 3}, 9));

//        System.out.println(sl14.knapsackA4bt2(new int[] {2, 2, 4, 6, 3}, 9));

//        System.out.println(sl14.knapsackA4dp(new int[]{2, 2, 4, 6, 3}, 9));

        /**
         *【例B】背包问题 - 可行
         */
//        System.out.println(sl14.knapsackB(new int[]{2, 2, 4, 6, 3}, 9));

        /**
         *【例C】背包问题 - 最值
         */
//        System.out.println(sl14.knapsackC(new int[]{2, 2, 4, 6, 3}, 9));

        /**
         *【例D】背包问题 - 计数
         */
//        System.out.println(sl14.knapsackD(new int[]{2, 2, 4, 6, 3}, 9));

        /**
         *【14-1-0-B】二维费用背包问题
         */
//        System.out.println(sl14.maxValueKnapsack(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 9));;

//        System.out.println(sl14.maxValueKnapsack2(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 9));

        /**
         *【14-1-2】目标和
         * 「力扣-494」
         */
//        System.out.println(sl14.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(sl14.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));

        /**
         *【14-1-3】零钱兑换
         * 「力扣-322」
         */
//        System.out.println(sl14.coinChange(new int[]{1,2,5}, 11));

        /**
         *【14-2-1】不同路径
         * 「力扣-62」
         */
//        System.out.println(sl14.uniquePaths(3, 7));
//        System.out.println(sl14.uniquePaths(3, 2));
//        System.out.println(sl14.uniquePaths(3, 3));

        /**
         *【14-2-2】不同路径II
         * 「力扣-63」
         */
//        System.out.println(sl14.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
//        System.out.println(sl14.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
//        System.out.println(sl14.uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));

        /**
         *【14-2-3】最小路径和
         * 「力扣-64」
         */
//        System.out.println(sl14.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
//        System.out.println(sl14.minPathSum(new int[][]{{1,2,3},{4,5,6}}));

        /**
         *【14-2-4】礼物等最大价值
         * 「剑指Offer 47」
         */
//        System.out.println(sl14.maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));

        /**
         *【14-2-5】三角形最小路径和
         * 「力扣-120」
         */
//        List<List<Integer>> arr1 = new ArrayList();
//        arr1.add(new ArrayList<>().add(2));
//        arr1.add(new int[]{3,4});
//        arr1.add(new int[]{6,5,7});
//        arr1.add(new int[]{4,1,8,3});
//        System.out.println(sl14.minimumTotal(arr1));

        /**
         *【14-3-1】打家劫舍
         * 「力扣-198」
         */
//        System.out.println(sl14.rob(new int[]{1,2,3,1}));
//        System.out.println(sl14.rob(new int[]{2,7,9,3,1}));

//        System.out.println(sl14.rob2(new int[]{1,2,3,1}));
//        System.out.println(sl14.rob2(new int[]{2,7,9,3,1}));

        /**
         *【14-3-2】打家劫舍II
         * 「力扣-213」
         */
//        System.out.println(sl14.robII(new int[]{2,3,2}));
//        System.out.println(sl14.robII(new int[]{1,2,3,1}));

        /**
         *【14-3-4】买卖股票的最佳时机（含手续费）
         * 「力扣-714」
         */
//        System.out.println(sl14.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
//        System.out.println(sl14.maxProfit(new int[]{1,3,7,5,10,3}, 3));

        /**
         *【14-3-5】买卖股票的最佳时机（含冷冻期）
         * 「力扣-309」
         */
//        System.out.println(sl14.maxProfitII(new int[]{1,2,3,0,2}));

        /**
         *【14-4-1】爬楼梯
         * 「力扣-70」
         */
//        System.out.println(sl14.climbStairs(2));
//        System.out.println(sl14.climbStairs(3));
//        System.out.println(sl14.climbStairs(44));

        /**
         *【14-4-2】零钱兑换
         * 「力扣-322」
         */
//        System.out.println(sl14.coinChange2(new int[]{1,2,5}, 11));

        /**
         *【14-5-1】最长公共子序列
         * 「力扣-1143」
         */
        System.out.println(sl14.longestCommonSubsequence("abcde", "ace"));
        System.out.println(sl14.longestCommonSubsequence("abc", "abc"));
        System.out.println(sl14.longestCommonSubsequence("abc", "def"));

    }

}
