package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 06-排序
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
     *【6-2】有效的字母异位词
     * {力扣-242}
     * 解法一：排序数组
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) return false;
        }
        return true;
    }

    /**
     *【6-2】有效的字母异位词
     * {力扣-242}
     * 解法二：字符标记数组
     */
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) return false;
        // 26个字母的标记位
        int[] charPools = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charPools[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charPools[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < charPools.length; i++) {
            if (charPools[i] != 0) return false;
        }
        return true;
    }

    /**
     *【6-2】有效的字母异位词
     * {力扣-242}
     * 解法三：哈希表
     */



    /**
     *【6-3】判断能否形成等差数列
     * {力扣1502}
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 2) return false;
        Arrays.sort(arr);
        int n = arr.length;
        int interval = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i-1]) != interval) return false;
        }
        return true;
    }


    /**
     *【6-4】会议室
     * {力扣252}
     */


    /**
     *【6-5】合并区间*
     * {力扣56}
     */
//    public int[][] merge(int[][] intervals) {
//
//    }


    /**
     * 【6-6】调整数组顺序使奇数位于偶数前面
     * {剑指Offer21}
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
     * 【6-6】调整数组顺序使奇数位于偶数前面
     * {剑指Offer21}
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
     * 【6-6】调整数组顺序使奇数位于偶数前面
     * {剑指Offer21}
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
     *【6-7】颜色分类*
     * {力扣75}
     * 解法一：直接用排序函数
     * 时间复杂度：o(nlogn)
     * 空间复杂度：o(1)
     */
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     *【6-7】颜色分类*
     * {力扣75}
     * 解法二：辅助计数数组
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public int[] sortColors_2(int[] nums) {
        int[] flag = new int[3];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 注意：前后都需要判断flag[j] == 0，否则{2,0}这种情况，中间没有1的过不去！
            if (flag[j] == 0) j++;
            if (flag[j] > 0) {
                nums[i] = j;
                flag[j]--;
            }
            if (flag[j] == 0) j++;
        }
        return nums;
    }

    /**
     *【6-7】颜色分类*
     * {力扣75}
     * 解法三：双指针（思路同【6-6】双指针的解法）
     */
    public int[] sortColors_3(int[] nums) {
        int n = nums.length;
        int head1 = 0;
        int tail1 = n - 1;

        // 先把"2"都移动到最后面
        while (head1 < tail1) {
            while (head1 != 2) head1++;
            while (tail1 == 2) tail1--;
            this.swap(nums, head1, tail1);
            head1++;
            tail1--;
        }

        // 再处理"0" "1"的顺序
        int head2 = 0;
        int tail2 = head1;
        if (nums[tail2] == 2) tail2--;
        while (head2 < tail2) {
            while (head2 == 0) head2++;
            while (tail2 == 1) tail2--;
            this.swap(nums, head2, tail2);
            head2++;
            tail2--;
        }

        return nums;
    }


    /**
     *【6-8】对链表进行插入排序*
     * {力扣147}
     */
    // 见SortUtil.insertionSort(ListNode head)


    /**
     *【6-9】链表归并排序*
     * {力扣148}
     */
    // 见SortUtil.mergeSort(ListNode head)


    /**
     * 【6-10】数组中的第K个最大元素
     * {力扣215}
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

    /**
     * 【6-10】数组中的第K个最大元素
     * {力扣215}
     * 解法二：利用“快排思想”
       注意：这个要用快排的逆序排序（从大到小）
     * 时间复杂度：o(n)
     * 空间复杂度：o(logn)
     */
//    public int findKthLargest_2(int[] nums, int k) {
//
//    }
    // 倒叙的partition函数编写
    private int partitionReverse(int[] arr, int l, int r) {
        int i = l;
        int j = r - 1;
        int beacon = arr[r];
        while (i < j) {
            // 这种写法就是由大到小排序，"arr[i] < beacon i++"，这种是由小到大。
            while (i < j && arr[i] > beacon) i++;
            while (i < j && arr[j] < beacon) j--;
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (j >= l && arr[j] < beacon) {
            swap(arr,j,r);
            return j;
        } else {
            swap(arr,j+1,r);
            return j+1;
        }
    }



    /**
     *【6-11】最小K个数*
     * {面试题金典17.14}
     * 解法一：直接用排序函数
     * 时间复杂度：o(nlogn)
     */
    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < k; i++) {
            result[i] = arr[index];
            index++;
        }
        return result;
    }

    /**
     *【6-11】最小K个数*
     * {面试题金典17.14}
     * 解法二：利用"快排"思想（非常不好思考）
     * 时间复杂度：o(n)
     */
    public int[] smallestK_2(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int[] result;
        if (arr.length > k) {
            result = new int[k];
            quickSortRecursionForFindK(arr, 0, arr.length - 1, k);
        } else {
            result = new int[arr.length];
        }
        for (int i = 0; i < result.length; i++) result[i] = arr[i];
        return result;
    }
    private void quickSortRecursionForFindK(int[] arr, int l, int r, int k) {
        if (l >= r) return;

        int m = partition(arr, l, r);
        if (m - l + 1 == k)
            return;
        else if (m - l + 1 > k)
            quickSortRecursionForFindK(arr, l, m - 1, k);
        else
            quickSortRecursionForFindK(arr, m + 1, r , k - (m - l + 1));

    }
    private int partition(int[] arr, int l, int r) {
        int beacon = arr[r];

        int minSign = l - 1;
        int maxSign = l;

        for (; maxSign <= r - 1; maxSign++) {
            if (arr[maxSign] < beacon) {
                swap(arr, minSign + 1, maxSign);
                minSign++;
            }
        }
        swap(arr, minSign + 1, r);

        return minSign + 1;
    }
    private void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    /**
     *【6-11】最小K个数*
     * {面试题金典17.14}
     * 解法三：构建大顶堆
     */
//    public int[] smallestK_3(int[] arr, int k) {
//
//    }



    /**
     *【6-12】数组中的逆序对**
     * {剑指Offer51}
     * 解法一：暴力双循环
     * 时间复杂度：o(n^2)，过不去测试用例，超时！！所以得另寻他法。
     */
    public int reversePairs(int[] nums) {
        int reversePairsCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) reversePairsCount++;
            }
        }
        return reversePairsCount;
    }


    /**
     *【6-12】数组中的逆序对**
     * {剑指Offer51}
     * 解法二：利用"归并排序"，求逆序度
     * 时间复杂度：o(nlogn)
     */
    private int reversePairsCount = 0;
    public int reversePairs_2(int[] nums) {
        reversePairsRecursion(nums, 0, nums.length-1);
        return reversePairsCount;
    }
    private void reversePairsRecursion(int[] a, int left, int right) {
        // 千万别忘了终止条件；
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        reversePairsRecursion(a, left, middle);
        reversePairsRecursion(a, middle+1, right);

        mergeArraySortedAndCalRPCount(a, left, middle, right);
    }
    private void mergeArraySortedAndCalRPCount(int[] arr, int left, int middle, int right) {
        int ln = middle - left + 1;
        int rn = right - middle;
        int[] leftArr = new int[ln];
        int[] rightArr = new int[rn];

        int arrOffset = left;
        for (int i = 0; i < ln; i++) leftArr[i] = arr[arrOffset++];
        for (int i = 0; i < rn; i++) rightArr[i] = arr[arrOffset++];

        arrOffset = left;
        int li = 0;
        int ri = 0;
        while (li < ln && ri < rn) {
            if (leftArr[li] <= rightArr[ri]) {
                arr[arrOffset] = leftArr[li];
                li++;
            } else {
                arr[arrOffset] = rightArr[ri];
                ri++;
                // 灵魂在这里，一个语句定乾坤！
                reversePairsCount += (ln - li);
            }
            arrOffset++;
        }

        while (li < ln) arr[arrOffset++] = leftArr[li++];
        while (ri < rn) arr[arrOffset++] = rightArr[ri++];
    }

}
