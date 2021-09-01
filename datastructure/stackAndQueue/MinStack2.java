package datastructure.stackAndQueue;

import java.util.Stack;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/1 16:15
 */

/**
 * 用辅助栈记录当前时刻（主栈item为峰顶时候）的最小值。
 */
public class MinStack2 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack2() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if (val < minStack.peek())
            minStack.push(val);
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
