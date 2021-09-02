package datastructure.stackAndQueue;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/9/1 19:14
 */

import java.util.Stack;

/**
 * 无论出栈还是进栈，最小的永远得在最上面（栈顶元素永远是最小值）
 * 本质上，就是弄一个排序栈，从栈顶到底，是由小到大
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
