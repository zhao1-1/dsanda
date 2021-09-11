package datastructure.stackAndQueue;

/**
 *【4-3】pop 最小栈*（排序栈）
 * {面金-03.05}
 */

import java.util.Stack;

/**
 * 无论出栈还是进栈，最小的永远得在最上面（栈顶元素永远是最小值）
 * 本质上，就是弄一个排序栈，从栈顶到底，是由小到大.
 * 我们可以不用栈内元素个数n，只需要利用好栈元素取值是[0,50000]这个条件，以及-1。
 *
 * 思路类似于：【插入排序】
 */
public class SortedStack {

    Stack<Integer> stack;
    Stack<Integer> tempStack;

    public SortedStack() {
        this.stack = new Stack<>();
        this.tempStack = new Stack<>();
        stack.push(-1);
    }

    public void push(int val) {
        while (val > stack.peek() && stack.peek() != -1) {
            tempStack.push(stack.pop());
        }
        stack.push(val);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (stack.peek() >= 0) {
            stack.pop();
        }
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.peek() < 0;
    }
}
