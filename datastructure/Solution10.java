package datastructure;

import java.util.*;

/**
 * 堆 + Trie树
 */
public class Solution10 {

    /*

    一、堆的定义：
    （1）堆必须是一个完全二叉树；
    （2）堆中每个节点的值必须大于等于（小于等于）其子树中每个结点（左右子结点）的值；

    二、分类：
    “大顶堆” - 如果堆中每个节点的值都大于等于其子树中每个节点的值；
    “小顶堆” - 如果堆中每个节点的值都小于等于其子树中每个节点的值；

    三、堆的存储结构：
    【数组】（由于堆是完全二叉树，所以适合用数组进行存储）
    root   ->  1

    father ->  i
    LChild ->  2i
    RChild ->  2i + 1

    children  ->  i
    father    ->  i / 2

    四、题型：
    （1）优先级队列；
    （2）TOP K；
    （3）求中位数、百分数；

     */


    /*
    10-1 优先级队列
     */

    /**
     *【10-1】合并k个升序链表
     *「力扣-23」
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }

        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) minHeap.offer(curr.next);
        }
        return newHead.next;
    }



    /*
    10-2 TOP K
    分类：
    （a）针对静态数据（查询TOP K操作）
    （b）针对动态数据（只包含添加数据操作和查询TOP K操作）

    解法一：排序，然后取数组中的第K个元素（针对静态数据）
    解法二：利用快速排序的算法思想，做到o(n)（针对静态数据）【6-10】
    解法三：利用堆，插入o(log k)，获取o(1)（针对动态数据）【10-2】
           最小TOP K  -->  大顶堆（堆内的全部K个元素）
           最大TOP K  -->  小顶堆（堆内的全部K个元素）
     */

    /**
     *【10-2】前K个高频元素（静态数据）
     *「力扣-347」
     */
    // 解法：优先级队列（维护一个小顶堆）
    private class QEle {
        int val;
        int count;
        public QEle(int val_, int count_) {
            this.val = val_;
            this.count = count_;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的次数
        Map<Integer, Integer> countsPool = new HashMap<>();
        for (int num : nums) {
            countsPool.put(num, countsPool.getOrDefault(num, 0) + 1);
        }
        // 按照count（出现频率）构建小顶堆
        PriorityQueue<QEle> minHeap = new PriorityQueue<>(new Comparator<QEle>() {
            @Override
            public int compare(QEle o1, QEle o2) {
                return o1.count - o2.count;
            }
        });
        // 求TOP K
        for (Map.Entry<Integer, Integer> entry : countsPool.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(new QEle(num, count));
            } else {
                if (minHeap.size() > 0 && minHeap.peek().count < count) {
                    minHeap.poll();
                    minHeap.offer(new QEle(num, count));
                }
            }
        }
        // 输出结果
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().val;
        }
        return result;
    }



    /**
     *【10-3】最接近原点的K个点
     *「力扣-973」
     */
    class QEle2 {
        int distance;
        int index;
        public QEle2(int distance_, int index_) {
            this.distance = distance_;
            this.index = index_;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<QEle2> maxHeap = new PriorityQueue<>(new Comparator<QEle2>() {
            @Override
            public int compare(QEle2 o1, QEle2 o2) {
                return o2.distance - o1.distance;
            }
        });
        for (int i = 0; i < points.length; i++) {
            int distance = this.distanceOfPoint2Zero(points[i]);
            if (maxHeap.size() < k)
                maxHeap.offer(new QEle2(distance, i));
            else
                if (maxHeap.size() > 0 && distance < maxHeap.peek().distance) {
                    maxHeap.poll();
                    maxHeap.offer(new QEle2(distance, i));
                }
        }
        int[][] result = new int[k][];
        int i = 0;
        while (i < k) {
            if (maxHeap.size() == 0) break;
            int index = maxHeap.poll().index;
            result[i] = new int[]{points[index][0], points[index][1]};
            i++;
        }
        return result;
    }
    private int distanceOfPoint2Zero(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }



    /*
    【10-3】中位数、百分数；
    获得中位数算法：
    1. 需要维护两个堆，需要具备如下特性：
    （a）一个minHeap，一个maxHeap；
    （b）当前数据n是偶数，两个堆数据个数都需要是(n/2)；
        当前数据n是奇数，大顶堆有(n/2+1)个数据，小顶堆维持有(n/2)个数据；
    （c）大顶堆中元素都小于等于小顶堆中元素（大顶堆top < 小顶堆top）；

    2. 每次插入数据维护以上特性的算法：
    （1）当新插入的数据<=maxHeap.peek()，将这个新数据插入到maxHeap，否则插入到minHeap；
    （2）此时如果两个堆中数据个数不符合上面的特性，可以从一个堆中不停的将堆顶元素移到另一个堆；

    3. 中位数：
    （a）当前数据n为奇数时，大顶堆中堆顶元素就是中位数；
    （b）当前数据n为偶数时，中位数 = (maxHeap.peek() + minHeap.peek()) / 2;


    获得百分数算法：
    1. 需要维护两个堆，需要具备如下特性：
    （a）一个minHeap，一个maxHeap；
    （b）当前数据是个数是n，大顶堆保存前(90%*n)个数据，小顶堆保存后(10%*n)个数据；
    （c）大顶堆中元素都小于等于小顶堆中元素（大顶堆top < 小顶堆top）；

    2. 每次插入数据维护以上特性的算法：
    （1）当新插入的数据<=maxHeap.peek()，将这个新数据插入到maxHeap，否则插入到minHeap；
    （2）每次都需要计算大顶堆和小顶堆中元素个数，看是否满足90%，10%的比例，如果不符合，需要将其中一个堆中元素移到另一个堆中，直到满足比例；

    3. 百分位：
    大顶堆堆顶元素就是我们要找的90百分位的数据；


     */

    /**
     *【10-4】数据流的中位数
     *「力扣-295」
     */
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            while (minHeap.size() < maxHeap.size() - 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.isEmpty()) return 0.0;
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return (maxHeap.peek() + minHeap.peek()) / 2f;
        }
    }



}
