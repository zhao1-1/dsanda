package datastructure.stackAndQueue;

/**
 *【4-5】三合一
 * {面金03.01}
 */

/**
 * 自己的思路实现的，但是感觉很复杂，很容易出bug。
 */
public class TripleInOne1 {

    private int[] tripleStack;
    private int first;
    private int second;
    private int third;
    private int stackSize;

    public TripleInOne1(int stackSize) {
        this.tripleStack = new int[stackSize * 3];
        this.stackSize = stackSize;
        this.first = 0 * stackSize;
        this.second = 1 * stackSize;
        this.third = 2 * stackSize;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0) {
            if (first != stackSize * 1) {
                tripleStack[first] = value;
                first++;
            }
        } else if (stackNum == 1) {
            if (second != stackSize * 2) {
                tripleStack[second] = value;
                second++;
            }
        } else if (stackNum == 2) {
            if (third != stackSize * 3) {
                tripleStack[third] = value;
                third++;
            }
        }
    }

    public int pop(int stackNum) {
        if (stackNum == 0) {
            if (first > 0) {
                first--;
                return tripleStack[first];
            }
        } else if (stackNum == 1) {
            if (second > 1 * stackSize) {
                second--;
                return tripleStack[second];
            }
        } else if (stackNum == 2) {
            if (third > 2 * stackSize) {
                third--;
                return tripleStack[third];
            }
        }
        return -1;
    }

    public int peek(int stackNum) {
        if (stackNum == 0) {
            if (first > 0) {
                return tripleStack[first-1];
            }
        } else if (stackNum == 1) {
            if (second > 1 * stackSize) {
                return tripleStack[second-1];
            }
        } else if (stackNum == 2) {
            if (third > 2 * stackSize) {
                return tripleStack[third-1];
            }
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) {
            if (first > 0) {
                return false;
            }
        } else if (stackNum == 1) {
            if (second > 1 * stackSize) {
                return false;
            }
        } else if (stackNum == 2) {
            if (third > 2 * stackSize) {
                return false;
            }
        }
        return true;
    }
}
