package datastructure.heap;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/19 18:56
 */

import datastructure.CommonUtils;

/**
 * 大顶堆
 */
public class MaxHeap {

    private int[] heap;     // 从下标"1"开始存储
    private int n;          // 堆可以存储的最大数据个数
    private int count;      // 当前堆中元素个数

    public MaxHeap(int n_) {
        this.n = n_;
        heap = new int[this.n + 1];
        count = 0;
    }

    /**
     * 向大顶堆中插入元素
     */
    public void insert(int data) {
        if (this.count >= this.n) return;
        this.count++;
        heap[count] = data;

        // 自下向上堆化
        int i = count;
        while (i / 2 > 0  &&  heap[i / 2] < heap[i]) {
            CommonUtils.swap(heap, i / 2, i);
            i /= 2;
        }
    }

}
