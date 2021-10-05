package datastructure;

public class ListNode {
    // 为了方便各个包都能取到值，用public
    public int val;
    public ListNode next;

    public ListNode() {};
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
