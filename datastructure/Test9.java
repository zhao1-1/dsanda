package datastructure;

import datastructure.tree.BST;
import datastructure.tree.BTUtils;

import java.util.Arrays;

public class Test9 {
    public static void main(String[] args) {

        BTUtils btUtils = new BTUtils();

//        System.out.println(btUtils.isPalindromeArray(Arrays.asList(0,3,0,2,0,4,0,1,0,4,0,2,0,3,0)));

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
//        bst.insert(9);

//        System.out.println(btUtils.inorderTraversalR(bst.getMe()).toString());     // 3, 6, 7, 9, 10, 13, 15, 20, 26
//        System.out.println(btUtils.inorderTraversal(bst.getMe()).toString());      // 3, 6, 7, 9, 10, 13, 15, 20, 26
//        System.out.println(btUtils.preorderTraversalR(bst.getMe()).toString());    // 15, 6, 3, 10, 7, 9, 13, 20, 26
//        System.out.println(btUtils.preorderTraversal(bst.getMe()).toString());     // 15, 6, 3, 10, 7, 9, 13, 20, 26
//        System.out.println(btUtils.postorderTraversalR(bst.getMe()).toString());   // 3, 9, 7, 13, 10, 6, 26, 20, 15
//        System.out.println(btUtils.postorderTraversal(bst.getMe()).toString());    // 3, 9, 7, 13, 10, 6, 26, 20, 15
//        System.out.println(btUtils.levelOrderLR(bst.getMe()).toString());          // 15, 6, 20, 3, 10, 26, 7, 13, 9
//        System.out.println(btUtils.levelOrderLR2(bst.getMe()).toString());         // [[15], [6, 20], [3, 10, 26], [7, 13], [9]]
//        System.out.println(btUtils.levelOrderRL(bst.getMe()).toString());          // 15, 20, 6, 26, 10, 3, 13, 7, 9
//        System.out.println(btUtils.levelOrderRL2(bst.getMe()).toString());         // [[15], [20, 6], [26, 10, 3], [13, 7], [9]]
//        System.out.println(btUtils.levelOrderZ2(bst.getMe()).toString());          // [[15], [20, 6], [3, 10, 26], [13, 7], [9]]

//        System.out.println(bst.search(20).right.data);
//        System.out.println(bst.searchR(15).left.data);
//        System.out.println(bst.search(6).right.data);
//        System.out.println(bst.searchR(7).data);

//        bst.remove(9);
//        bst.remove(6);
//        bst.remove(26);
//        System.out.println(btUtils.inorderTraversalR(bst.getMe()).toString());     // 3, 7, 10, 13, 15, 20
//        System.out.println(btUtils.preorderTraversalR(bst.getMe()).toString());    // 15, 7, 3, 10, 13, 20

//        bst.insert(6);
//        bst.insert(19);
//        System.out.println(btUtils.preorderTraversalR(bst.getMe()).toString());    // 15, 7, 3, 6, 10, 13 ,20, 19
//        System.out.println(btUtils.postorderTraversalR(bst.getMe()).toString());   // 6, 3, 13, 10, 7, 19, 20, 15
//        bst.remove(15);
//        System.out.println(btUtils.preorderTraversalR(bst.getMe()).toString());    // 19, 7, 3, 6, 10, 13, 20
//        System.out.println(btUtils.postorderTraversalR(bst.getMe()).toString());   // 6, 3, 13, 10, 7, 20, 19
//        System.out.println(btUtils.levelOrderLR(bst.getMe()).toString());          // 19, 7, 20, 3, 10, 6, 13



        BST bst2 = new BST();
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(6);
        bst2.insert(3);
        bst2.insert(7);
//        System.out.println(btUtils.preorderTraversalR(bst2.getMe()));

        /**
         * 9-3.1 二叉树最大深度 {力扣-104}
         */
//        System.out.println(btUtils.maxDepth(bst.getMe()));

        /**
         * 9-3.3 判断是否为平衡二叉树 {剑指offer55-II}
         */
//        bst.remove(9);
//        System.out.println(btUtils.isBalancedTree(bst.getMe()));

        /**
         * 9-3.7 验证二叉搜索树 {力扣-98}
         */
//        System.out.println(btUtils.isValidBST(bst2.getMe()));
//        System.out.println(btUtils.isValidBST(bst.getMe()));

        /**
         * 9-4.1 二叉搜索树的第K大节点 {剑指Offer54}
         */
//        System.out.println(bst.kthLargest(0).data);
//        System.out.println(bst.kthLargest(3).right.data);
//        System.out.println(bst.kthLargest(3).data);
//        System.out.println(bst.kthLargest(4).data);
//        System.out.println(bst.kthLargest(5).data);
//        System.out.println(bst.kthLargest(6).data);
//        System.out.println(bst.kthLargest(7).data);
//        System.out.println(bst.kthLargest(8).data);
//        System.out.println(bst.kthLargest(9));

        /**
         * 9-5.2 BST的最近公共祖先 {剑指Offer 68-I}
         */
//        System.out.println(bst.lowestCommonAncestor(3,6).data);
//        System.out.println(bst.lowestCommonAncestor(7,13).data);
//        System.out.println(bst.lowestCommonAncestor(10,13).data);
//        System.out.println(bst.lowestCommonAncestor(10,26).data);

    }
}
