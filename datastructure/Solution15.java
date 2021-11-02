package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/1 13:00
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
     */

    /**
     *【15-1-1】翻转字符串
     * 『力扣 - 344』
     */
    // 见【1-4】


    /**
     *【15-1-2】数对和
     *『面试题 16.24.』
     * 解法一：暴力穷举
     * 时间复杂度：o(n^2)
     */

    // 能否用回溯？因为也数据组合的问题

    /**
     *【15-1-2】数对和
     *『面试题 16.24.』
     * 解法二：双指针
     * 时间复杂度：复杂度在排序上o(n log n) + 后面求解实际上相当于循环一遍o(n)
     */
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
     */
    // 见【1-3】

    /**
     *【15-1-3】两数之和
     *『力扣-1』
     * 解法三：双指针
     */
//    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < j) {
//            if (nums[i] + nums[j] == target) {
//                return new int[]{i, j};
//            } else if (nums[i] + nums[j] > target) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//        return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
//    }


    /**
     *【15-1-4】三数之和
     *『力扣-15』
     * 解法一：hash
     */
    // 见【8-2】

    /**
     *【15-1-4】三数之和
     *『力扣-15』
     * 解法二：双指针
     */


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
     * 解法一：辅助数组
     */
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


    /**
     *【15-1-7】移动零（已排序、未排序指针）
     *『力扣-283』
     * 解法二：双指针（模仿快排思想）
     */
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
     * 解法一：暴力枚举
     */
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


    /**
     *【15-1-8】最小差（类似合并两个有序数组）
     *『面试题 16.06』
     * 解法二：双指针
     */
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
     * 解法一：暴力枚举
       无法通过AC，时间复杂度太高了o(n^2)，超时！
     */
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

    /**
     *【15-1-9】单词距离（类似合并两个有序数组）
     *『面试题 17.11』
     * 解法二：双指针（快慢针）
     */
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


    /**
     *【15-2-2】最长不含重复字符的子字符串
     *『剑指Offer 48.』
     */


    /**
     *【15-2-3】找到字符串中所有字母的异位次
     *『力扣-438』
     */


    /**
     *【15-2-4】最小覆盖子串
     *『力扣-76』
     */



    /*
    【15-3】前后缀统计
     */


    /**
     *【15-3-1】最大子序和
     *『力扣-53』
     */


    /**
     *【15-3-2】买卖股票的最佳时期
     *『力扣-121』
     */


    /**
     *【15-3-3】除自身以外数组的乘积
     *『力扣-238』
     */


    /**
     *【15-3-4】翻转数位
     *『面试题 05.03.』
     */


    /**
     *【15-3-5】接雨水
     *『力扣-42』
     */



    /*
    【15-4】位运算
     */

    /**
     *【15-4-1】位1的个数
     *『力扣-191』
     */


    /**
     *【15-4-2】汉明距离
     *『力扣-461』
     */


    /**
     *【15-4-3】整数转换
     *『面试题 05.06』
     */


    /**
     *【15-4-4】配对交换
     *『面试题 05.07』
     */


    /**
     *【15-4-5】插入
     *『面试题 05.01.』
     */


    /**
     *【15-4-6】消失的数字
     *『面试题 17.14.』
     */


    /**
     *【15-4-7】数组中数字出现的次数
     *『剑指Offer 56-I』
     */


    /**
     *【15-4-8】数组中数字出现的次数II
     *『剑指Offer 56-II』
     */


    /**
     *【15-4-9】交换数字
     *『面试题 16.01.』
     */


    /**
     *【15-4-10】2的幂
     *『力扣-231』
     */


}
