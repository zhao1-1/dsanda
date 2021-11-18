package datastructure.hash;

import java.util.LinkedList;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/18 19:54
 */

/**
 *【自定义hash表（链表法解决hash冲突）】
 */
public class HashTable<T> {

    class HashBlock<T> {
        String id;
        T t;
        HashBlock(String id_, T t_) {
            this.id = id_;
            this.t = t_;
        }
    }

    private int n = 1000;
    private LinkedList<HashBlock<T>> slots[] = new LinkedList[n];


    public HashTable() {
        for (int i = 0; i < n; i++) {
            slots[i] = new LinkedList<HashBlock<T>>();
        }
    }


    public boolean put(String id, T t) {
        int hashValue = createHashValue(id);
        LinkedList<HashBlock<T>> slot = slots[hashValue];
        for (HashBlock<T> block : slot) {
            if (block.id == id) return false;
        }
        slot.addFirst(new HashBlock<>(id, t));
        return true;
    }

    public T get(String id) {
        int hashValue = createHashValue(id);
        LinkedList<HashBlock<T>> slot = slots[hashValue];
        for (HashBlock<T> block : slot) {
            if (block.id.equals(id)) return block.t;
        }
        return null;
    }

    private int createHashValue(String id) {
        int idNum = Integer.parseInt(id);
        return idNum % n;
    }

}
