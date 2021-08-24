package datastructure;

public class Test3 {
    public static void main(String[] args) {
        Solution3 sl3 = new Solution3();

        ListNode head = new ListNode();
        ListNode p = head;
        int[] input = new int[]{1,2,6,3,4,5,6};
        for (int i = 0; i < input.length; i++) {
            p.val = input[i];
            p.next = new ListNode();
            p = p.next;
        }
        sl3.removeElements_3(head, 6);


        ListNode head2 = new ListNode();
        ListNode p2 = head2;
        int[] input2 = new int[]{1,2};
        for (int i = 0; i < input2.length; i++) {
            p2.val = input2[i];
            p2.next = new ListNode();
            p2 = p2.next;
        }
        sl3.removeElements_3(head2, 1);


        ListNode head3 = new ListNode();
        ListNode p3 = head3;
        int[] input3 = new int[]{7,7,7,7};
        for (int i = 0; i < input3.length; i++) {
            p3.val = input3[i];
            p3.next = new ListNode();
            p3 = p3.next;
        }
        sl3.removeElements_3(head3, 7);


        sl3.removeElements_3(new ListNode(), 3);


    }
}
