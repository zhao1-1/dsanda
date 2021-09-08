package datastructure;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/8 18:05
 */
public class SortUtil {

    private static void swapUtil(int A, int B) {
        int temp = A;
        A = B;
        B = temp;
    }

    public static int[] bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) return a;

        for (int i = 0; i < n; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) break;
        }
        return a;
    }


//    public static ListNode insertionSort(ListNode node) {
//
//    }

}
