package datastructure.tree;

import java.util.*;

public class NTree {

    NNode root;

//    public void insertOnLevel(int target) {
//
//    }

    /**
     * N叉树前序遍历
     * 解法一：套壳子遍历
     * 时间复杂度：o(n)
     * 空间复杂度：o(H)
     */
    public List<Integer> preorder() {
        List allTree = new ArrayList();
        preorderR(this.root, allTree);
        return allTree;
    }
    private void preorderR(NNode root, List allTree) {
        if (root == null) return;
        allTree.add(root.data);
        for (NNode child : root.children) {
            preorderR(child, allTree);
        }
    }


    /**
     * N叉树前序遍历
     * 解法二：直接遍历
     * 时间复杂度：o(n * log n)
     * 空间复杂度：o(H)
     */
    public List<Integer> preorder2(NNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.data);
        for (NNode child : root.children) {
            List<Integer> subResult = preorder2(child);
            //在归的过程，此处addAll，每次都需要循环k次，时间复杂度提高
            result.addAll(subResult);
        }
        return result;
    }


    /**
     * N叉树后续遍历
     */
    public List<Integer> postorder() {
        List<Integer> allTree = new ArrayList<>();
        postorder(this.root, allTree);
        return allTree;
    }
    private void postorder(NNode root, List<Integer> allTree) {
        if (root == null) return;
        for (NNode child : root.children) {
            postorder(child, allTree);
        }
        allTree.add(root.data);
    }


    /**
     * N叉树层序遍历（循环遍历）
     */
//    public List<Integer> levelOrder() {
//        List<Integer> allTree = new ArrayList<>();
//        NNode curr = this.root;
//        while (curr.children != null && curr.children.size() > 0) {
//            for (NNode child : curr.children) {
//                allTree.add(child.data);
//            }
//
//        }
//    }


//    public List<Integer> levelOrder() {
//        List<Integer> allTree = new ArrayList<>();
//        levelOrderR(this.root, allTree);
//        return allTree;
//    }
//    private void levelOrderR(NNode root, List<Integer> allTree) {
//        if (root.children == null || root.children.size() == 0) return;
//        for (NNode child : root.children) {
//            allTree.add(child.data);
//            levelOrderR(child, allTree);
//        }
//    }

    /**
     * N叉树层序遍历（从左至右）（连续输出）
     * 解法：循环遍历 + 仓储队列
     */
    public List<Integer> levelOrderLR() {
        List<Integer> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<NNode> storeQueue = new LinkedList<>();
        storeQueue.add(this.root);
        while (!storeQueue.isEmpty()) {
            NNode pollNode = storeQueue.poll();
            result.add(pollNode.data);
            for (NNode child : pollNode.children) {
                if (child != null) storeQueue.offer(child);
            }
        }
        return result;
    }


    /**
     * N叉树层序遍历（从左至右）（按层分组输出）
     */
    public List<List<Integer>> levelOrderLR2() {
        List<List<Integer>> result = new ArrayList<>();
        if (this.root == null) return result;

        Queue<NNode> storeQueue = new LinkedList<>();
        storeQueue.offer(this.root);
        while (!storeQueue.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<>();
            int currLevelSize = storeQueue.size();
            for (int i = 0; i < currLevelSize; i++) {
                NNode pollNode = storeQueue.poll();
                currLevelResult.add(pollNode.data);
                for (NNode child : pollNode.children) {
                    if (child != null) storeQueue.offer(child);
                }
            }
            result.add(currLevelResult);
        }

        return result;
    }


    /**
     * N叉树层序遍历（Z字蛇形）（按层分组输出）
     */
    public List<List<Integer>> levelOrderZ2() {
        List<List<Integer>> result = new ArrayList<>();
        if (this.root == null) return result;

        int turn = 0;
        Stack<NNode>[] storeStacks = new Stack[]{new Stack<NNode>(), new Stack<NNode>()};
        storeStacks[turn].push(this.root);
        while (!storeStacks[turn].isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<>();
            int currLevelSize = storeStacks[turn].size();
            for (int i = 0; i < currLevelSize; i++) {
                NNode popNode = storeStacks[turn].pop();
                currLevelResult.add(popNode.data);
                if (turn == 0) {
                    for (int j = 0; j < popNode.children.size(); j++)
                        storeStacks[1].push(popNode.children.get(j));
                } else {
                    for (int j = popNode.children.size() - 1; j >= 0; j--)
                        storeStacks[0].push(popNode.children.get(j));
                }
            }
            turn = (turn + 1) % 2;
            result.add(currLevelResult);
        }

        return result;
    }

}
