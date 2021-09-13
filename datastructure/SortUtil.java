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
     * 应用：简单的排序函数（数据规模不大），arr.length < 47的时候
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
       + 函数调用栈最大深度：o(logn)
       + 每次merge申请的临时数组，最大内存（出现在最后一次合并）是 o(n)
     * 稳定性：YES
     * 原地性：NO
     * 应用：Java->Arrays.sort()函数底层实现
     */
    public int[] mergeSort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        mergeSortRecursion(a, left, right);
        return a;
    }
    private void mergeSortRecursion(int[] arr, int left, int right) {
        // 终止条件一定要想清楚
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        mergeSortRecursion(arr, left, middle);
        mergeSortRecursion(arr, middle + 1, right);

        mergeArraySorted(arr, left, middle, right);
    }
    private void mergeArraySorted(int[] arr, int left, int middle, int right) {
        int[] leftArr = new int[middle - left + 1];
        int[] rightArr = new int[right - middle];
        for (int i = 0; i < leftArr.length; i++) leftArr[i] = arr[left + i];
        for (int i = 0; i < rightArr.length; i++) rightArr[i] = arr[middle + 1 + i];

        int ri = 0;
        int li = 0;
        // arrIndex初始值不能是0
        int arrOffset = left;
        while (li < leftArr.length && ri < rightArr.length) {
            // 此处必须是"<="，以保证“稳定性”！
            if (leftArr[li] <= rightArr[ri])
                arr[arrOffset++] = leftArr[li++];
            else
                arr[arrOffset++] = rightArr[ri++];
        }

        while (li < leftArr.length) arr[arrOffset++] = leftArr[li++];
        while (ri < rightArr.length) arr[arrOffset++] = rightArr[ri++];

    }

    /**
     * 归并排序（链表实现）
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middleNode = findMiddleNode(head);
        ListNode rightNode = middleNode.next;
        middleNode.next = null;

        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(rightNode);
        return mergeTwoLists(leftHead, rightHead);
    }
    // 这个middle必须找到middle前面的那个结点，和LeetCode876【3-5】那个题不一样（那个题如果ListNode是双数返回的middle是后一个）
    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 详见【3-3】
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        if (p1 == null) tail.next = p2;
        if (p2 == null) tail.next = p1;

        return newHead.next;
    }




    /**
     * 快排（数组实现）
     * 时间复杂度：o(nlogn)
     * 空间复杂度：o(logn)
       + 最大调用栈深度：o(logn)
       + 未开辟临时数组
     * 稳定性：NO
       + "6A,8,7,6B,3,5,9,4"，第一次交换后 -> "3,7,7,6B,6A,5,9,4"
     * 原地性：YES
     * 应用：Java->Arrays.sort()函数底层实现
     */
    public int[] quickSort(int[] a) {
        quickSortRecursion(a, 0, a.length - 1);
        return a;
    }
    private void quickSortRecursion(int[] arr, int l, int r) {
        //（1）递归终止条件
        if (l >= r) return;
        //（2）分区并返回分区点
        int m = partition(arr, l, r);
        //（3）对分区分别递归调用
        quickSortRecursion(arr, l, m - 1);
        quickSortRecursion(arr, m + 1, r);
    }
    private int partition(int[] arr, int l, int r) {
        // 队尾元素作为“信标”进行比较
        int beacon = arr[r];

        /*
        [l, minSign]         ->  "ele < beacon"
        [minSign+1, maxSign) ->  "ele > beacon"
        [maxSign, r-1]       ->  "not Sorted"
         */
        int minSign = l - 1;
        int maxSign = l;

        for (; maxSign <= r - 1; maxSign++) {
            if (arr[maxSign] < beacon) {
                swap(arr, minSign + 1, maxSign);
                minSign++;
            }
        }
        swap(arr, minSign + 1, r);

        return minSign + 1;
    }
    private void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }



    /*
    ================================
    == Arrays.sort()应用排序算法规则 ==
    ================================

    if (arr.length < 286) {
        if (arr.length < 47)
            use insertionSort();
        else
            use quickSort();
    } else {
        if (!arr.isStruck)
            use quickSort();
        else
            use mergeSort();
    }

     */
}
