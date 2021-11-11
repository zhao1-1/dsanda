package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/1 13:00
 */

/**
 * 技巧题
 */
public class Solution15 {

    /*
    【15-1】双指针
        -> 单数组前后指针
        -> 快慢指针
        -> 区间指针
        -> 双数组的两个指针

    题型：
    （a）求数对
    （b）特殊排序
        1. 快速排序：partition()函数
        2. 选择排序：已排序，未排序区间
        3. 插入排序：已排序，未排序区间
    （c）减少时间复杂度：
        通过双指针减少暴力枚举的时间复杂度，往往都需要伴随着“排序”
     */

    /**
     *【15-1-1】翻转字符串
     * 『力扣 - 344』
     */
    // 见【1-4】



    /**
     *【15-1-2】数对和
     *『面试题 16.24.』
     * 时间复杂度：o(n^2)
     */
    // 解法一：暴力穷举

    // 能否用回溯？因为也数据组合的问题

    // 解法二：双指针（时间复杂度：复杂度在排序上o(n log n) + 后面求解实际上相当于循环一遍o(n)）
    public List<List<Integer>> pairSums(int[] nums, int target) {
        // 先排序是关键！
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            if (nums[head] + nums[tail] == target) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(nums[head]);
                subResult.add(nums[tail]);
                result.add(subResult);
                head++;
                tail--;
            } else if (nums[head] + nums[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return result;
    }



    /**
     *【15-1-3】两数之和
     *『力扣-1』
     * 解法一：Hash
     * 解法二：暴力枚举（穷举）
     * 解法三：双指针
     */
    // 见【8-1】



    /**
     *【15-1-4】三数之和
     *『力扣-15』
     * 解法一：hash
     * 解法二：双指针
     */
    // 见【8-2】



    /**
     *【15-1-5】调整数组顺序使奇数位于偶数前面
     *『剑指Offer 21.』
     * 解法一：利用选择排序思想
     * 解法二：双指针 + 冒泡思想
     * 解法三：辅助数组 + 双指针
     */
    // 见【6-6】



    /**
     *【15-1-6】颜色分类
     *『力扣-75』
     * 解法一：直接用排序函数
     * 解法二：借助辅助数组
     * 解法三：双指针
     */
    // 见【6-7】



    /**
     *【15-1-7】移动零（已排序、未排序指针）
     *『力扣-283』
     */
    // 解法一：辅助数组
    public int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int iR = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                result[iR++] = nums[i];
        }
        for (; iR < nums.length; iR++) result[iR] = 0;
        return result;
    }

    // 解法二：双指针（模仿快排思想）
    public void moveZeroes2(int[] nums) {
        /*
        [0,p]       非0
        [p+1, q-1]    0
        [q, n-1]  未处理
         */
        int n = nums.length;
        int p = -1;
        int q = 0;
        while (q < n) {
            if (nums[q] == 0) {
                q++;
                continue;
            }
            if (nums[q] != 0) {
                this.swap(nums, p + 1, q);
                q++;
                p++;
            }
        }
    }
    private void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }



    /**
     *【15-1-8】最小差（类似合并两个有序数组）
     *『面试题 16.06』
     */
    // 解法一：暴力枚举
    public int smallestDifference(int[] a, int[] b) {
        long minD = Long.MAX_VALUE;
        for (int ai = 0; ai < a.length; ai++) {
            for (int bi = 0; bi < b.length; bi++) {
                long diff = Math.abs((long)(a[ai] - b[bi]));
                if (diff < minD) minD = diff;
            }
        }
        return (int)minD;
    }

    // 解法二：排序 + 双指针
    public int smallestDifference2(int[] a, int[] b) {
        /*
        注意：int类型越界
        [-2147483648,1]     [2147483647,0]
        minD = 1
         */
        long minD = Long.MAX_VALUE;
        /*
        1, 2,  3,  11,  15
                   ai
        8, 19, 23, 127, 235
        bi
         */
        // 仍然需要先排序
        Arrays.sort(a);
        Arrays.sort(b);
        int ai = 0;
        int bi = 0;
        while (ai < a.length && bi < b.length) {
            minD = Math.min(minD, Math.abs((long)(a[ai] - b[bi])));
            if (a[ai] < b[bi])
                ai++;
            else
                bi++;
        }
        return (int)minD;
    }



    /**
     *【15-1-9】单词距离（类似合并两个有序数组）
     *『面试题 17.11』
     */
    // 解法一：暴力枚举（无法通过AC，时间复杂度太高了o(n^2)，超时！）
    public int findClosest(String[] words, String word1, String word2) {
        int minIndex = Integer.MAX_VALUE;
        for (int i1 = 0; i1 < words.length; i1++) {
            for (int i2 = 0; i2 < words.length; i2++) {
                if (words[i1].equals(word1) && words[i2].equals(word2))
                    minIndex = Math.min(minIndex, Math.abs(i1 - i2));
            }
        }
        return minIndex;
    }

    // 解法二：双指针（快慢针）
    public int findClosest2(String[] words, String word1, String word2) {
        int minIndex = words.length + 1;
        int slow = 0;
        int fast = 0;
        return minIndex;
    }





    /*
    【15-2】滑动窗口
     */

    /**
     *【15-2-1】和为s的连续正数序列
     *『剑指Offer 57-II』
     */
    // 解法一：完美答案，效率最高（只需要遍历一半），滑动窗口
    public int[][] findContinuousSequence(int target) {

        /*
        sum
            1   2   3   4   5   6   7   8   9
        3   r   l
        6   r   -   l
        10  r   -   -   l
      Y 9       r   -   l
        7           r   l
        12          r   -   l
      Y 9               r   l
        5                   rl  END
         */

        List<int[]> result = new ArrayList<>();

        int r = 1;      // 滑动窗口左边界
        int l = 2;      // 滑动窗口右边界
        int sum = 3;    // 滑动窗口中数字的和

        while (r <= target / 2) {
            if (sum < target) {
                l++;
                sum += l;
            } else if (sum > target) {
                sum -= r;
                r++;
            } else {
                int[] arr = new int[l - r + 1];
                for (int i = r; i <= l; i++) {
                    arr[i - r] = i;
                }
                result.add(arr);
                sum -= r;
                r++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // 解法二：思路清晰，但是需要全部遍历
    public int[][] findContinuousSequence2(int target) {

        List<int[]> result = new ArrayList<>();

        int r = 1;
        int l = 2;
        int sum = 3;

        // 循环结束条件保证不会有一个值的情况，并且也缩短了循环次数
        while (l <= target) {
            if (sum < target) {
                l++;
                sum += l;
            } else if (sum > target) {
                sum -= r;
                r++;
            } else {
                if (r == l) break;      // 防止指针指向target的时候
                int[] arr = new int[l - r + 1];
                for (int i = r; i <= l; i++) {
                    arr[i - r] = i;
                }
                result.add(arr);
                sum -= r;
                r++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // 解法三：暴力枚举
    public int[][] findContinuousSequence3(int target) {
        List<int[]> result = new ArrayList<>();
        int r = 1;
        int l = 2;
        while (r <= target - 1) {
            l = r + 1;
            int sum = r + l;
            while (l <= target) {
                if (sum < target) {
                    l++;
                    sum += l;
                } else if (sum > target) {
                    r++;
                    break;
                } else {
                    int[] subResult = new int[l - r + 1];
                    for (int i = 0; i < subResult.length; i++) {
                        subResult[i] = r + i;
                    }
                    result.add(subResult);
                     r++;
                     break;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }



    /**
     *【15-2-2】最长不含重复字符的子字符串
     *『剑指Offer 48.』
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int head = 0;
        int tail = 0;
        HashSet pools = new HashSet();
        while (tail < s.length()) {
            char x = s.charAt(tail);
            if (!pools.contains(x)) {
                pools.add(x);
                maxLen = Math.max(maxLen, tail - head + 1);
                tail++;
                continue;
            }
            while (pools.contains(x)) {
                pools.remove(s.charAt(head));
                head++;
            }
        }

        return maxLen;
    }



    /**
     *【15-2-3】找到字符串中所有字母的异位词
     *『力扣-438』
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int sn = s.length();
        int pn = p.length();
        if (sn < pn) return result;

        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < pn; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        int r = 0;
        int l = 0;
        while (r < sn) {
            int currR = s.charAt(r) - 'a';
            sCnt[currR]++;
            while (sCnt[currR] > pCnt[currR]) {
                int currL = s.charAt(l) - 'a';
                sCnt[currL]--;
                l++;
            }
            if (r - l + 1 == pn)
                result.add(l);
            r++;
        }

        return result;
    }



    /**
     *【15-2-4】最小覆盖子串
     *『力扣-76』
     */
//    public String minWindow(String s, String t) {
//
//    }





    /*
    【15-3】前后缀统计

    类型：
        + 前缀和、后缀和
        + 前缀积、后缀积
        + 前缀最大、后缀最大

    特点：
        支持频繁 + 快速的区间统计

     */


    /**
     *【15-3-1】最大子序和
     *『力扣-53』
     */
    // 解法一：暴力枚举（时间复杂度o(n^2)，超时）
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // 解法二：贪心 / 滑动窗口
    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            // 开始贪心：如果sum小于0，重新开始找子序串
            if (sum < 0) sum = 0;
        }
        return max;
    }

    // 解法三：前后缀和统计
    public int maxSubArray3(int[] nums) {
       /*
        nums     = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
        leftSum  = {-2, -1, -4, 0, -1, 1, 2, -3, 1}
                            x
        rightMax = {2, 2, 2, 2, 2, 2, 2, 1, 1}
                                x
        */
        if (nums.length == 1) return nums[0];
        int[] sum = new int[nums.length];
        int[] max = new int[nums.length];

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            sum[i] = currSum;
        }

        int currMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            currMax = Math.max(currMax, sum[i]);
            max[i] = currMax;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result = max[0];
            } else {
                result = Math.max(result, (max[i] - max[i - 1]));
            }
        }
        return result;
    }

    // 解法四：dp

    // 解法五：分治

    // 前后缀统计（自己的思路，但是是错误的！）
    public int maxSubArray(int[] nums) {
        /*
        nums   = {-2, 1, -3, 4, -1, 2, 1, -5, 4}

        leftS  = {-2, -1, -4, 0, -1, 1, 2, -3, 1}
                                        x
        rightS = {1 , 3, 2, 5, 1 , 2 , 0, -1, 4}
                            x
        */
        int n = nums.length;

        int leftMaxI = 0;
        int sum = 0;
        int sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum >= sumMax) {
                leftMaxI = i;
                sumMax = sum;
            }
        }

        int rightMaxI = n - 1;
        sum = 0;
        sumMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= sumMax) {
                rightMaxI = i;
                sumMax = sum;
            }
        }

        if (rightMaxI > leftMaxI) return Math.max(nums[rightMaxI], nums[leftMaxI]);

        int result = 0;
        for (int i = rightMaxI; i <= leftMaxI; i++) {
            result += nums[i];
        }
        return result;
    }



    /**
     *【15-3-2】买卖股票的最佳时期
     *『力扣-121』
     // 区分【14-3-4】买卖股票的最佳时机（含手续费）「力扣-714」
     // 区分【14-3-5】买卖股票的最佳时机（含冷冻期）「力扣-309」
     */
    // 解法一：暴力枚举 -> 超时：时间复杂度o(n^2)
    public int maxProfit(int[] prices) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
               maxValue = Math.max(maxValue, prices[j] - prices[i]);
            }
        }
        if (maxValue < 0) maxValue = 0;
        return maxValue;
    }

    // 解法二：后缀最大 -> 时间复杂度o(n)
    public int maxProfit2(int[] prices) {
        /*
        prices  = {7, 1, 5, 3, 6, 4}
                        <-      <-
        maxCurr = {7, 6, 6, 6, 6, 4}
         */
        int n = prices.length;
        int[] maxCurr = new int[n];
        maxCurr[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxCurr[i] = Math.max(prices[i], maxCurr[i + 1]);
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxValue = Math.max(maxValue, maxCurr[i + 1] - prices[i]);
        }
        if (maxValue < 0) maxValue = 0;
        return maxValue;
    }



    /**
     *【15-3-3】除自身以外数组的乘积
     *『力扣-238』
     */
    // 解法一：暴力枚举 -> 时间复杂度o(n^2)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int multi = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                multi *= nums[j];
            }
            result[i] = multi;
        }
        return result;
    }

    // 解法二：前后缀积   -> 时间复杂度o(n)，空间复杂度o(n)
    public int[] productExceptSelf2(int[] nums) {
        /*
        nums   = {1, 2, 3, 4}
        leftM  = {1, 2, 6, 24}
        rightM = {24, 24, 12, 4}
        result = {24, 12, 8, 6}
         */
        int n = nums.length;
        int[] leftM = new int[n];       // 存储前缀积（包含当前值）
        int[] rightM = new int[n];      // 存储后缀积（包含当前值）
        leftM[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftM[i] = leftM[i - 1] * nums[i];
        }
        rightM[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            rightM[i] = rightM[i + 1] * nums[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            if (i > 0) result[i] *= leftM[i - 1];
            if (i < n - 1) result[i] *= rightM[i + 1];
        }
        return result;
    }

    // 解法二+：在解法二的基础上进行的升级
    public int[] productExceptSelf2p(int[] nums) {
        /*
        nums   = {1, 2, 3, 4}
        leftM  = {1, 1, 2, 6}
        rightM = {24, 12, 4, 1}
        result = {24, 12, 8, 6}
         */
        int n = nums.length;
        int[] leftM = new int[n];       // 存储前缀积（不包含当前值）
        int[] rightM = new int[n];      // 存储后缀积（不包含当前值）
        leftM[0] = 1;
        for (int i = 1; i < n; i++) {
            leftM[i] = leftM[i - 1] * nums[i - 1];
        }
        rightM[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightM[i] = rightM[i + 1] * nums[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftM[i] * rightM[i];
        }
        return result;
    }

    // 解法三：前后缀积优化（参照解法二+）  -> 时间复杂度o(n)，空间复杂度o(1)
    public int[] productExceptSelf3(int[] nums) {
        /*
        nums    = {1, 2, 3, 4}
                    ->
        result1 = {1, 1, 2, 6}
                    <-
        result2 = {24, 12, 8 ,6}
         */
        int n = nums.length;
        int[] result = new int[n];      // 结果数组直接叠加前后缀积

        // 叠加前缀积
        int leftM = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftM;
            leftM *= nums[i];
        }

        // 叠加后缀积
        int rightM = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightM;
            rightM *= nums[i];
        }
        return result;
    }



    /**
     *【15-3-4】翻转数位（"0"位前后"1"的最大个数）
     *『面试题 05.03.』
     */
    // 解法一：暴力解法（注意：时间复杂度并不是o(n^2)，而是o(an)！）
    public int reverseBits1(int num) {
        CommonUtils cu = new CommonUtils();
        int[] binary = cu.decimal2binary(num);

        // k -> 第一个"1"出现的位置的前一个（必须把1前面的0带上）
        int k = 0;
        while (k < 32 && binary[k] == 0) {
            k++;
        }
        int n = binary.length;

        // 如果num是负数，k为0，即binary[0] == 1，开头就是"1"，那么无需带前面的"0"了（因为前面没有）
        if (k != 0)
            k -= 1;
        else
            k = 0;

        // 暴力搜寻
        int maxCount = 0;
        for (int i = k; i < n; i++) {
            if (binary[i] == 0) {
                int count = 1;
                int j = i - 1;      // 向"0"前搜"1"
                while (j >= k && binary[j] == 1){
                    count++;
                    j--;
                }

                j = i + 1;          // 向"0"后搜"1"
                while (j < n && binary[j] == 1) {
                    count++;
                    j++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        // 为了考虑-1的那个情况（就是32位都是"1"）
        if (k == 0 && maxCount == 0)
            return 32;
        else
            return maxCount;
    }

    // 解法二：
    public int reverseBits2(int num) {
        // -1的情况必须单独考虑
        if (num == -1) return 32;

        CommonUtils cu = new CommonUtils();
        int[] binary = cu.decimal2binary(num);

        int countTemp = 0;

        // 前缀统计："0"向左的"1"的数量
        int[] leftOneCount = new int[CommonUtils.INT_BITS];
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) countTemp++;
            if (binary[i] == 0) {
                leftOneCount[i] = countTemp;
                countTemp = 0;
            }
        }

        // 后缀统计："0"向右的"1"的数量
        int[] rightOneCount = new int[CommonUtils.INT_BITS];
        countTemp = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 1) countTemp++;
            if (binary[i] == 0) {
                rightOneCount[i] = countTemp;
                countTemp = 0;
            }
        }

        // 统计最大"1"的个数（别忘了中间的"0"自己算一个）
        int maxOneCount = 0;
        for (int i = 0; i < CommonUtils.INT_BITS; i++) {
            maxOneCount = Math.max(maxOneCount, leftOneCount[i] + rightOneCount[i]);
        }
        return maxOneCount + 1;
    }



    /**
     *【15-3-5】接雨水
     *『力扣-42』
     * 解法一：【暴力遍历】找柱状雨量
     * 解法二：【前后缀统计法】，找柱状雨量
     * 解法三：【单调栈】，找出每层的雨量
     */
    // 见【4-12】





    /*
    【15-4】位运算
    题型：
        （1）与【&】：
            + 判断某一位是否为1;
              A & (1 << i) != 0; -> 第i位为1（i范围：0 ~ 31）
              A & (1 << i) == 0; -> 第i位为0
            + 设置某位为0；
            + 判断奇偶（包括负数）；
              A & 1 == 0; -> 偶数
              A & 1 == 1; -> 寄数

        （2）或【｜】：
            + 设置某位为1；
              A |= (1 << i);  ->  将x的第i位设置为1；

        （3）异或【^】：反转位（对应位相同为0，不同为1）
            + 寻找只出现一次的数字；
              x == x ^ A ^ A ^ B ^ B ^ C ^ C......;
            + 无临时变量交换两个数字；
              A ^= B;
              B ^= A;
              A ^= B;

        （4）取反【~】：按位取反；

        （5）左移【<<】：乘以2（x *= 2）；
            + 正数左移，低位补0；
              负数左移，低位补0；
            +  2147483647 << 1 == -2;
              -2147483648 << 1 ==  0;
              -2147483647 << 1 ==  2;

        （6）右移【>>】：除以2（x /= 2）；「二分查找」
            + 算数右移 ">>"
              正数，高位补0；
              负数，高位补1；
            + 逻辑右移 ">>>"（Java语言特性）
              正数，高位补0；
              负数，高位补0；
            + -2147483647 >>  1 == -1073741824;
              -2147483648 >>  1 == -1073741824;
                        1 >>  1 ==  0;
                       -1 >>  1 == -1;
                       -1 >>> 1 ==  2147483647;
              -2147483648 >>> 1 ==  1073741824;
              -2147483647 >>> 1 ==  1073741824;

        （7）二进制 <==> 十进制
            高位 -> 低位
            "10000000000000000000000000000000" <==> -2147483648
            "10000000000000000000000000000001" <==> -2147483647
            "10000000000000000000000000000010" <==> -2147483646
            "11000000000000000000000000000000" <==> -1073741824
            "11111111111111111111111111111110" <==> -2
            "11111111111111111111111111111111" <==> -1

            "00000000000000000000000000000000" <==> 0
            "00000000000000000000000000000001" <==> 1
            "00111111111111111111111111111111" <==> 1073741823
            "01000000000000000000000000000000" <==> 1073741824
            "01111111111111111111111111111111" <==> 2147483647
     */

    /**
     *【15-4-1】汉明重量（位1的个数）
     *『力扣-191』
     */
    // 解法一：n值保持不变
    public int hammingWeight(int n) {
        int countOne = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) countOne++;
            mask <<= 1;
        }
        return countOne;
    }

    // 解法二：n值移位变化，无法处理负数！
    public int hammingWeight2(int n) {
        /*
        11111111111111111111111111111101 为负数
        如果用算数右移（>>），无论怎么右移，高位永远都是1，所以会运行超时；
        如果用逻辑右移（>>>），完美解决负数问题！
         */
        int countOne = 0;
        while (n != 0) {
            if ((n & 1) != 0) countOne++;
            n >>>= 1;
        }
        return countOne;
    }



    /**
     *【15-4-2】汉明距离（两数不相同位的个数）
     *『力扣-461』
     */
    public int hammingDistance(int x, int y) {
        /*
        1 = 0 0 0 1
        4 = 0 1 0 0
      ^     0 1 0 1
         */
        //（a）先异或运算
        int r = x ^ y;

        //（b）转换成"求r的位1的个数"题
        return this.hammingWeight(r);
    }



    /**
     *【15-4-3】整数转换
     *『面试题 05.06』
     */
    // 解法：转换为「汉明距离」问题
    public int convertInteger(int A, int B) {

        //（a）先异或运算
        int r = A ^ B;

        //（b）转换成"求r的位1的个数"题
        return this.hammingWeight(r);
    }



    /**
     *【15-4-4】配对交换
     *『面试题 05.07』
     */
    // 解法一：转换成二进制数组再交换
    public int exchangeBits(int num) {
        int[] binary = new int[CommonUtils.INT_BITS];
        CommonUtils cu = new CommonUtils();
        binary = cu.decimal2binary(num);
        /*
        num 范围 [0, 2^30 - 1]
        最大是：00111111111111111111111111111111
        即，31、32两个位置永远是0
         */
        for (int i = 0; i < 30; i+=2) {
            int temp = binary[i];
            binary[i] = binary[i + 1];
            binary[i + 1] = temp;
        }
        return cu.binary2decimal(binary);
    }

    // 解法二：直接位运算
    public int exchangeBits2(int num) {
        int ret = 0;

        for (int i = 0; i < 30; i+=2) {
            int oddBit = (num & (1 << i));              // 获得奇数位bit值
            int eveBit = (num & (1 << (i + 1)));        // 获得偶数位bit值

            if (oddBit != 0) ret |= (1 << (i + 1));     // 如果奇数位不为0（则为1），将偶数位设置为"1"；
            if (eveBit != 0) ret |= (1 << i);           // 如果偶数位不为0（则为1），将奇数位设置为"1"；
        }
        return ret;
    }



    /**
     *【15-4-5】插入
     *『面试题 05.01.』
     */
    // 解法一：分别转换成二进制位再插入
    public int insertBits(int N, int M, int i, int j) {
        /*
        i = 31;
        j = 11;

        01000100001000111111011000001101 == 1143207437 -> N
        i                   j
        00000000000011111000010011001001 == 1017033    -> M
                    S
        01111100001001100100111000001101 == 2082885133 -> 输出结果
        0M                   N
         */
        CommonUtils cu = new CommonUtils();
        int[] binaryN = cu.decimal2binary(N);
        int[] binaryM = cu.decimal2binary(M);

        int startM = 0;
        while (startM < binaryM.length && binaryM[startM] == 0) {
            startM++;
        }

        int indexM = CommonUtils.INT_BITS - 1;
        int indexN = CommonUtils.INT_BITS - 1 - i;
        while (indexN >= (CommonUtils.INT_BITS - 1 - j)) {
            if (indexM >= startM)
                binaryN[indexN] = binaryM[indexM];
            else
                binaryN[indexN] = 0;
            indexN--;
            indexM--;
        }
        return cu.binary2decimal(binaryN);
    }



    /**
     *【15-4-6】消失的数字（找到一个单身狗）
     *『面试题 17.14.』
     */
    // 解法一：排序（时间复杂度差一些）
    public int missingNumber1(int[] nums) {
        // 排序函数时间复杂度高，o(n log n)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        // nums = {0, 1, 2}，则认为缺失的是"3"。
        return nums.length;
    }

    // 解法二：位图（空间复杂度差一些）
    public int missingNumber2(int[] nums) {
        boolean[] bitmap = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bitmap[nums[i]] = true;
        }
        for (int i = 0; i < bitmap.length; i++) {
            if (!bitmap[i]) return i;
        }
        return nums.length;
    }

    // 解法三：求和找缺
    public int missingNumber3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sumZ = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            sumZ += i;
        }
        return sumZ - sum;
    }

    // 解法四：位运算（找到一个单身狗）
    public int missingNumber4(int[] nums) {
        /*
        原理：
        x == x ^ A ^ A ^ B ^ B ^ C ^ C......
         */
        int ret = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            ret ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }



    /**
     *【15-4-7】数组中数字出现的次数（找到两个单身狗）
     *『剑指Offer 56-I』

     * 时间复杂度要求o(n)
       空间复杂度要求o(1)
     */
    public int[] singleNumbers(int[] nums) {
        //（1）得到两个不单身的异或值（混在一起了）
        int xorResult = 0;
        for (int i = 0; i < nums.length; i++) {
            xorResult ^= nums[i];
        }

        //（2）找到xorResult的第一个不同位（即，值为"1"的位）
        int tag = 1;
        while ((xorResult & tag) == 0) {
            tag <<= 1;
        }

        //（3）将混在一起的单身狗分开
        /*
        将所有的数分成两组，一组是tag所在位同singleA相同的，一组是tag所在位同singleB相同的
         */
        int singleA = 0;
        int singleB = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & tag) == 0) {
                singleA ^= nums[i];
            } else {
                singleB ^= nums[i];
            }
        }
        return new int[]{singleA, singleB};
    }



    /**
     *【15-4-8】数组中数字出现的次数II（找到一个单身狗，其他都是出现三次）
     *『剑指Offer 56-II』
     */
    // 解法一：用公共方法（十进制 <==> 二进制）
    public int singleNumber1(int[] nums) {
        /*
        nums = {31,11,20,11,11,31,10,20,31};
        single = 10;

        Single -> 0 1 0 1 0     == 10

        A1     -> 0 1 0 1 1     == 11
        A2     -> 0 1 0 1 1
        A3     -> 0 1 0 1 1

        B1     -> 1 0 1 0 0     == 20
        B2     -> 1 0 1 0 0
        B3     -> 1 0 1 0 0

        C1     -> 1 1 1 1 1     == 31
        C2     -> 1 1 1 1 1
        C3     -> 1 1 1 1 1

        %3     -> 0 1 0 1 0     (ret)
         */

        //（1）将所有的数都转换成binary数组形式
        CommonUtils cu = new CommonUtils();
        int n = nums.length;
        int[][] numsBinary = new int[n][CommonUtils.INT_BITS];
        for (int i = 0; i < n; i++) {
            numsBinary[i] = cu.decimal2binary(nums[i]);
        }

        //（2）某一位的全部nums相加同3求余数
        final int ThreePlayer = 3;
        int[] singleBinary = new int[CommonUtils.INT_BITS];
        for (int i = 0; i < CommonUtils.INT_BITS; i++) {
            int bitSum = 0;
            for (int j = 0; j < n; j++) {
                bitSum += numsBinary[j][i];
            }
            singleBinary[i] = bitSum % ThreePlayer;
        }

        //（3）将单身狗binary数组转换为decimal输出
        return cu.binary2decimal(singleBinary);
    }

    // 解法二：一把梭哈
    public int singleNumber2(int[] nums) {
        int n = nums.length;
        int[] singleBinary = new int[32];
        int mask = 1;
        for (int i = 31; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if ((nums[j] & mask) != 0)
                    singleBinary[i] = (singleBinary[i] + 1) % 3;
            }
            mask <<= 1;
        }

        int single = 0;
        mask = 1;
        for (int i = 31; i >= 0; i--) {
            if (singleBinary[i] == 1) single += mask;
            mask <<= 1;
        }
        return single;
    }



    /**
     *【15-4-9】交换数字
     *『面试题 16.01.』
     */
    public int[] swapNumbers(int[] numbers) {

        /*
        A  -> 1 0 1 0 1 1 0 0
        B  -> 0 1 0 1 1 1 0 0

        计算：
        (1) xx (A  ^ B ) -> 1 1 1 1 0 0 0 0  -> 标记出哪些位相同"0"，哪些位是不同的"1"，存储到A的位置；

        (2) B' (B  ^ xx) -> 1 0 1 0 1 1 0 0  -> B'就相当于把A原值放到了B的位置；
            A' (xx ^ B') -> 0 1 0 1 1 1 0 0
         */

        if (numbers[0] == numbers[1]) return numbers;
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }



    /**
     *【15-4-10】2的幂
     *『力扣-231』
     // 区分【5-7】
     */
    // 解法一：转换成「汉明重量」问题
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int countOne = this.hammingWeight(n);
        return countOne == 1;
    }

    // 解法二：技巧（只允许出现一个"1"）
    public boolean isPowerOfTwo2(int n) {
        /*
        负值也有效！
        10000000000000000000000000000000 == -2147483648 != 0
        只有一个"1"，所以解法一需要判断非负。
         */
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n >> 1 == 0) return true;
                return false;
            }
            n >>= 1;
        }
        return false;
    }

}
