package datastructure.hash;

import java.util.HashMap;

public class LRUCache {

    class DLinkedNode {
        Integer key;
        String value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> hashPools = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode(-1, "SB");
        this.tail = new DLinkedNode(-1, "SB");
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }


    public String get(Integer key) {
        if (size == 0) return null;
        if (!inHashPools(key)) return null;

        DLinkedNode valueNode = hashPools.get(key);
        removeNode(valueNode);
        addNodeAtHead(valueNode);
        return valueNode.value;
    }


    public boolean put(Integer key, String value) {
        if (inHashPools(key)) {
            DLinkedNode node = hashPools.get(key);
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            if (node.value.equals(value)) return false;
            else return true;
        }
        if (capacity == size) {
            hashPools.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        hashPools.put(key, newNode);
        addNodeAtHead(newNode);
        size++;
        return true;
    }


    public boolean remove(Integer key) {
        if (!inHashPools(key)) return false;
        removeNode(hashPools.get(key));
        hashPools.remove(key);
        size--;
        return true;
    }

    public void printLRUCacheList() {
        DLinkedNode curr = this.head.next;
        System.out.print("NULL <- HEAD <-> ");
        while (curr != tail) {
            System.out.print("{" + "key:" + curr.key + " value:" + curr.value + "}" + " <-> ");
            curr = curr.next;
        }
        System.out.print("TAIL -> NULL");
        System.out.println("");
        System.out.println("this LRUPools size : " + this.size);
        System.out.println("----------------------");
    }


    private boolean inHashPools(Integer key) {return hashPools.containsKey(key);}

    private void removeNode(DLinkedNode node) {
        if (node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeAtHead(DLinkedNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

}
