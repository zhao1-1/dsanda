package datastructure;

import java.util.*;

public class Solution8 {

    /**
     *【8-0.1】HashMap实现
     */


    /**
     *【8-0.2】位图实现
     */


    /**
     *【8-0.3】布隆过滤器实现
     */


    /**
     *【8-0.4】LRU实现
     */





    /**
     *【8-1】两数之和
     * {LeetCode-1}
     */
    // 见【1-3】解法二


    /**
     *【8-2】三数之和
     * {LeetCode-15}
     */


    /**
     *【8-3】相交链表
     * {LeetCode-160}
     */
    // 见【3-13】解法二


    /**
     *【8-4】环形链表
     * {LeetCodee-141}
     */
    // 见【3-12】解法二


    /**
     *【8-5】移除链表中的重复节点
     * {面金-02.01}
     */
    // 区分【3-2】，这俩不一样！本题必须借助Hash表


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
//    public boolean CheckPermutation(String s1, String s2) {
//
//    }


    /**
     *【8-8】数组中重复的数字
     * {剑指Offer-03}
     * 解法一：哈希
     */
    public int findRepeatNumber(int[] nums) {
        HashSet pools = new HashSet();
        for (int num : nums) {
            if (pools.contains(num)) return num;
            pools.add(num);
        }
        return -1;
    }

    /**
     *【8-8】数组中重复的数字
     * {剑指Offer-03}
     * 解法二：排序后遍历判断
     */
    public int findRepeatNumber_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return -1;
    }

    /**
     *【8-8】数组中重复的数字
     * {剑指Offer-03}
     * 解法三：位图
     */



    /**
     *【8-9】有效的字母异位词
     * {LeetCode-242}
     */
    // 见【6-2】


    /**
     *【8-10】字母异位词分组*
     * {LeetCode-49}
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
     * {LeetCode-136}
     */


    /**
     *【8-12】两个数组的交集
     * {LeetCode-349}
     */


    /**
     *【8-13】数组的相对排序*
     * {LeetCode-1122}
     * "自己一把梭"：hash + sort
     */
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
     * {LeetCode-706}
     */
    // 见【8-0.1】


    /**
     *【8-15】LRU缓存机制
     * {LeetCode-146}
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
