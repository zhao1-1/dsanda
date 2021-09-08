package datastructure;

import datastructure.SortUtil;

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



        Solution3 sl3 = new Solution3();

        sl3.printList(SortUtil.insertionSort(sl3.buildList(a01)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a02)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a03)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a04)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a05)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a06)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a07)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a08)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a09)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a10)));
        sl3.printList(SortUtil.insertionSort(sl3.buildList(a11)));



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

    }
}
