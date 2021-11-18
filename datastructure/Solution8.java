package datastructure;

import java.util.*;

/**
 * 【08. 哈希】
 * 题型：
   1. 查找；
   2. 统计；
   3. 判重；
 */
public class Solution8 {

    /**
     *【8-0.1】HashTable实现
     */


    /**
     *【8-0.2】位图实现
     */


    /**
     *【8-0.3】布隆过滤器实现
     */
    /*

    布隆过滤器：
    "经过hash计算再存进位图里，但是会存在冲突误判"

    hash冲突导致误判：
    + 判定为存在  ---- 有可能存在（存在误判）；
    + 判定为不存在 ---  肯定不存在！

    适用场景：
    （1）一千万个整数，范围0-10亿，判断某个数确定不在这堆数据集里；
    （2）访问数据库查询数据前，先访问内存中的位图，如果经过位图判定数据不存在，就不需要继续访问数据库；

    布隆过滤器降低冲突概率的解决方案：
    "用多个二进制位来表示一个数据，即对一个数进行3次不同的hash运算"

     */


    /**
     *【8-0.4】LRU实现
     */





    /**
     *【8-1】两数之和（要求输出下标）
     * {力扣-1}
     */

    // 解法一：暴力枚举（同【1-3】）
    public int[] twoSum_1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 解法二：哈希（最优解）
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> pools = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pools.containsKey(target - nums[i])) {
                return new int[]{pools.get(target-nums[i]), i};
            }
            pools.put(nums[i], i);
        }
        return new int[0];
    }

    // 解法三：排序 + 双指针（同【15-1-3】）
    class NumAndIndex {
        int num;
        int index;
        NumAndIndex(int num_, int index_) {
            this.num = num_;
            this.index = index_;
        }
    }
    public int[] twoSum_3(int[] nums, int target) {
        NumAndIndex[] numAndIndices = new NumAndIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numAndIndices[i] = new NumAndIndex(nums[i], i);
        }
        Arrays.sort(numAndIndices, (x1, x2) ->  x1.num - x2.num);

        int l = 0;
        int r = numAndIndices.length - 1;
        while (l < r) {
            if (numAndIndices[l].num + numAndIndices[r].num > target)
                r--;
            else if (numAndIndices[l].num + numAndIndices[r].num < target)
                l++;
            else
                return new int[]{numAndIndices[l].index, numAndIndices[r].index};
        }
        return new int[0];
    }



    /**
     *【8-2】三数之和（去重）
     * {力扣-15}
     * 总结：
       暴力枚举的时间复杂度是o(n^3)
       减少时间复杂度本质（无论是通过双指针还是通过hash），最主要的根本原因还是由于“排序”！
       一个有序性的数组，搜寻的时间复杂度从 n，锐减成log n，本质还是利用“二分查找”原理！
     */
    // 解法一：排序 + Hash去重（不推荐）
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int target = 0;
        Arrays.sort(nums);

        HashMap<Integer, Integer> pools = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pools.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;             // 避免a重复
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;     // 避免b重复
                int c = target - (nums[i] + nums[j]);
                if (!pools.containsKey(c)) continue;
                if (pools.get(c) > j) {                                 // 通过hash避免c重复
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(c);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    // 解法二：排序 + 双指针（同【15-1-4】）（最优解）
    public List<List<Integer>> threeSum_2(int[] nums) {
        /*
        nums = {-1, 0, 1, 2, -1, -4}
        sort = {-4, -1, -1, 0, 1, 2}

        nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}
        sort = {-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4}
         */
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        int n = nums.length;

        Arrays.sort(nums);

        int head;
        int tail;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;     // 避免a重复
            head = i + 1;
            tail = n - 1;
            while (head < tail) {
                if (head > i + 1 && nums[head] == nums[head - 1]) {             // 避免b重复
                    head++;
                    continue;
                }
                if (tail < n - 1 && nums[tail] == nums[tail + 1]) {             // 避免c重复
                    tail--;
                    continue;
                }
                if (nums[head] + nums[tail] == target - nums[i]) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[head]);
                    subResult.add(nums[tail]);
                    result.add(subResult);
                    head++;
                    tail--;
                } else if (nums[head] + nums[tail] > target - nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return result;
    }

    // 解法三：暴力枚举（如果要求去重，则此法不适用）
    public List<List<Integer>> threeSum_3(int[] nums) {
        int target = 0;
        List result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> subResult = new ArrayList<>();
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[k]);
                        result.add(subResult);
                    }
                }
            }
        }
        return result;
    }



    /**
     *【8-3】相交链表
     * {力扣-160}
     */
    // 见【3-13】解法二



    /**
     *【8-4】环形链表
     * {力扣e-141}
     */
    // 见【3-12】解法二



    /**
     *【8-5】移除链表中的重复节点
     * {面金-02.01}
     */
    // 区分【3-2】，这俩不一样！本题必须借助Hash表
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> pools = new HashSet<>();
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode curr = head;
        while (curr != null) {
            if (!pools.contains(curr.val)) {
                pools.add(curr.val);
                newTail.next = curr;
                newTail = curr;
            }
            curr = curr.next;
        }
        newTail.next = null;
        return newHead.next;
    }



    /**
     *【8-6】单词频率
     * {面金-16.02}
     */
    class WordsFrequency {

        private HashMap<String, Integer> wFreSta = new HashMap<>();

        public WordsFrequency(String[] book) {
            Integer count;
            for (String s : book) {
                count = 1;
                if (wFreSta.containsKey(s)) {
                    count += wFreSta.get(s);
                }
                wFreSta.put(s,count);
            }
        }

        public int get(String word) {
            if (!wFreSta.containsKey(word)) return 0;
            return wFreSta.get(word);
        }
    }



    /**
     *【8-7】判断是否互为字符重排
     * {面金-01.02}
     */
    // 解法一：排序
    public boolean CheckPermutation_1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i]) return false;
        }
        return true;
    }

    // 解法二：位图
    public boolean CheckPermutation_2(String s1, String s2) {
        // 快速逃逸
        if (s1.length() != s2.length()) return false;

        int[] bitMap = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            bitMap[s1.charAt(i) - 'a']++;
        }
        int currIndex = 0;
        for (int i = 0; i < s2.length(); i++) {
            currIndex = s2.charAt(i) - 'a';
            bitMap[currIndex]--;
            // 剪枝，快速逃逸
            if (bitMap[currIndex] < 0) return false;
        }
        for (int i = 0; i < bitMap.length; i++) {
            if (bitMap[i] != 0) return false;
        }
        return true;
    }

    // 解法三：hash
    public boolean CheckPermutation_3(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> pools = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            int count = 1;
            if (pools.containsKey(key))
                count += pools.get(key);
            pools.put(key, count);
        }
        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            if (!pools.containsKey(key)) return false;
            int count = pools.get(key);
            if (count == 0) return false;
            pools.put(key, --count);
        }
        for (int i = 0; i < s1.length(); i++) {
            if (pools.get(s1.charAt(i)) != 0) return false;
        }
        return true;
    }



    /**
     *【8-8】数组中重复的数字
     * {剑指Offer-03}
     */
    // 解法一：哈希
    public int findRepeatNumber(int[] nums) {
        HashSet pools = new HashSet();
        for (int num : nums) {
            if (pools.contains(num)) return num;
            pools.add(num);
        }
        return -1;
    }

    // 解法二：排序后遍历判断
    public int findRepeatNumber_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return -1;
    }

     // 解法三：位图
     public int findRepeatNumber_3(int[] nums) {
        boolean[] bitMap = new boolean[100000];
         for (int i = 0; i < nums.length; i++) {
             if (!bitMap[nums[i]])
                 bitMap[nums[i]] = true;
             else
                 return nums[i];
         }
         return -1;
     }



    /**
     *【8-9】有效的字母异位词
     * {力扣-242}
     */
    // 见【6-2】



    /**
     *【8-10】字母异位词分组*
     * {力扣-49}
     * 解法一：排序 + 哈希表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> pools = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            // 精髓：将排序后的字符数组作为key
            Arrays.sort(cs);
            String key = new String(cs);
            List value = pools.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            pools.put(key,value);
        }
        return new ArrayList<List<String>>(pools.values());
    }



    /**
     *【8-11】只出现一次的数字
     * {力扣-136}
     */
    // 解法一：排序
    public int singleNumber_1(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        // 由于存在一个不同，所以nums.length一定是奇数
        for (; i < nums.length - 2; i+=2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[i];
    }

    // 解法二：hash
    public int singleNumber_2(int[] nums) {
        HashSet<Integer> pools = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (pools.contains(nums[i]))
                pools.remove(nums[i]);
            else
                pools.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer ele : pools) {
            result.add(ele);
        }
        return result.get(0);
    }

    // 解法三：位图（不建议使用，bitMap太大）

    // 解法四：位运算（见【15-4-11】）
    public int singleNumber_4(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }



    /**
     *【8-12】两个数组的交集
     * {力扣-349}
     * 拓展：
       (1) k个数组的交集
       (2) 两个有序链表的合并
       (3) k个有序链表的合并
     */
    // 解法一：排序 + 双指针
    public int[] intersection_1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        LinkedList<Integer> result = new LinkedList();
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2])
                i1++;
            else if (nums1[i1] > nums2[i2])
                i2++;
            else {
                // 这种写法很cool
                if (Objects.isNull(result.peekLast()) || nums1[i1] != result.peekLast())
                    result.add(nums1[i1]);
                i1++;
                i2++;
            }
        }

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = result.poll();
        }
        return resultArr;
    }

    // 解法二：hash
    public int[] intersection_2(int[] nums1, int[] nums2) {
        HashSet<Integer> pools = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            pools.add(nums1[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (pools.contains(nums2[i])) {
                pools.remove(nums2[i]);
                result.add(nums2[i]);
            }
        }

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }



    /**
     *【8-13】数组的相对排序*
     * {力扣-1122}
     */
    // 解法："自己一把梭"：hash + sort
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        //（1）把arr1计数放到hash表里
        HashMap<Integer, Integer> xxx = new HashMap();
        for (int ele : arr1) {
            int count = 1;
            if (xxx.containsKey(ele)) {
                count += xxx.get(ele);
            }
            xxx.put(ele, count);
        }

        //（2）把arr2中存在于arr1中的先输出
        int index = 0;
        for (int ele2 : arr2) {
            for (int i = 0; i < xxx.get(ele2); i++) {
                result[index++] = ele2;
            }
            xxx.remove(ele2);
        }

        //（3.1）再把arr1剩下的部分找出来
        int[] reset = new int[arr1.length - index];
        int j = 0;
        for (Integer key : xxx.keySet()) {
            for (int i = 0; i < xxx.get(key); i++) {
                reset[j++] = key;
            }
        }
        //（3.2）然后排序
        Arrays.sort(reset);
        //（3.3）最后再拼接到上一步的结果中
        j = 0;
        while (index < arr1.length) {
            result[index++] = reset[j++];
        }

        return result;
    }



    /**
     *【8-14】设计哈希映射（自己实现HashMap）
     * {力扣-706}
     */
    // 见【8-0.1】



    /**
     *【8-15】LRU缓存机制
     * {力扣-146}
     */
    // 见【8-0.4】



    /**
     *【8-16】交换和*
     * {面金-16.21}
     * "试了几把梭哈出来了"
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        //（1）求和并放入HashSet
        int sum1 = 0;
        int sum2 = 0;
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            set1.add(array1[i]);
        }
        for (int j = 0; j < array2.length; j++) {
            sum2 += array2[j];
            set2.add(array2[j]);
        }

        //（2）找规律，并通过set2在set1中筛选
//        int diff = Math.abs(sum1 - sum2);
//        if (diff % 2 != 0) return new int[0];
//        for (Integer ele : set2) {
//            if (set1.contains(Math.abs(diff / 2 - ele))) return new int[]{Math.abs(diff / 2 - ele), ele};
//            if (set1.contains(-Math.abs(diff / 2 - ele))) return new int[]{-Math.abs(diff / 2 - ele), ele};
//            if (set1.contains(Math.abs(diff / 2 + ele))) return new int[]{Math.abs(diff / 2 + ele), ele};
//            if (set1.contains(-Math.abs(diff / 2 + ele))) return new int[]{-Math.abs(diff / 2 + ele), ele};
//        }
        int sum = sum1 + sum2;
        if (sum % 2 == 1) return new int[0];
        for (Integer ele : set2) {
            if (set1.contains(sum / 2 - sum2 + ele)) return new int[]{(sum / 2 - sum2 + ele), ele};
        }


        return new int[0];
    }


}
