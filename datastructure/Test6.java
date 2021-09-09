package datastructure;

import java.util.Arrays;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/8 18:21
 */
public class Test6 {
    public static void main(String[] args) {

        int[] a01 = new int[]{1, 2, 3, 4, 5, 6};
        int[] a02 = new int[]{6, 5, 4, 3, 2, 1};
        int[] a03 = new int[]{4, 5, 6, 3, 2, 1};
        int[] a04 = new int[]{4, 5, 6, 1, 2, 3};
        int[] a05 = new int[]{6, 5, 4, 1, 2, 3};
        int[] a06 = new int[]{1};
        int[] a07 = new int[]{};
        int[] a08 = new int[]{2, 1};
        int[] a09 = new int[]{9,7,5,3,1,0};
        int[] a10 = new int[]{0,1,3,5,7,9};
        int[] a11 = new int[]{4,3,2,1,9,8,7,6};

        // 冒泡排序（数组实现）
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a01)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a02)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a03)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a04)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a05)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a06)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a07)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a08)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a09)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a10)));
//        System.out.println(Arrays.toString(SortUtil.bubbleSort(a11)));



        // 插入排序（数组实现）
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a01)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a02)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a03)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a04)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a05)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a06)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a07)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a08)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a09)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a10)));
//        System.out.println(Arrays.toString(SortUtil.insertionSort(a11)));



        // 插入排序（链表实现）
//        Solution3 sl3 = new Solution3();
//
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a01)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a02)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a03)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a04)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a05)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a06)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a07)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a08)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a09)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a10)));
//        sl3.printList(SortUtil.insertionSort(sl3.buildList(a11)));



        // 选择排序（数组实现）
//        System.out.println(Arrays.toString(SortUtil.selectSort(a01)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a02)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a03)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a04)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a05)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a06)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a07)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a08)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a09)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a10)));
//        System.out.println(Arrays.toString(SortUtil.selectSort(a11)));



        // 归并排序（数组实现）
//        SortUtil sortUtil = new SortUtil();
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a01)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a02)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a03)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a04)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a05)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a06)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a07)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a08)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a09)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a10)));
//        System.out.println(Arrays.toString(sortUtil.mergeSort(a11)));




        /* ========================================================== */
        Solution6 sl6 = new Solution6();

        //【6-1】合并排序的数组
        System.out.println(Arrays.toString(sl6.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3)));

        System.out.println(Arrays.toString(sl6.merge_2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3)));



        //【6-6】调整数组顺序使奇数位于偶数前面
//        System.out.println(Arrays.toString(sl6.exchange(a03)));
//        System.out.println(Arrays.toString(sl6.exchange(a06)));
//        System.out.println(Arrays.toString(sl6.exchange(a07)));
//        System.out.println(Arrays.toString(sl6.exchange(a08)));

//        System.out.println(Arrays.toString(sl6.exchange_2(a03)));
//        System.out.println(Arrays.toString(sl6.exchange_2(a06)));
//        System.out.println(Arrays.toString(sl6.exchange_2(a07)));
//        System.out.println(Arrays.toString(sl6.exchange_2(a08)));
//        System.out.println(Arrays.toString(sl6.exchange_2(a11)));

//        System.out.println(Arrays.toString(sl6.exchange_3(a03)));
//        System.out.println(Arrays.toString(sl6.exchange_3(a06)));
//        System.out.println(Arrays.toString(sl6.exchange_3(a07)));
//        System.out.println(Arrays.toString(sl6.exchange_3(a08)));
//        System.out.println(Arrays.toString(sl6.exchange_3(a11)));


        //【6-10】数组中的第K个最大元素
//        System.out.println(sl6.findKthLargest(new int[]{3,2,3,1,2,4,4,5,6}, 4));
//        System.out.println(sl6.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }
}