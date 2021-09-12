package datastructure;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/8 18:05
 */
public class SortUtil {

    /**
     * 冒泡排序（数组实现）
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(1)
     * 稳定性：YES
     * 原地性：YES
     * 应用：理论
     */
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


    /**
     * 插入排序（数组实现）
     * 时间复杂度：o(n^2)
       + 最好：
       + 最坏：
     * 空间复杂度：o(1)
     * 稳定性：YES
     * 原地性：YES
     * 应用：简单的排序函数（数据规模不大）
     */
    public static int[] insertionSort(int[] a) {
        if (a == null || a.length == 0 || a.length == 1) return a;

        for (int i = 1; i < a.length; i++) {
            int bubble = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > bubble)
                    a[j+1] = a[j];
                else
                    break;
            }
            a[j+1] = bubble;
        }
        return a;
    }


    /**
     * 插入排序（链表实现）
     * 时间复杂度：o(n^2)
       + 最好：
       + 最坏：
     * 空间复杂度：o(1)
     * 稳定性：YES
     * 原地性：YES
     * 应用：
     */
    public static ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sortHead = new ListNode();
        sortHead.next = head;
        ListNode tail = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode former = sortHead;
            ListNode latter = sortHead.next;
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
            curr = tail.next;
        }
        return sortHead.next;
    }



    /**
     * 选择排序（数组实现）
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(1)
     * 稳定性：NO
     * 原地性：YES
     * 应用：理论研究
     */
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


    /**
     * 归并排序（数组实现）
     * 时间复杂度：o(nlogn)
     * 空间复杂度：o(n)
     * 稳定性：YES
     * 原地性：NO
     * 应用：排序函数
     */
    public int[] mergeSort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        mergeSortRecursion(a, left, right);
        return a;
    }

    private void mergeSortRecursion(int[] arr, int left, int right) {
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        mergeSortRecursion(arr, left, middle);
        mergeSortRecursion(arr, middle + 1, right);

        mergeArraySorted(arr, left, middle, right);
    }

    private void mergeArraySorted(int[] arr, int left, int middle, int right) {
        int[] leftArr = new int[middle - left + 1];
        int[] rightArr = new int[right - middle];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[middle + 1 + i];
        }

        int rightIndex = 0;
        int leftIndex = 0;
        int arrIndex = left;    // arrIndex初始值不能是0
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[arrIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }

        while (leftIndex < leftArr.length) {
            arr[arrIndex++] = leftArr[leftIndex++];
        }
        while (rightIndex < rightArr.length) {
            arr[arrIndex++] = rightArr[rightIndex++];
        }
    }


}
