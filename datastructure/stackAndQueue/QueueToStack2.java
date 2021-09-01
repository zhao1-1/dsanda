package datastructure.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * （1）入队倒腾AB队列
 * （2）出队直接出（不用考虑队列为空的情况）
 * （3）栈的pop、top、empty都直接用队列的即可
 */
public class QueueToStack2 {

    private Queue<Integer> queueA;
    private Queue<Integer> queueB;

    /** Initialize your data structure here. */
    public QueueToStack2() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueB.add(x);
        while (!queueA.isEmpty()) {
            queueB.add(queueA.remove());
        }
        Queue temp = queueA;
        queueA = queueB;
        queueB = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 不用判断空的情况
        return queueA.remove();
    }

    /** Get the top element. */
    public int top() {
        return queueA.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty();
    }
}
