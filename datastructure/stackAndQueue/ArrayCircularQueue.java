package datastructure.stackAndQueue;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/8/31 16:26
 */
public class ArrayCircularQueue {
    String[] items;
    int arraySize;
    int head;
    int tail;
    int count;

    public ArrayCircularQueue(int n) {
        this.arraySize = n + 1;
        items = new String[arraySize];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public boolean enQueue(String item) {
        if ((tail + 1) % arraySize == head || count == arraySize - 1) return false;
        items[tail] = item;
        count++;
        tail = (tail + 1) % arraySize;
        return true;
    }

    public String deQueue() {
        if (tail == head || count == 0) return null;
        String result = items[head];
        head = (head + 1) % arraySize;
        count--;
        return result;
    }

    public void printQueue() {
        System.out.println("当前循环队列共有元素：" + count + "个，循环队列的容量是：" + (arraySize - 1));
        System.out.println("当前循环队列的头位于：" + head);
        System.out.println("当前循环队列的尾位于：" + tail);
        int curr = head;
        while (curr != tail) {
            System.out.print("<-");
            System.out.print(items[curr]);
            curr = (curr + 1) % arraySize;
        }
        System.out.println("");
        System.out.println("--------------------");
    }

}
