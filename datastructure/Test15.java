package datastructure;

import java.util.Arrays;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/2 10:39
 */
public class Test15 {
    public static void main(String[] args) {
        Solution15 sl15 = new Solution15();

        /**
         *【15-1-2】数对和
         *『面试题 16.24.』
         */
//        System.out.println(sl15.pairSums(new int[]{5, 6, 5}, 11).);
//        System.out.println(sl15.pairSums(new int[]{5, 6, 5, 6}, 11));
//        System.out.println(sl15.pairSums(new int[]{-2,-1,0,3,5,6,7,9,13,14}, 12));

        /**
         *【15-1-3】两数之和
         *『力扣-1』
         * 解法三：双指针
         */
//        System.out.println(Arrays.toString(sl15.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(sl15.twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(sl15.twoSum(new int[]{3, 3}, 6)));

        /**
         *【15-1-7】移动零（已排序、未排序指针）
         *『力扣-283』
         */
//        System.out.println(Arrays.toString(sl15.moveZeroes(new int[]{0, 1, 0, 3, 12})));
//        int[] nums1 = new int[]{0, 1, 0, 3, 12};
//        sl15.moveZeroes2(nums1);
//        System.out.println(Arrays.toString(nums1));

        /**
         *【15-1-8】最小差（类似合并两个有序数组）
         *『面试题 16.06』
         */
//        System.out.println(sl15.smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
//        System.out.println(sl15.smallestDifference(new int[]{-2147483648,1}, new int[]{2147483647,0}));

//        System.out.println(sl15.smallestDifference2(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
//        System.out.println(sl15.smallestDifference2(new int[]{-2147483648,1}, new int[]{2147483647,0}));

//        System.out.println(Math.abs(-2147483648));
//        System.out.println(Math.abs((long)-2147483648));
//        System.out.println(Math.abs(-2147483647));
//        System.out.println(Math.abs(2147483647));
//        System.out.println(Math.abs(-100));

        /**
         *【15-1-9】单词距离（类似合并两个有序数组）
         *『面试题 17.11』
         */
        System.out.println(sl15.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"}, "a", "student"));

        System.out.println(sl15.findClosest2(new String[]{"I","am","a","student","from","a","university","in","a","city"}, "a", "student"));

    }
}