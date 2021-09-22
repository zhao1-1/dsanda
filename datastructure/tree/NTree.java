package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class NTree {

    NNode root;

    /**
     * N叉树前序遍历
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


    public List<Integer> levelOrder() {
        List<Integer> allTree = new ArrayList<>();
        levelOrderR(this.root, allTree);
        return allTree;
    }
    private void levelOrderR(NNode root, List<Integer> allTree) {
        if (root.children == null || root.children.size() == 0) return;
        for (NNode child : root.children) {
            allTree.add(child.data);
            levelOrderR(child, allTree);
        }
    }

}
