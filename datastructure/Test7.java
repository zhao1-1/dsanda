package datastructure;

public class Test7 {
    public static void main(String[] args) {
        Solution7 sl7 = new Solution7();

        /**
         *【7-0.0】标准二分查找
         * {LeetCode-704}
         */
//        System.out.println(sl7.search_2(new int[]{1}, 1));
//        System.out.println(sl7.search_2(new int[]{1}, 2));
//        System.out.println(sl7.search_2(new int[]{1,2}, 1));
//        System.out.println(sl7.search_2(new int[]{1,2}, 2));
//        System.out.println(sl7.search_2(new int[]{1,2}, 3));
//        System.out.println(sl7.search_2(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println(sl7.search_2(new int[]{-1,0,3,5,9,12}, 2));


        /**
         *【7-0.1】查找第一个等于目标值的元素
         * {跟谁学21春招}
         */
//        System.out.println(sl7.searchFirstTarget(new int[]{1,2,3}, 4));
//        System.out.println(sl7.searchFirstTarget(new int[]{1,2,4,4,4,5,6}, 4));
//        System.out.println(sl7.searchFirstTarget(new int[]{1,2,4,4,4,4,5,6}, 4));
//        System.out.println(sl7.searchFirstTarget(new int[]{4,4}, 4));


        /**
         *【7-0.2】查找最后一个等于目标值的元素
         */
//        System.out.println(sl7.searchLastTarget(new int[]{1,2,3}, 4));
//        System.out.println(sl7.searchLastTarget(new int[]{1,2,4,4,4,5,6}, 4));
//        System.out.println(sl7.searchLastTarget(new int[]{1,2,4,4,4,4,5,6}, 4));
//        System.out.println(sl7.searchLastTarget(new int[]{4,4}, 4));


        /**
         *【7-0.3】查找第一个大于等于target的元素
         */
//        System.out.println(sl7.searchFirstGETarget(new int[]{1,3,5,5,7,8,9,10}, 6));
//        System.out.println(sl7.searchFirstGETarget(new int[]{1,2,3}, 1));


        /**
         *【7-0.4】查找最后一个小于等于target的元素
         */
//        System.out.println(sl7.searchLastLETarget(new int[]{1,3,5,5,7,8,9,10}, 6));


        /**
         *【7-0.5】循环有序数组中查找元素x（没有重复数据）
         */
//        System.out.println(sl7.searchInCycleSortedArr(new int[]{7,9,10,11,15,1,2,3,5,6}, 10));
//        System.out.println(sl7.searchInCycleSortedArr(new int[]{7,9,10,11,15,1,2,3,5,6}, 5));


        /**
         *【7-0.6】循环有序数组中查找最小的元素x（没有重复数据）
         */
//        System.out.println(sl7.searchMinEleInCSA(new int[]{5,6,7,8,9,1,2,3,4}));
//        System.out.println(sl7.searchMinEleInCSA(new int[]{0,1}));
//        System.out.println(sl7.searchMinEleInCSA(new int[]{0,1,2,3,4,5,6}));
//        System.out.println(sl7.searchMinEleInCSA(new int[]{2,3,4,5,6,7,8,9,1}));


        /**
         *【7-0.7】循环有序数组中查找最大的元素x所在位置（没有重复数据）
         */
//        System.out.println(sl7.searchMaxEleInCSA(new int[]{5,6,7,8,9,1,2,3,4}));
//        System.out.println(sl7.searchMaxEleInCSA(new int[]{0,1}));
//        System.out.println(sl7.searchMaxEleInCSA(new int[]{0,1,2,3,4,5,6}));
//        System.out.println(sl7.searchMaxEleInCSA(new int[]{2,3,4,5,6,7,8,9,1}));



        /**
         *【7-0.8】山峰数组中查找峰值元素所在位置
         * {LeetCode-852} {剑指OfferII-069}
         */
//        System.out.println(sl7.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
//        System.out.println(sl7.peakIndexInMountainArray(new int[]{3,4,5,1}));
//        System.out.println(sl7.peakIndexInMountainArray(new int[]{0,2,1,0}));




        /**
         *【7-1】猜数字大小
         * {LeetCode-374}
         */
//        System.out.println(sl7.guessNumber(10));
//        System.out.println(sl7.guessNumber(80));
//        System.out.println(sl7.guessNumber(2126753390));



        /**
         *【7-2】寻找比目标字母大的最小字母
         * {LeetCode744}
         */
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'a'));
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'c'));
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'd'));
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'g'));
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'j'));
//        System.out.println(sl7.nextGreatestLetter("cfj".toCharArray(), 'k'));



        /**
         *【7-3】搜索插入位置
         * {LeetCode-35}
         */
        System.out.println(sl7.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(sl7.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(sl7.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(sl7.searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(sl7.searchInsert(new int[]{1}, 0));

    }
}
