package datastructure.stackAndQueue;

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

        System.out.println(Arrays.toString(SortUtil.bubbleSort(a01)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a02)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a03)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a04)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a05)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a06)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a07)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a08)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a09)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a10)));
        System.out.println(Arrays.toString(SortUtil.bubbleSort(a11)));

    }
}
