package datastructure;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/8 18:05
 */
public class SortUtil {

    // 数组实现冒泡排序
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


    // 数组实现插入排序
    public static int[] insertionSort(int[] a) {

        return a;
    }


    // 链表实现插入排序
    public static ListNode insertionSort(ListNode node) {
        ListNode sortHead = new ListNode();
        sortHead.next = node;
        ListNode tail = node;
        ListNode curr = node.next;
        while (curr != null) {
            ListNode former = sortHead;
            ListNode latter = node;
            while (latter != curr && latter.val < curr.val) {
                former = former.next;
                latter = latter.next;
            }
            if (latter != curr) {
                ListNode temp = curr;
                tail.next = tail.next.next;
                temp.next = latter;
                former.next = temp;
            } else {
                tail = tail.next;
            }
            curr = curr.next;
        }
        return sortHead.next;
    }



    // 数组实现选择排序
    public static int[] selectSort(int[] a) {
        if (a.length <= 1) return a;

        for (int i = 0; i < a.length - 1; i++) {
            // 未排序组里找最小值
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }

            // 交换未排序队首（已排序队尾）元素和最小值
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

}
