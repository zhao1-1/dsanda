package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class BST {

    private Node root;

    public BST() {this.root = null;}

    public BST(int data) {this.root = new Node(data);}

    /**
     * BST搜索target（循环实现）
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     */
    public Node search(int target) {
        Node curr = this.root;
        while (curr != null && curr.data != target) {
            if (curr.data > target) curr = curr.left;
            else curr = curr.right;
        }
        return curr;
    }


    /**
     * BST搜索target（递归实现）
     * 时间复杂度：o(log n)
     * 空间复杂度：o(H)
     */
    public Node searchR(int target) {
        Node root = this.root;
        return searchR(root,target);
    }
    private Node searchR(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        if (root.data > target) return searchR(root.left, target);
        else return searchR(root.right, target);
    }


    /**
     * BST插入操作（循环实现）
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     */
    public void insert(int target) {
        if (this.root == null) {
            this.root = new Node(target);
            return;
        }
        Node curr = this.root;
        while (curr != null) {
            if (target >= curr.data) {
                if (curr.right == null) {
                    curr.right = new Node(target);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new Node(target);
                    break;
                }
                curr = curr.left;
            }
        }
    }


    /**
     * BST插入操作（递归实现）
     */
    public void insertR(int target) {
        if (this.root == null) {
            this.root = new Node(target);
            return;
        }
        insertR(this.root, target);
    }
    private void insertR(Node root, int target) {
        if (target > root.data) {
            if (root.right == null) {
                root.right = new Node(target);
                return;
            } else {
                insertR(root.right, target);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(target);
                return;
            } else {
                insertR(root.left, target);
            }
        }
    }


    /**
     * BST移除操作（循环实现）
     */
    public void remove(int target) {
        Node father = null;
        Node curr = this.root;

        // 先找到要删除的这个节点
        while (curr != null && curr.data != target) {
            father = curr;
            if (curr.data > target) curr = curr.left;
            else curr = curr.right;
        }

        // 没有找到
        if (curr == null) return;

        // 待删除的节点有左右两个子节点
        if (curr.left != null && curr.right != null) {
            // 查找右子树的最小节点
            Node minFather = curr;
            Node minNode = curr.right;
            while (minNode.left != null) {
                minFather = minNode;
                minNode = minNode.left;
            }
            // 将最小节点的data赋给待删除节点
            curr.data = minNode.data;

            // 待删除的节点变成最小的节点
            father = minFather;
            curr = minNode;
        }

        // 待删除节点无子节点或者仅有一个子节点
        Node child = null;
        if (curr.left != null) child = curr.left;
        else child = curr.right;

        if (father == null) root = child;   // 要删除待节点是跟节点
        else if (father.left == curr) father.left = child;
        else father.right = child;

    }


    /**
     * 前序遍历
     * {LeetCode-144}
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public List preorderTraversalR() {
        List allTree = new ArrayList();
        Node root = this.root;
        return preorderTraversalR(root, allTree);
    }
    private List preorderTraversalR(Node root, List allTree) {
        if (root == null) return allTree;
//        System.out.println(root.data);
        allTree.add(root.data);
        preorderTraversalR(root.left, allTree);
        preorderTraversalR(root.right, allTree);
        return allTree;
    }


    /**
     * 中序遍历
     * {LeetCode-94}
     */
    public List inorderTraversalR() {
        List allTree = new ArrayList();
        Node root = this.root;
        return inorderTraversalR(root, allTree);
    }
    private List inorderTraversalR(Node root, List allTree) {
        if (root == null) return allTree;
        inorderTraversalR(root.left, allTree);
        allTree.add(root.data);
        inorderTraversalR(root.right, allTree);
        return allTree;
    }


    /**
     * 后序遍历
     * {LeetCode-145}
     */
    public List postorderTraversalR() {
        List allTree = new ArrayList();
        Node root = this.root;
        return postorderTraversalR(root, allTree);
    }
    private List postorderTraversalR(Node root, List allTree) {
        if (root == null) return allTree;
        postorderTraversalR(root.left, allTree);
        postorderTraversalR(root.right, allTree);
        allTree.add(root.data);
        return allTree;
    }


    /**
     * 层序遍历（按层遍历）
     * {剑指Offer-32-I} {LeetCode-102}
     */
//    public List levelOrder() {
//        List<Integer> allTree = new ArrayList<>();
//
//    }

}
