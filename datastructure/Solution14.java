package datastructure;

import datastructure.tree.BNode;

import java.util.Arrays;
import java.util.List;


/*

DP解题步骤：

（1）是否可用「回溯」解决：需要穷举搜索才能得到结果的问题（最值、可行、计数等）
     * 能用dp解决的都可以用回溯解决

（2）构建「多阶段决策模型」：看是否能将问题求解多过程分为多个阶段；

（3）查看用回溯解决时是否存在「重复子问题」：是否有多个路径到达同一个状态；
    * 如果不存在，那么只能用回溯了，dp解决不了。

（4）定义状态（找到合理的状态是解题的关键）：也就是如何记录每一阶段多不重复状态；

（5）定义状态转移方程：找到如何通过上一阶段的状态推导下一个阶段的状态；

（6）画状态转移表：辅助理解，验证正确性，确定状态转移的初始值；

（7）编写动态规划代码。

 */




// 经典模型分类：
/*

1. 背包模型：

    1.1.【0-1背包问题（每个物品只有一个）】「每个物品只有0，1两种状态」
    （a）背包可装物品总重量的最大值是多少？（最值）
        「dp[i][j] = dp[i-1][j] || dp[i-1][j-weight[i]];」
    （b）是否能装满整个背包？（可行）
    （c）正好装满背包最少需要多少物品？（最值）
        「dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-weight[i]]+1);」
    （d）装满背包有多少种装法？（计数）
        「dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]];」


    1.2.【完全背包问题（每个物品无限多个）】「每个物品有0，1，2...k种状态」「k = j / weight[i];」
    （a）背包可装物品总重量的最大值是多少？（最值）
    （b）是否能装满整个背包？（可行）
    （c）正好装满背包最少需要多少物品？（最值）
        「dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1*weight[i]]+1, dp[i-1][j-2*weight[i]]+2,...,dp[i-1][j-k*weight[i]+k);」
    （d）装满背包有多少种装法？（计数）
        「for (int c = 0; c <= k; c++) { dp[i][j] += dp[i-1][j-c*coins[i]]; }」


    1.3.【多重背包问题（每个物品有有限多个）】「k = Math.min(j/weight[i], count[i]);」
    （a）
    （b）
    （c）
    （d）


    1.4.【二维费用】


2. 路径模型：
（a）总共有多少种走法？（计数）
（b）最长/最短路径为多少？（最值）


3. 打家劫舍&股票买卖
    3.1 树形DP
    + 基于树的数据结构进行推导，一般都是自下向上推，子节点状态推导父节点状态；
    + 都是基于「后序遍历」来实现；

4. 爬楼梯模型
每一步可以走x、y或z个台阶，走完n个台阶，
（a）有多少种走法？「计数」
    状态定义：int dp[n+1]    dp[i]表示走完i个台阶有多少种走法
    转移方程：dp[i] = dp[i-x] + dp[i-y] + dp[i-z];
（b）最少需要多少步？「最值」
    状态定义：int dp[n+1]    dp[i]表示走完i个台阶最少需要多少步
    转移方程：dp[i] = Math.min(dp[i-x],dp[i-y],dp[i-z]) + 1;
（c）能否正好走完台阶？「可行」
    状态定义：boolean dp[n+1]    dp[i]表示是否正好走完i个台阶;
    转移方程：dp[i] = dp[i-x] || dp[i-y] || dp[i-z]


5. 匹配问题（LCS、编辑距离）


6. 其他（LIS）

 */


/**
 * DP动态规划（Dynamic Planning）
 */
public class Solution14 {

    /*
    === 模型一：背包模型
     */

    /**
     *【例A】背包模型 - 0-1背包问题（a）
     * 解法一：回溯
     */
    private int maxW;
    private int[] items;
    private int target;
    /*
    items  -> 选择列表（选/不选）
    k      -> 阶段
    cw     -> 路径，记录已经选的物品的总重量
    target -> 剪枝的条件（背包容量）
     */
    private void backTrack1(int k, int cw) {
        if (cw == this.target || k == this.items.length) {
            if (cw > maxW) maxW = cw;
            return;
        }

        // 选择一：不装
        backTrack1(k+1, cw);

        // 选择二：装
        if (cw + items[k] <= this.target)
            backTrack1(k+1, cw+items[k]);
        // 都是局部遍历，自动撤销选择
    }
    public int knapsackA4bt(int[] weight, int w) {
        this.items = weight;
        this.target = w;
        this.maxW = Integer.MIN_VALUE;
        backTrack1(0, 0);
        return maxW;
    }


    /**
     *【例A】背包模型 - 0-1背包问题（a）
     * 解法二：回溯升级（使用备忘录解决重复子问题）,降低回溯的时间复杂度
     */
    private boolean[][] cache1; // 默认值false
    private void backTrack1_2(int k, int cw) {
        if (cw == this.target || k == items.length) {
            if (cw > maxW) maxW = cw;
            return;
        }
        // 重复状态，cache里有记录
        if (this.cache1[k][cw]) return;

        this.cache1[k][cw] = true;

        // 不选择
        backTrack1_2(k + 1, cw);

        // 选择
        if (cw + items[k] <= target)
            backTrack1_2(k + 1, cw + items[k]);
    }
    public int knapsackA4bt2(int[] weight, int w) {
        this.items = weight;
        this.target = w;
        this.maxW = Integer.MIN_VALUE;
        this.cache1 = new boolean[this.items.length][this.target + 1];
        backTrack1_2(0, 0);
        return maxW;
    }


    /**
     *【例A】背包模型 - 0-1背包问题（a）
     * 有n个物品，选择其中一些物品装入背包，在不超过背包最大重量限制的前提下，
       背包中可装物品总重量的最大值是多少？
     * 解法三：动态规划
     */
    public int knapsackA4dp(int[] weight, int target) {

        /*
        weight = [2, 2, 4, 6, 3]
        target = 9

                      |  0  1  2  3  4  5  6  7  8  9  ->  target
                      |-------------------------------
        weight[0] = 2 |  T  x  T  x  x  x  x  x  x  x
        weight[1] = 2 |  T  x  T  x  T  x  x  x  x  x
        weight[2] = 4 |  T  x  T  x  T  x  T  x  T  x
        weight[3] = 6 |  T  x  T  x  T  x  T  x  T  x
        weight[4] = 3 |  T  x  T  T  T  T  T  T  T  T

         */

        // 1. 定义DP动态规划表（二维数组）
        int optionCount = weight.length;
        int targetCount = target + 1;
        boolean[][] dp = new boolean[optionCount][targetCount];

        // 2. 构建DP动态规划表

        // 2.1 初始状态
        dp[0][0] = true;                                // (a) 第0个物品 不装进背包
        if (weight[0] < target)
            dp[0][weight[0]] = true;                    // (b) 第0个物品 装进背包

        // 2.2 状态转移
        for (int i = 1; i < optionCount; i++) {
            for (int j = 0; j < targetCount; j++) {
                // 当第i-1个物品的第j个状态可达时 ->
                if (dp[i-1][j]) {
                    dp[i][j] = true;                    // (a) 第i个物品 不装进背包
                    if (weight[i] + j <= target)
                        dp[i][weight[i] + j] = true;    // (b) 第i个物品 装进背包
                }
            }
        }

        // 3. 选取最后一段，从后向前依次找
        for (int j = targetCount - 1; j >= 0; j--) {
            if (dp[optionCount-1][j]) return j;
        }

        return -1;
    }


    /**
     *【例B】背包模型 - 0-1背包问题（b）
     * 有n个物品，选择其中一些物品装入背包，能不能正好装满背包？
     */
    public boolean knapsackB(int[] weight, int target) {
        int optionN = weight.length;
        int resultN = target + 1;
        boolean[][] dp = new boolean[optionN][resultN];

        dp[0][0] = true;
        if (weight[0] <= target)
            dp[0][weight[0]] = true;

        for (int i = 1; i < optionN; i++) {
            for (int j = 0; j < resultN; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                    if (j + weight[i] <= target)
                        dp[i][j + weight[i]] = true;
                }
            }
        }

        return dp[optionN-1][resultN-1];
    }


    /**
     *【例C】背包模型 - 0-1背包问题（c）
     * 有n个物品，选择其中一些物品装入背包，
       正好装满背包所需物品最少个数（如果装不满返回-1）？
     */
    public int knapsackC(int[] weight, int target) {

        /*
        weight = [2, 2, 4, 6, 3] 【KG】
        target = 9               【KG】

                      |  0   1   2   3   4   5   6   7   8   9  ->  target
                      |----------------------------------------
        weight[x] = 2 |  0   x   1   x   x   x   x   x   x   x
        weight[1] = 2 |  0   x   1   x   2   x   x   x   x   x
        weight[2] = 4 |  0   x   1   x   1   x   2   x   3   x
        weight[3] = 6 |  0   x   1   x   1   x   1   x   2   x
        weight[4] = 3 |  0   x   1   1   1   2   1   2   2   2
         */

        int optionN = weight.length;
        int resultN = target + 1;
        int[][] dp = new int[optionN][resultN];
        for (int i = 0; i < optionN; i++) {
            for (int j = 0; j < resultN; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        dp[0][0] = 0;
        if (weight[0] <= target)
            dp[0][weight[0]] = 1;

        for (int i = 1; i < optionN; i++) {
            for (int j = 0; j < resultN; j++) {
                if (j - weight[i] < 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-weight[i]] + 1);
            }
        }

        for (int i = 0; i < optionN; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return (dp[optionN-1][resultN-1] != Integer.MAX_VALUE) && (dp[optionN-1][resultN-1] != Integer.MAX_VALUE - 1) ? dp[optionN-1][resultN-1] : -1;
    }


    /**
     *【例D】背包模型 - 0-1背包问题（d）
     * 有n个物品，选择其中一些物品装入背包，装满背包有多少种不同的装法？
     */
    public int knapsackD(int[] weight, int target) {
        int optionN = weight.length;
        int resultN = target + 1;
        int[][] dp = new int[optionN][resultN];

        dp[0][0] = 1;
        if (weight[0] <= target)
            dp[0][weight[0]] = 1;

        for (int i = 1; i < optionN; i++) {
            for (int j = 0; j < resultN; j++) {
                if (j - weight[i] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[optionN-1][resultN-1];
    }


    /**
     *【例E】背包模型 - 二维费用问题
     * 解法一：DP
       最好用DP，回溯无法用备忘录解决重复子问题
     */
    public int maxValueKnapsack(int[] weight, int[] value, int target) {

        /*
        weight = [2, 2, 4, 6, 3] 【KG】
        value  = [3, 4, 8, 9, 6] 【Yuan】
        target = 9               【KG】

                      |  0   1   2   3   4   5   6   7   8   9  ->  target
                      |----------------------------------------
        weight[x] = 2 |  0   x   3   x   x   x   x   x   x   x
        weight[1] = 2 |  0   x   4   x   7   x   x   x   x   x
        weight[2] = 4 |  0   x   4   x   8   x  12   x  15   x
        weight[3] = 6 |  0   x   4   x   8   x  12   x  15   x
        weight[4] = 3 |  0   x   4   6   8  10  12  14  15  18

         */

        int optionCount = weight.length;
        int targetCount = target + 1;
        int[][] dpValue = new int[optionCount][targetCount];
        for (int i = 0; i < optionCount; i++) {
            for (int j = 0; j < targetCount; j++) {
                dpValue[i][j] = -1;
            }
        }

        dpValue[0][0] = 0;
        if (weight[0] <= target)
            dpValue[0][weight[0]] = value[0];

        for (int i = 1; i < optionCount; i++) {
            for (int j = 0; j < targetCount; j++) {
                if (dpValue[i-1][j] >= 0) {
                    dpValue[i][j] = Math.max(dpValue[i][j], dpValue[i-1][j]);
                    if (j + weight[i] <= target)
                        dpValue[i-1][j + weight[i]] = Math.max(dpValue[i][j+weight[i]], dpValue[i-1][j] + value[i]);
                }
            }
        }

        Arrays.sort(dpValue[optionCount-1]);
        return dpValue[optionCount-1][targetCount-1];
    }


    /**
     *【例E】背包模型 - 二维费用问题
     * 解法二：回溯
       缺点 -> 无法用备忘录缓存，导致时间复杂度为指数级
     */
    private int maxValue;
    private int[] valueItems;
    public int maxValueKnapsack2(int[] weight, int[] value, int target) {
        this.items = weight;
        this.valueItems = value;
        this.target = target;
        this.maxValue = Integer.MIN_VALUE;
        backTrack2(0, 0, 0);
        return maxValue;
    }
    private void backTrack2(int k, int cw, int cv) {
        if (cw == this.target || k == this.items.length) {
            if (cv > maxValue) maxValue = cv;
            return;
        }

        backTrack2(k + 1, cw, cv);

        if (cw + this.items[k] <= this.target)
            backTrack2(k + 1, cw + this.items[k], cv + this.valueItems[k]);
    }


    /**
     *【14-1-1】分割等和子集
     * 「力扣-416」
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;

        int rows = nums.length;
        int cols = sum + 1;
        boolean[][] dp = new boolean[rows][cols];

        dp[0][0] = true;
        if (nums[0] < sum)
            dp[0][nums[0]] = true;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j - nums[i] >= 0)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[rows-1][cols-1];
    }


    /**
     *【14-1-2】目标和
     * 「力扣-494」
     */
    public int findTargetSumWays(int[] nums, int target) {
        /*
nums = [1,1,1,1,1]
target = 3
[0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0]
[0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 0]
[0, 0, 1, 0, 3, 0, 3, 0, 1, 0, 0]
[0, 1, 0, 4, 0, 6, 0, 4, 0, 1, 0]
[1, 0, 5, 0,10, 0,10, 0, 5, 0, 1]
         */
        // 前期数据处理
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(sum) < Math.abs(target)) return 0;

        int optionN = nums.length;
        int resultN = sum * 2 + 1;      // - 0 +
        int[][] dp = new int[optionN][resultN];

        // 0 这种情况必须考虑，+0，-0，属于两种方式，初始值为2
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < optionN; i++) {
            for (int j = 0; j < resultN; j++) {
                // 力扣定义的状态转移方程
//                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
//                int r = (j + nums[i]) < resultN ? j + nums[i] : 0;
//                dp[i][j] = dp[i-1][l] + dp[i-1][r];
                // 我自己想的状态转移方程
                if (j - nums[i] >= 0)
                    dp[i][j - nums[i]] += dp[i-1][j];
                if (j + nums[i] < resultN)
                    dp[i][j + nums[i]] += dp[i-1][j];
            }
        }

        for (int i = 0; i < optionN; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[optionN-1][sum + target];
    }


    /**
     *【14-1-3】零钱兑换
     * 解法一：【背包模型 - 完全背包问题（c）】
     * 「力扣-322」
     */
    public int coinChange(int[] coins, int amount) {

        /*
            0   1   2   3   4   5   6   7   8   9  10  11
        1   0   1   2   3   4   5   6   7   8   9  10  11
        2   0   1   1   2   2   3   3   4   4   5   5   6
        5   0   1   1   2   2   1   2   2   3   3   2   3
         */

        if (amount == 0) return 0;

        int rows = coins.length;
        int cols = amount + 1;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int c = 0; c <= amount / coins[0]; c++) {
            dp[0][c*coins[0]] = c;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 等价于：dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1*weight[i]]+1, dp[i-1][j-2*weight[i]]+2,...,dp[i-1][j-k*weight[i]+k);
                int k = j / coins[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j-c*coins[i]] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i-1][j-c*coins[i]] + c, dp[i][j]);
                }
            }
        }

//        for (int i = 0; i < rows; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        if (dp[rows-1][cols-1] == Integer.MAX_VALUE) return -1;
        return dp[rows-1][cols-1];
    }


    /**
     *【14-1-4】零钱兑换II
     * 解法一：【背包模型 - 完全背包问题（d）】
       ⚠️，解法二「爬楼梯模型」不可用！
     * 「力扣-518」
     */
    public int change(int amount, int[] coins) {
        int rows = coins.length;
        int cols = amount + 1;
        int dp[][] = new int[rows][cols];

        for (int c = 0; c < amount / coins[0]; c++) {
            dp[0][c*coins[0]] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int k = j / coins[i];
                for (int c = 0; c <= k; c++) {
                    dp[i][j] += dp[i-1][j-c*coins[i]];
                }
            }
        }

        return dp[rows-1][cols-1];
    }



    /*
    === 模型二： 路径模型
     */

    /**
     *【14-2-1】不同路径
     * 「力扣-62」
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }


    /**
     *【14-2-2】不同路径II
     * 「力扣-63」
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i-1][0] == 0)
                dp[i][0] = 0;
            else
                dp[i][0] = 1;
        }
        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 1 || dp[0][j-1] == 0)
                dp[0][j] = 0;
            else
                dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[rows-1][cols-1];
    }

    /**
     *【14-2-3】最小路径和
     * 「力扣-64」
     */
    public int minPathSum(int[][] grid) {
        /*
        grid =
        1   3   1
        1   5   1
        4   2   1

        dp =
        1   4   5
        2   7   6
        6   8   7

        路径：1 -> 3 -> 1 -> 1 -> 1

         */
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        /*
        初始化赋值⚠️：
        第0列的值只能通过上一行的值过来；
        第0行第值只能通过左一行的值过来；
         */
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }


    /**
     *【14-2-4】礼物等最大价值
     * 「剑指Offer 47」
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }


    /**
     *【14-2-5】三角形最小路径和
     * 「力扣-120」
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        triangle =
        2
        3   4
        6   5   7
        4   1   8   3

        初始化：
        2
        5   6
       11      13
       15          16

         */

        int rows = triangle.size();
        int cols = rows;
        int[][] dp = new int[rows][cols];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
        for (int j = 1; j < cols; j++) {
            dp[j][j] = dp[j-1][j-1] + triangle.get(j).get(j);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        Arrays.sort(dp[rows-1]);
        return dp[rows-1][0];
    }




    /*
    === 模型三： 打家劫舍 & 买卖股票
     */

    /**
     *【14-3-1】打家劫舍
     * 解法一：
     * 「力扣-198」
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int optionN = nums.length;
        // 0 -> 不偷
        // 1 -> 偷
        int stateN = 2;
        int[][] dp = new int[optionN][stateN];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < optionN; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[optionN-1][0], dp[optionN-1][1]);
    }


    /**
     *【14-3-1】打家劫舍
     * 解法二：非常规
     * 「力扣-198」
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        if (n == 1) return nums[0];

        // ⚠️ -> 此处dp数组大小不是n+1
        int dp[] = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }

        return dp[n - 1];
    }


    /**
     *【14-3-2】打家劫舍II
     * 「力扣-213」
     */
    public int robII(int[] nums) {
        if (null == nums) return 0;

        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // 第一家不偷的情况：
        int profit0 = robIIdp(nums, 1, n - 1);
        // 第一家偷的情况：
        int profit1 = nums[0] + robIIdp(nums, 2, n - 2);

        return Math.max(profit0, profit1);
    }
    private int robIIdp(int[] nums, int start, int end) {
        int optionN = nums.length;
        // 0 -> 不偷
        // 1 -> 偷
        int stateN = 2;
        int[][] dp = new int[optionN][stateN];

        dp[start][0] = 0;
        dp[start][1] = nums[start];

        for (int i = start + 1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[end][0], dp[end][1]);
    }


    /**
     *【14-3-3】打家劫舍III（树形DP）
     * 「力扣-337」
     */
    public int robIII(BNode root) {
        int[] profit = robIIIPostorder(root);
        return Math.max(profit[0], profit[1]);
    }
    private int[] robIIIPostorder(BNode root) {
        if (root == null) return new int[]{0,0};
        int[] leftProfit = robIIIPostorder(root.left);
        int[] rightProfit = robIIIPostorder(root.right);

        // profit[0] -> 不偷 该节点所产生的最大利润
        // profit[1] -> 偷   该节点所产生的最大利润
        int[] profit = new int[2];
        profit[0] = Math.max(leftProfit[0], leftProfit[1]) + Math.max(rightProfit[0], rightProfit[1]);
        profit[1] = (leftProfit[0] + rightProfit[0]) + root.data;

        return profit;
    }


    /**
     *【14-3-4】买卖股票的最佳时机（含手续费）
     * 「力扣-714」
     */
    public int maxProfit(int[] prices, int fee) {

        /*
        fee = 2
             F    E
        1   -1    0
        3   -1    0
        2   -1    0
        8   -1    5
        4    1    5
        9    1    8
         */

        int optionN = prices.length;
        // 0 -> FULL （持有）
        // 1 -> Empty（不持有）
        int stateN = 2;
        // dpValue -> maxProfit
        int[][] dp = new int[optionN][stateN];

        dp[0][0] = -1 * prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < optionN; i++) {
            dp[i][0] = Math.max(dp[i-1][0], (dp[i-1][1] - prices[i]));
            dp[i][1] = Math.max((dp[i-1][0] + prices[i] - fee), dp[i-1][1]);
        }

//        for (int i = 0; i < optionN; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return Math.max(dp[optionN-1][0], dp[optionN-1][1]);
    }


    /**
     *【14-3-5】买卖股票的最佳时机（含冷冻期）
     * 「力扣-309」
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int optionN = prices.length;
        /*
        最大利润状态：
        「只要在今天想买入的时候判断一下前一天是不是刚卖出，即可」
        dp[i][0] -> 第i天 持有
        dp[i][1] -> 第i天 不持有 且当天刚卖掉（即i-1天持有）
        dp[i][2] -> 第i天 不持有 且当天没卖掉（即i-1天未持有）
         */
        int stateN = 3;
        int[][] dp = new int[optionN][stateN];

        dp[0][0] = -1 * prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < optionN; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }

        return Math.max(Math.max(dp[optionN-1][0], dp[optionN-1][1]), dp[optionN-1][2]);
    }




    /*
    === 模型四： 爬楼梯问题
     */

    /**
     *【14-4-1】爬楼梯
     * 「力扣-70」
     * 解法一：dp爬楼梯模型（a）
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     *【14-4-1】爬楼梯
     * 「力扣-70」
     * 解法二：dp爬楼梯模型（a）
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i - 1 >= 0) dp[i] += dp[i - 1];
            if (i - 2 >= 0) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    /**
     *【14-4-1】爬楼梯
     * 「力扣-70」
     * 解法三：递归
     */
    // 见【5-2】


    /**
     *【14-4-2】零钱兑换
     * 「力扣-322」
     * 解法二：dp爬楼梯模型（b）
     */
//    public int coinChange2(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        for (int i = 4; i < dp.length; i++) {
//            dp[i] = minValueArr(coins, dp, i) + 1;
//        }
//        return dp[amount];
//    }
//    private int minValueArr(int[] x, int[] dp, int index) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < x.length; i++) {
//            int zzz = dp[index - x[i]];
//            min = min <= zzz ? min : zzz;
//        }
//        return min;
//    }
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) { dp[i] = Integer.MAX_VALUE; }

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] + 1 < dp[i])
                    dp[i] = dp[i - coins[j]] + 1;
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }


    /**
     *【14-4-3】零钱兑换II
     * 「力扣-518」
     * ⚠️解法二：dp爬楼梯模型（a）「无效！！！」
     因为：
     爬楼梯 -> 「1 1 2」 / 「1 2 1」   算两种走法
     零钱兑 -> 「1 1 2」 / 「1 2 1」   算一种兑换方法
     */


    /**
     *【14-4-4】剪绳子
     * 「剑指Offer 14-I」
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] < j * dp[i - j])
                    dp[i] = j * dp[i - j];
            }
        }
        return dp[n];
    }


    /**
     *【14-4-5】把数字翻译成字符串
     * 「剑指Offer 46」
     */
//    public int translateNum(int num) {
//
//    }


    /**
     *【14-4-6】单词拆分
     * 「力扣-139」
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//    }




    /*
    === 模型五： 匹配问题
     */

    /**
     *【14-5-1】最长公共子序列
     * 「力扣-1143」
     * 区分：最长公共子串，这个题
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i - 1] == t2[j - 1])
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
                else
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }

        return dp[n][m];
    }


    /**
     *【14-5-2】编辑距离
     * 「力扣-72」
     */




    /*
    === 模型六： 其他
     */

    /**
     *【14-6-1】路径总和III（树形DP）
     * 「力扣-437」
     */


    /**
     *【14-6-2】最长递增子序列
     * 「力扣-300」
     */

}
