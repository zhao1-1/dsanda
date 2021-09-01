package datastructure.stackAndQueue;

import java.util.Stack;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/1 15:39
 */

/**
 * 辅助栈用于出栈时，最小值出栈找老二小的时候用！
 */
public class MinStack1 {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;
    int minItem;

    /** initialize your data structure here. */
    public MinStack1() {
        this.stack = new Stack<>();
        this.minItem = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val < minItem) {
            minItem = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == minItem) {
            this.tempStack = new Stack<>();
            minItem = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int x = stack.pop();
                if (x < minItem) minItem = x;
                tempStack.push(x);
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minItem;
    }
}
