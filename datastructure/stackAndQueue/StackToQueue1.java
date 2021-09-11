package datastructure.stackAndQueue;

import java.util.Stack;

/**
 *【4-1】用两个栈实现队列（双杯倒水法）
 * {剑指Offer-09}
 * 用栈实现队列
 * 入队直接入，出队倒腾
 * 适合入队操作频繁的
 */
public class StackToQueue1 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    public StackToQueue1() {}

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.empty()) return -1;
        int result;
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        result = tempStack.pop();
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
        return result;
    }
}
