package datastructure.stackAndQueue;

/**
 * 链表实现栈
 */
public class LinkedListStack {
    class Node {
        int data;
        Node next;
        public Node() {}
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private int count = 0;

    public int push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        return ++count;
    }

    public int pop() {
        if (head == null) return -1;
        int popValue = head.data;
        head = head.next;
        count--;
        return popValue;
    }

    public int peek() {
        if (head == null) return -1;
        return head.data;
    }


    public void printStack() {
        Node newHead = new Node();
        newHead.next = head;
        Node p = newHead;
        while (p.next != null) {
            System.out.print(p.next.data + " -> ");
            p = p.next;
        }
        System.out.print("NULL");
        System.out.println("");
        System.out.println("------------");
    }

}
