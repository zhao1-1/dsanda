package datastructure.stackAndQueue;

import com.sun.deploy.util.StringUtils;

/**
 * 数组实现栈【推荐】
 */
public class ArrayStack {
    int[] items;
    int n;
    int curr;

    public ArrayStack(int n) {
        this.items = new int[n];
        this.n = n;
        this.curr = 0;
    }

    public boolean push(int item) {
        if (curr == n) return false;
        items[curr] = item;
        curr++;
        return true;
    }

    public int pop() {
        if (curr == 0) return -1;
        return items[--curr];
    }

    public int peek() {
        if (curr == 0) return -1;
        return items[curr-1];
    }

    public void printStack() {
        for (int i = 0; i < curr; i++) {
            System.out.print(items[i]);
            System.out.print("-");
        }
        System.out.println("");
        System.out.println("-----------------------");
    }

}
