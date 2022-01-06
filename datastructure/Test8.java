package datastructure;

//import datastructure.hash.LRUCache;


import java.util.*;

public class Test8 {
    public static void main(String[] args) {

        /**
         *【8-0.4】LRU实现
         */
//        LRUCache lruCache = new LRUCache(4);
//        System.out.println(lruCache.get(3));
//
//        lruCache.put(1,"dropPP");
//        lruCache.put(2,"wxx");
//        lruCache.put(3,"Trump");
//        lruCache.put(4,"Obama");
//        lruCache.printLRUCacheList();
//
//        lruCache.put(1,"???");
//        lruCache.printLRUCacheList();
//
//        lruCache.put(5,"wxx-new");
//        lruCache.printLRUCacheList();
//
//        lruCache.remove(4);
//        lruCache.remove(3);
//        lruCache.remove(9);
//        lruCache.put(7,"dropPP");
//        lruCache.printLRUCacheList();
//
//        System.out.println(lruCache.get(9));
//        System.out.println(lruCache.get(5));
//        lruCache.printLRUCacheList();


        /**
         * 练习题：
         */
        Solution8 sl8 = new Solution8();

        /**
         *【8-1】两数之和
         * {LeetCode-1}
         */
//        System.out.println(Arrays.toString(sl8.twoSum_3(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(sl8.twoSum_3(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(sl8.twoSum_3(new int[]{3, 2, 6, 4}, 7)));
//        System.out.println(Arrays.toString(sl8.twoSum_3(new int[]{3, 3}, 6)));


        /**
         *【8-2】三数之和
         * {LeetCode-15}
         */
//        System.out.println(sl8.threeSum_2(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(sl8.threeSum_2(new int[]{-2,0,1,1,2}));
//        System.out.println(sl8.threeSum_2(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));


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
//        CommonUtils.printList(sl8.removeDuplicateNodes(CommonUtils.buildList(new int[]{1, 2, 3, 3, 2, 1})));
//        CommonUtils.printList(sl8.removeDuplicateNodes(CommonUtils.buildList(new int[]{1, 1, 1, 1, 2})));


        /**
         *【8-6】单词频率
         * {面金-16.02}
         */
//        String[] book = new String[]{"i","have","an","apple","he","have","a","pen"};
//        Solution8.WordsFrequency wf = sl8.new WordsFrequency(book);
//        System.out.println(wf.get("you"));
//        System.out.println(wf.get("have"));
//        System.out.println(wf.get("an"));
//        System.out.println(wf.get("apple"));
//        System.out.println(wf.get("pen"));


        /**
         *【8-7】判断是否互为字符重排
         * {面金-01.02}
         */
//        System.out.println(sl8.CheckPermutation_1("abc", "bca"));
//        System.out.println(sl8.CheckPermutation_1("abc", "bad"));
//        System.out.println(sl8.CheckPermutation_1("abc", "abcd"));
//        System.out.println(sl8.CheckPermutation_1("abcf", "abc"));
//        System.out.println(sl8.CheckPermutation_1("abcf", "abcg"));


        /**
         *【8-8】数组中重复的数字
         * {剑指Offer-03}
         */
//        System.out.println(sl8.findRepeatNumber_1(new int[]{2, 3, 1, 0, 2, 5, 3}));
//        System.out.println(sl8.findRepeatNumber_1(new int[]{2, 3, 1, 0, 3, 5, 2}));


        /**
         *【8-9】有效的字母异位词
         * {LeetCode-242}
         */
        // 见【6-2】


        /**
         *【8-10】字母异位词分组
         * {LeetCode-49}
         */
//        System.out.println(sl8.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());


        /**
         *【8-11】只出现一次的数字
         * {LeetCode-136}
         */
//        System.out.println(sl8.singleNumber_2(new int[]{2,2,1}));
//        System.out.println(sl8.singleNumber_2(new int[]{2,1,3,1,3}));
//        System.out.println(sl8.singleNumber_2(new int[]{4,1,2,1,2}));


        /**
         *【8-12】两个数组的交集
         * {LeetCode-349}
         */
//        System.out.println(Arrays.toString(sl8.intersection_1(new int[]{1,2,2,1}, new int[]{2,2})));
//        System.out.println(Arrays.toString(sl8.intersection_1(new int[]{4,9,5}, new int[]{9,4,9,8,4})));


        /**
         *【8-13】数组的相对排序
         * {LeetCode-1122}
         */
//        System.out.println(Arrays.toString(sl8.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));


        /**
         *【8-14】设计哈希映射（自己实现HashMap）
         * {LeetCode-706}
         */


        /**
         *【8-15】LRU缓存机制
         * {LeetCode-146}
         */
        // 见【8-0.4】


        /**
         *【8-16】交换和
         * {面金-16.21}
         */
//        System.out.println(Arrays.toString(sl8.findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3})));
//        System.out.println(Arrays.toString(sl8.findSwapValues(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
//        System.out.println(Arrays.toString(sl8.findSwapValues(new int[]{519, 886, 282, 382, 662, 4718, 258, 719, 494, 795}, new int[]{52, 20, 78, 50, 38, 96, 81, 20})));
//        System.out.println(Arrays.toString(sl8.findSwapValues(
//                new int[]{40, 40, 33, 18, 6, 48, 10, 2, 31, 11, 34, 34, 47, 18, 32, 28, 38, 41, 34, 42, 18, 16, 31, 18, 26, 40, 28, 17, 48, 9, 39, 15, 29, 33, 34, 39, 17, 7, 13, 39, 29, 50, 38, 11, 31, 28, 7, 47, 24, 16, 20, 25, 2, 32, 29, 25, 18, 22, 17, 7, 25, 29, 6, 30, 14, 24, 32, 40, 24, 25, 26, 47, 4, 43, 38, 3, 6, 6, 46, 39, 37, 23, 44, 48, -3159, 50, 48, 36, 9, 21, 5, 34, 22, 30, 34, 44, 46, 1, 36, 47},
//                new int[]{44, 72, 57, 92, 95, 76, 53, 76, 46, 22, 55, 22, 57, 31, 31, 96, 63, 89, 76, 70, 66, 81, 58, 63, 81, 47, 21, 55, 55, 57, 25, 24, 65, 40, 92, 84, 83, 98, 59, 98, 97, 50, 41, 67, 39, 99, 30, 50, 24, 34, 22, 44, 72, 38, 60, 20, 25, 68, 25, 35, 59, 54, 53, 50, 66, 82, 71, 96, 38, 23, 29, 53, 39, 87, 100, 91, 37, 78, 66, 53, 35, 74, 100, 72, 81, 50, 70, 85, 78, 84, 42, 95, 79, 74, 20, 78, 52, 69, 90, 94})));


        /**
         * 测试空map，无key返回情况，类内传值
           语法符合规定，不会报错，null可以传递进去。
         */
        Map<Integer, String> map = new HashMap();
        System.out.println("value is -> " + map.get(3));
        System.out.println("value is -> " + map.get(null));

        testA tA = new Test8().new testA();
        tA.setA(map.get(null));
        System.out.println(tA.getA());

    }

    public class testA {
        private String a = "gui";
        private Integer b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
