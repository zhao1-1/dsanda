package datastructure.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *【4-2】用队列实现栈（仿下蛋笔法）
 * {LeetCode225}
 *
 * 一个队列实现栈：
 * （1）入栈直接入（直接进入队列）
 * （2）出栈倒腾，用"下蛋笔"的思路
 */
public class QueueToStack1 {

    Queue<Integer> queue = new LinkedList<>();

    public QueueToStack1() {}

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty()) return -1;
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty()) return -1;
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
        int result = queue.peek();
        queue.offer(queue.poll());
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
