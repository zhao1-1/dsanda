package datastructure.stackAndQueue;

/**
 * 链表实现队列（链式队列）【推荐】
 */
public class LinkedListQueue {
    class Node {
        String data;
        Node next;
        public Node() {}
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int count = 0;

    public LinkedListQueue() {}

    public int enQueue(String item) {
        Node newNode = new Node(item,null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        return ++count;
    }

    public String deQueue() {
        if (head == null) return null;
        String result = head.data;
        head = head.next;
        count--;
        return result;
    }

    public void printQueue() {
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
