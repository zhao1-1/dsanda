package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/9 15:51
 */
public class Solution6 {

    /**
     *【6-1】合并排序的数组
     * {面试题 10.01.}
     * 解法一：辅助数组
     */
    public int[] merge(int[] A, int m, int[] B, int n) {
        int result[] = new int[m+n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                result[index] = A[i];
                i++;
            } else {
                result[index] = B[j];
                j++;
            }
            index++;
        }
        while (i < m) {
            result[index++] = A[i++];
        }
        while (j < n) {
            result[index++] = B[j++];
        }

        i = 0;
        for (int k = 0; k < result.length; k++) {
            A[i++] = result[k];
        }
        return A;
    }

    /**
     *【6-1】合并排序的数组
     * {面试题 10.01.}
     * 解法二：原地一把梭哈
     */
    public int[] merge_2(int[] A, int m, int[] B, int n) {

        return A;
    }

    /**
     * 【6-6】调整数组顺序使奇数位于偶数前面
     * 利用排序思想来解决，并非排序题
     * 解法一：利用选择排序思想
     * 非稳定的
     * 时间复杂度o(n^2)
     * 空间复杂度o(1)
     */
    public int[] exchange(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
                if (nums[k] % 2 != 0) {
                    if (k != i) {
                        int temp = nums[k];
                        nums[k] = nums[i];
                        nums[i] = temp;
                    }
                    break;
                }
            }
        }
        return nums;
    }


    /**
     * 解法二：双指针 + 冒泡思想
     * 非稳定的
     * 时间复杂度o(n)
     * 空间复杂度o(1)
     */
    public int[] exchange_2(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && nums[head] % 2 == 1) head++;
            while (head < tail && nums[tail] % 2 == 0) tail--;
            if (head != tail) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                head++;
                tail--;
            }
        }
        return nums;
    }


    /**
     * 解法三：辅助数组 + 双指针
     * 时间复杂度o(n)
     * 空间复杂度o(n)
     */
    public int[] exchange_3(int[] nums) {
        int[] result = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (head > tail) break;    // 可以不加，但是为了保险还是加上
            if (nums[i] % 2 != 0)
                result[head++] = nums[i];
            else
                result[tail--] = nums[i];
        }
        return result;
    }




    /**
     * 【6-10】数组中的第K个最大元素
     * 解法一：先排序，再找K
     * 时间复杂度：o(n^2)，排序算法影响了速度
     * 空间复杂度：o(1)
     */
    public int findKthLargest(int[] nums, int k) {
        // 1. 自定义排序函数
//        nums = SortUtil.insertionSort(nums);

        // 2. Arrays工具类
        Arrays.sort(nums);

        // 3. 转成List形式，用Collections工具类
//        List list = new ArrayList<>()；
//        Collections.addAll(list, nums);
//        Collections.sort(list);

        return nums[nums.length - k];
    }
}
