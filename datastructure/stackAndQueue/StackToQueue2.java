package datastructure.stackAndQueue;

import java.util.Stack;

/**
 *【4-1】用两个栈实现队列（双杯倒水法）
 * {剑指Offer-09}
 * 用栈实现队列
 * 入队倒腾，出队直接出
 * 适合出队频繁的
 */
public class StackToQueue2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    public StackToQueue2() {}

    public void appendTail(int value) {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(value);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public int deleteHead() {
        if (stack.isEmpty()) return -1;
        return stack.pop();
    }
}
