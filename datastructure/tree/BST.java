package datastructure.tree;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.*;

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
     * 前序遍历（递归）
     * {力扣-144}
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
     * 前序遍历（非递归）
     * 解法：循环 + 栈，模拟函数的递归过程
     */
    private class SFrame {
        int status;
        Node node;
        SFrame(int _status, Node _node) {
            this.status = _status;
            this.node = _node;
        }
    }
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, this.root));
        while (!funcStack.isEmpty()) {
            // 该SFrame第一次做栈顶元素：左子树入栈
            if (funcStack.peek().status == 1) {
                result.add(funcStack.peek().node.data);
                funcStack.peek().status += 1;
                if (funcStack.peek().node.left != null)
                    funcStack.push(new SFrame(1, funcStack.peek().node.left));
                continue;
            }
            // 第二次做栈顶元素：左子树都出栈完毕，右子树入栈
            if (funcStack.peek().status == 2) {
                funcStack.peek().status += 1;
                if (funcStack.peek().node.right != null)
                    funcStack.push(new SFrame(1, funcStack.peek().node.right));
                continue;
            }
            // 第三次做栈顶元素：右子树也都出栈完毕，根节点出栈
            if (funcStack.peek().status == 3) {
                funcStack.pop();
            }
        }

        return result;
    }


    /**
     * 中序遍历（递归）
     " BST会按从小到达顺序把树的data都打印出来 "
     * {力扣-94}
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
     * 中序遍历（非递归）
     */
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, this.root));
        while (!funcStack.isEmpty()) {
            if (funcStack.peek().status == 1) {
                funcStack.peek().status += 1;
                if (funcStack.peek().node.left != null)
                    funcStack.push(new SFrame(1, funcStack.peek().node.left));
                continue;
            }
            if (funcStack.peek().status == 2) {
               result.add(funcStack.peek().node.data);
               funcStack.peek().status += 1;
               if (funcStack.peek().node.right != null)
                   funcStack.push(new SFrame(1, funcStack.peek().node.right));
               continue;
            }
            if (funcStack.peek().status == 3) {
                funcStack.pop();
            }
        }

        return result;
    }


    /**
     * 后序遍历（递归）
     * {力扣-145}
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
     * 后序遍历（非递归）
     */
    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, this.root));
        while (!funcStack.isEmpty()) {
            if (funcStack.peek().status == 1) {
                funcStack.peek().status += 1;
                if (funcStack.peek().node.left != null)
                    funcStack.push(new SFrame(1, funcStack.peek().node.left));
                continue;
            }
            if (funcStack.peek().status == 2) {
                funcStack.peek().status += 1;
                if (funcStack.peek().node.right != null)
                    funcStack.push(new SFrame(1, funcStack.peek().node.right));
                continue;
            }
            if (funcStack.peek().status == 3) {
                result.add(funcStack.peek().node.data);
                funcStack.pop();
            }
        }

        return result;
    }



    /**
     * 层序遍历（从左到右）（连续输出）
     * {剑指Offer-32-I} {力扣-102}
     * 解法：循环 + 队列
     */
    public List<Integer> levelOrderLR() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<Node> storeQueue = new LinkedList<>();
        storeQueue.add(this.root);
        while (!storeQueue.isEmpty()) {
            Node pollNode = storeQueue.poll();
            result.add(pollNode.data);
            // 先左
            if (pollNode.left != null) storeQueue.offer(pollNode.left);
            // 再右
            if (pollNode.right != null) storeQueue.offer(pollNode.right);
        }

        return result;
    }


    /**
     * 层序遍历（从左到右）（按层分组输出）
     */
    public List<List<Integer>> levelOrderLR2() {
        List<List<Integer>> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<Node> storeQueue = new LinkedList<>();
        storeQueue.offer(this.root);
        while (!storeQueue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int queueSize = storeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                Node pollNode = storeQueue.poll();
                subResult.add(pollNode.data);
                if (pollNode.left != null) storeQueue.offer(pollNode.left);
                if (pollNode.right != null) storeQueue.offer(pollNode.right);
            }
            result.add(subResult);
        }
        return result;
    }


    /**
     * 层序遍历（从右到左）（连续输出）
     */
    public List<Integer> levelOrderRL() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<Node> storeQueue = new LinkedList<>();
        storeQueue.add(this.root);
        while (!storeQueue.isEmpty()) {
            Node pollNode = storeQueue.poll();
            result.add(pollNode.data);
            // 先右
            if (pollNode.right != null) storeQueue.offer(pollNode.right);
            // 再左
            if (pollNode.left != null) storeQueue.offer(pollNode.left);
        }

        return result;
    }


    /**
     * 层序遍历（从右到左）（按层分组输出）
     */
    public List<List<Integer>> levelOrderRL2() {
        List<List<Integer>> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<Node> storeQueue = new LinkedList<>();
        storeQueue.offer(this.root);
        while (!storeQueue.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<>();
            int sizeOfCurrLevel = storeQueue.size();
            for (int i = 0; i < sizeOfCurrLevel; i++) {
                Node pollNode = storeQueue.poll();
                currLevelResult.add(pollNode.data);
                if (pollNode.right != null) storeQueue.offer(pollNode.right);
                if (pollNode.left != null) storeQueue.offer(pollNode.left);
            }
            result.add(currLevelResult);
        }

        return result;
    }


    /**
     * 层序遍历（Z字蛇形打印）（连续输出）
     */
//    public List<Integer> levelOrderZ() {
//
//    }


    /**
     * 层序遍历（Z字蛇形打印）（按层分组输出）
     */
    public List<List<Integer>> levelOrderZ2() {
        List<List<Integer>> result = new ArrayList<>();
        if (this.root == null) return result;

        int turn = 0;
        Stack<Node>[] storeStacks = new Stack[]{new Stack<Node>(), new Stack<Node>()};
        storeStacks[turn].push(this.root);
        while (!storeStacks[turn].isEmpty()) {
            int currLevelSize = storeStacks[turn].size();
            List<Integer> currLevelResult = new ArrayList<>();
            for (int i = 0; i < currLevelSize; i++) {
                Node popNode = storeStacks[turn].pop();
                currLevelResult.add(popNode.data);
                if (turn == 0) {
                    if (popNode.left != null) storeStacks[1].push(popNode.left);
                    if (popNode.right != null) storeStacks[1].push(popNode.right);
                } else {
                    if (popNode.right != null) storeStacks[0].push(popNode.right);
                    if (popNode.left != null) storeStacks[0].push(popNode.left);
                }
            }
            turn = (turn + 1) % 2;
            result.add(currLevelResult);
        }

        return result;
    }

}
