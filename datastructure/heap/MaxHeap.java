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
    private boolean heaped; // 是否完成建堆

    public MaxHeap(int n_) {
        this.n = n_;
        this.heap = new int[this.n + 1];
        this.count = 0;
        this.heaped = false;
    }

    public MaxHeap(int n_, int[] x) {
        this.n = n_;
        this.heap = new int[this.n + 1];
        this.buildHeap(x);
    }

    private void buildHeap(int[] x) {
        if (this.heaped) return;
        for (int i = 0; i < x.length; i++) {
            heap[i + 1] = x[i];
        }
        this.count = x.length;
        // 处理非叶子结点（1 ~ n/2）
        for (int i = this.count / 2; i >= 1; i--) {
            this.heapT2B(i);
        }
        this.heaped = true;
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

    /**
     * 返回堆顶元素
     */
    public int top() {
        if (count == 0) return Integer.MIN_VALUE;
        return this.heap[1];
    }

    /**
     * 移除堆顶元素
     */
    public void removeTop() {
        if (count == 0) return;
        this.heap[1] = this.heap[this.count];
        this.count--;

        // 从堆顶开始，自上向下堆化
        this.heapT2B(1);
    }

    // 自上向下堆化
    private void heapT2B(int i) {
        int maxPos;
        while (true) {
            maxPos = i;
            if (i * 2 <= this.count  &&  this.heap[i] < this.heap[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= this.count  &&  this.heap[i] < this.heap[i * 2 + 1]) maxPos = i * 2 +1;
            if (maxPos == i) break;
            CommonUtils.swap(this.heap, maxPos, i);
            i = maxPos;
        }
    }

    /**
     * 更新堆中某个位置的元素值
     */
    // 更新后值变小 -> 自上而下堆化
    // 更新后值变大 -> 自下而上堆化

}
