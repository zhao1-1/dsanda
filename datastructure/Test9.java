package datastructure;

import datastructure.tree.BST;

public class Test9 {
    public static void main(String[] args) {

        /*
            15
       6        20
     3   10   X   26
    X X 7 13 X X X X
        */
        BST bst = new BST();

        bst.insertR(15);
        bst.insertR(20);
        bst.insert(6);
        bst.insertR(10);
        bst.insert(26);
        bst.insert(7);
        bst.insert(3);
        bst.insertR(13);

        System.out.println(bst.inorderTraversalR().toString());     // 3, 6, 7, 10, 13, 15, 20, 26
        System.out.println(bst.inorderTraversal().toString());      // 3, 6, 7, 10, 13, 15, 20, 26
        System.out.println(bst.preorderTraversalR().toString());    // 15, 6, 3, 10, 7, 13, 20, 26
        System.out.println(bst.preorderTraversal().toString());     // 15, 6, 3, 10, 7, 13, 20, 26
        System.out.println(bst.postorderTraversalR().toString());   // 3, 7, 13, 10, 6, 26, 20, 15
        System.out.println(bst.postorderTraversal().toString());    // 3, 7, 13, 10, 6, 26, 20, 15
        System.out.println(bst.levelOrderLR().toString());          // 15, 6, 20, 3, 10, 26, 7, 13
        System.out.println(bst.levelOrderLR2().toString());         // [15], [6, 20], [3, 10, 26], [7, 13]
        System.out.println(bst.levelOrderRL().toString());          // 15, 20, 6, 26, 10, 3, 13, 7
        System.out.println(bst.levelOrderRL2().toString());         // [15], [20, 6], [26, 10, 3], [13, 7]
        System.out.println(bst.levelOrderZ2().toString());          // [15], [20, 6], [3, 10, 26], [13, 7]

//        System.out.println(bst.search(20).right.data);
//        System.out.println(bst.searchR(15).left.data);
//        System.out.println(bst.search(6).right.data);
//        System.out.println(bst.searchR(7).data);

//        bst.remove(6);
//        bst.remove(26);
//        System.out.println(bst.inorderTraversalR().toString());     // 3, 7, 10, 13, 15, 20
//        System.out.println(bst.preorderTraversalR().toString());    // 15, 7, 3, 10, 13, 20

//        bst.insert(6);
//        bst.insert(19);
//        System.out.println(bst.preorderTraversalR().toString());    // 15, 7, 3, 6, 10, 13 ,20, 19
//        System.out.println(bst.postorderTraversalR().toString());   // 6, 3, 13, 10, 7, 19, 20, 15
//        bst.remove(15);
//        System.out.println(bst.preorderTraversalR().toString());    // 19, 7, 3, 6, 10, 13, 20
//        System.out.println(bst.postorderTraversalR().toString());   // 6, 3, 13, 10, 7, 20, 19
//        System.out.println(bst.levelOrderLR().toString());          // 19, 7, 20, 3, 10, 6, 13

    }
}
