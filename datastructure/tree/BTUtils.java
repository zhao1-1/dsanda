package datastructure.tree;

import datastructure.ListNode;

import java.util.*;

public class BTUtils {

    /**
     * 前序遍历（递归）
     * {力扣-144}
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public List preorderTraversalR(BNode root) {
        List allTree = new ArrayList();
        return preorderTraversalR(root, allTree);
    }
    private List preorderTraversalR(BNode root, List allTree) {
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
        BNode node;
        SFrame(int _status, BNode _node) {
            this.status = _status;
            this.node = _node;
        }
    }
    public List<Integer> preorderTraversal(BNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, root));
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
        左中右：" BST会按从小到大顺序把树的data都打印出来 "
        右中左：" BST会按从大到小顺序把树的data都打印出来 "
     * {力扣-94}
     */
    public List inorderTraversalR(BNode root) {
        List allTree = new ArrayList();
        return inorderTraversalR(root, allTree);
    }
    private List inorderTraversalR(BNode root, List allTree) {
        if (root == null) return allTree;
        inorderTraversalR(root.left, allTree);
        allTree.add(root.data);
        inorderTraversalR(root.right, allTree);
        return allTree;
    }


    /**
     * 中序遍历（非递归）
     */
    public List<Integer> inorderTraversal(BNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, root));
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
    public List postorderTraversalR(BNode root) {
        List allTree = new ArrayList();
        return postorderTraversalR(root, allTree);
    }
    private List postorderTraversalR(BNode root, List allTree) {
        if (root == null) return allTree;
        postorderTraversalR(root.left, allTree);
        postorderTraversalR(root.right, allTree);
        allTree.add(root.data);
        return allTree;
    }


    /**
     * 后序遍历（非递归）
     */
    public List<Integer> postorderTraversal(BNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<SFrame> funcStack = new Stack<>();
        funcStack.push(new SFrame(1, root));
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
    public List<Integer> levelOrderLR(BNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BNode> storeQueue = new LinkedList<>();
        storeQueue.add(root);
        while (!storeQueue.isEmpty()) {
            BNode pollNode = storeQueue.poll();
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
    public List<List<Integer>> levelOrderLR2(BNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BNode> storeQueue = new LinkedList<>();
        storeQueue.offer(root);
        while (!storeQueue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int queueSize = storeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                BNode pollNode = storeQueue.poll();
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
    public List<Integer> levelOrderRL(BNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BNode> storeQueue = new LinkedList<>();
        storeQueue.add(root);
        while (!storeQueue.isEmpty()) {
            BNode pollNode = storeQueue.poll();
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
    public List<List<Integer>> levelOrderRL2(BNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BNode> storeQueue = new LinkedList<>();
        storeQueue.offer(root);
        while (!storeQueue.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<>();
            int sizeOfCurrLevel = storeQueue.size();
            for (int i = 0; i < sizeOfCurrLevel; i++) {
                BNode pollNode = storeQueue.poll();
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
//    public List<Integer> levelOrderZ(BNode root) {
//
//    }


    /**
     * 层序遍历（Z字蛇形打印）（按层分组输出）
     */
    public List<List<Integer>> levelOrderZ2(BNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        int turn = 0;
        Stack<BNode>[] storeStacks = new Stack[]{new Stack<BNode>(), new Stack<BNode>()};
        storeStacks[turn].push(root);
        while (!storeStacks[turn].isEmpty()) {
            int currLevelSize = storeStacks[turn].size();
            List<Integer> currLevelResult = new ArrayList<>();
            for (int i = 0; i < currLevelSize; i++) {
                BNode popNode = storeStacks[turn].pop();
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



    /**
     * 求二叉树的最大深度
     */
    public int maxDepth(BNode root) {
        return maxDepthR(root);
    }
    private int maxDepthR(BNode root) {
        if (root == null) return 0;
        int maxDepthLeft = maxDepthR(root.left);
        int maxDepthRight = maxDepthR(root.right);
        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }


    /**
     * 判断二叉树是否是平衡二叉树
     */
    private boolean isBalanced = true;
    public boolean isBalancedTree(BNode root) {
        heightR(root);
        return isBalanced;
    }
    private int heightR(BNode root) {
        if (root == null) return 0;
        if (isBalanced == false) return 0;
        int depthL = heightR(root.left);
        int depthR = heightR(root.right);
        if (Math.abs(depthL - depthR) > 1)
            isBalanced = false;
        return Math.max(depthL, depthR) + 1;
    }


    /**
     * 合并二叉树
       "错误解法"：
     */
//    public BNode mergeTrees(BNode root1, BNode root2) {
//        mergeTreesR(root1, root2);
//        return root2;
//    }
//    private void mergeTreesR(BNode root1, BNode root2) {
//        if (root1 == null && root2 == null) return;
//        if (root2 == null)
//            root2 = new BNode(root1.data);
//        else
//            root2.data += (root1 != null ? root1.data : 0);
//        mergeTreesR(root1.left, root2.left);
//        mergeTreesR(root1.right, root2.right);
//    }


    /**
     * 合并二叉树（创建新树）
     * 解法：递归创建新节点
     * 特点：不破坏两个树的结构，返回一个新的树
     * 时间复杂度：o(n1 + n2)
     * 空间复杂度：o(n1 + n2)
     */
    public BNode mergeTrees(BNode root1, BNode root2) {
        // 递归终止条件
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // roo1 和 roo2 都是非空的情况
        BNode newTreeRoot  = new BNode(root1.data + root2.data);
        BNode newTreeLeft  = mergeTrees(root1.left, root2.left);
        BNode newTreeRight = mergeTrees(root1.right, root2.right);

        // 拼接newTree的左右子树
        newTreeRoot.left = newTreeLeft;
        newTreeRoot.right = newTreeRight;
        return newTreeRoot;
    }


    /**
     * 合并二叉树（将树1合并到树2上）【推荐】
     * 特点：破坏其中一个树的结构，但是无需创建新树
     * 时间复杂度：o(n1 + n2)
     * 空间复杂度：o[(log n1) + (log n2)]
     * 原地性：YES
     */
    public BNode mergeRoot1ToRoot2(BNode root1, BNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root2.data = root1.data + root2.data;
        root2.left = mergeRoot1ToRoot2(root1.left, root2.left);
        root2.right = mergeRoot1ToRoot2(root1.right, root2.right);
        return root2;
    }



    /**
     * 翻转二叉树（原地翻转）
     * 解法一：自己想出来的递归
     */
    public BNode invertTree(BNode root) {
        invertTreeR(root);
        return root;
    }
    private void invertTreeR(BNode root) {
        if (root == null) return;
        BNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeR(root.left);
        invertTreeR(root.right);
    }


    /**
     * 翻转二叉树（原地翻转）
     * 解法二：
     */
    public BNode invertTree2(BNode root) {
        if (root == null) return null;

        // 不能这样直接来
//        root.left = invertTree2(root.right);
//        root.right = invertTree2(root.left);

        BNode l = invertTree2(root.left);
        BNode r = invertTree2(root.right);
        root.left = r;
        root.right = l;
        return root;
    }


    /**
     * 翻转二叉树（创建新树）
     */
    public BNode invertTreeForNewTree(BNode root) {
        if (root == null) return null;
        BNode newTree = new BNode(root.data);
        newTree.left = invertTreeForNewTree(root.right);
        newTree.right = invertTreeForNewTree(root.left);
        return newTree;
    }



    /**
     * 判断是否为对称二叉树
     * 解法一（错误解法）：先中序遍历，再判断回文数组
     */
//    public boolean isSymmetric(BNode root) {
//        List<Integer> result = inorderTraversalR(root);
//        return isPalindromeArray(result);
//    }
//    public boolean isPalindromeArray(List<Integer> x) {
//        int i = 0;
//        int j = x.size() - 1;
//        while (i < j) {
//            if (x.get(i) != x.get(j)) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }


    /**
     * 判断是否为对称二叉树（判断两个树是否互为对称）
     * 解法二：递归判断
     */
    public boolean isSymmetric(BNode root) {
        if (root == null) return true;
        // 难点就在于把判断一个树是否为对称二叉树，转换为判断两个树是否互为对称这个问题！
        return isSymmetricR(root.left, root.right);
    }
    private boolean isSymmetricR(BNode p, BNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q != null && p.data == q.data)
            return (isSymmetricR(p.left, q.right) && isSymmetricR(p.right, q.left));
        else
            return false;
    }


    /**
     * 验证二叉搜索树
     * 解法一：错误解法
     */
//    public boolean isValidBST(BNode root) {
//        return isValidBSTR(root);
//    }
//    private boolean isValidBSTR(BNode root) {
//        if (root == null) return true;
//        boolean isValidBSTLeft = isValidBSTR(root.left);
//        if (isValidBSTLeft == false) return false;
//        boolean isValidBSTRight = isValidBSTR(root.right);
//        if (isValidBSTRight == false) return false;
//        boolean isValidBSTRoot;
//        if ((root.left == null || root.left.data < root.data) && (root.right == null || root.right.data > root.data))
//            isValidBSTRoot = true;
//        else
//            isValidBSTRoot = false;
//        if (isValidBSTRoot == false) return false;
//
//        if (isValidBSTLeft && isValidBSTRight && isValidBSTRoot)
//            return true;
//        else
//            return false;
//    }

//    public boolean isValidBST(BNode root) {
//
//    }
//    private boolean isValidBSTR(BNode root) {
//
//    }


    /**
     * 验证二叉树是否是BST**
     */
    private boolean isValid = true;
    public boolean isValidBST(BNode root) {
        if (root == null) return true;
        dfs(root);
        return isValid;
    }
    private int[] dfs(BNode root) {
        int max = root.data;
        int min = root.data;
        if (root.left != null) {
            int[] leftMinMax = dfs(root.left);
            if (isValid == false) return null;
            if (leftMinMax[1] >= root.data) {
                isValid = false;
                return null;
            }
            min = leftMinMax[0];
        }
        if (root.right != null) {
            int[] rightMinMax = dfs(root.right);
            if (isValid == false) return null;
            if (rightMinMax[0] <= root.data) {
                isValid = false;
                return null;
            }
            max = rightMinMax[1];
        }
        return new int[]{min, max};
    }


    /**
     * 将BST转换为累加树
     */
    private int sum = 0;
    public BNode convertBST2GST(BNode root) {
        inorderForSum(root);
        return root;
    }
    private void inorderForSum(BNode root) {
        if (root == null) return;
        inorderForSum(root.right);
        sum += root.data;
        root.data = sum;
        inorderForSum(root.left);
    }


    /**
     * 二叉树的最近公共祖先（LCA）
     * 解法一（王争）：求各分支包含p,q个数
     */
    private BNode lca;
    public BNode lowestCommonAncestor(BNode root, BNode p, BNode q) {
        lca = null;
//        dfsForLCA(root, p, q);
        dfsForLCA2(root, p, q);
        return lca;
    }
    private int dfsForLCA(BNode root, BNode p, BNode q) {
        if (root == null) return 0;

        int leftContains = dfsForLCA(root.left, p, q);
        if (lca != null) return 2;  // 提前退出

        int rightContains = dfsForLCA(root.right, p ,q);
        if (lca != null) return 2;  // 提前退出

        int rootContains = (root == p || root == q) ? 1 : 0;

        if (rootContains == 0 && (leftContains == 1 && rightContains == 1)) lca = root;
        if (rootContains == 1 && (leftContains == 1 || rightContains == 1)) lca = root;

        return leftContains + rightContains + rootContains;
    }

    /**
     * 二叉树的最近公共祖先（LCA）
     * 解法二（官方）：递归求各分支是否包含p，q
     （推荐）
     * ⚠️：加上三个提前退出条件，剪枝效率大幅度提高，力扣打破100%。
     */
    private boolean dfsForLCA2(BNode root, BNode p, BNode q) {
        if (root == null) return false;
        if (lca != null) return false;  // 提前退出（1）

        boolean leftContains = dfsForLCA2(root.left, p, q);
        if (lca != null) return false;  // 提前退出（2）

        boolean rightContains = dfsForLCA2(root.right, p, q);
        if (lca != null) return false;  // 提前退出（3）

        boolean rootContains = (root == p || root == q);

        if (leftContains && rightContains) lca = root;
        if ((leftContains || rightContains) && rootContains) lca = root;

        return leftContains || rightContains || rootContains;
    }


    /**
     * 将二叉树展开为链表（原地展开）（新链表的头节点即root节点）
     * 解法一：王争
     */
    private BNode tail = new BNode();
    private void preorderForFlatten(BNode root) {
        if (root == null) return;

        BNode left = root.left;
        BNode right = root.right;

        tail.right = root;
        tail = root;
        tail.left = null;


        preorderForFlatten(left);
        preorderForFlatten(right);
    }
    public void flatten(BNode root) {
        preorderForFlatten(root);
    }

    /**
     * 将二叉树展开为链表（原地展开）
     * 解法二：自己想出来的，返回尾节点
     */
    private BNode preorderForFlatten2(BNode root) {
        BNode leftHead = root.left;
        BNode rightHead = root.right;

        if (leftHead == null && rightHead == null) return root;

        BNode tail = root;
        if (leftHead != null) {
            root.right = leftHead;
            root.left = null;
            tail = preorderForFlatten2(leftHead);
        }
        if (rightHead != null) {
            tail.right = rightHead;
            tail.left = null;
            tail = preorderForFlatten2(rightHead);
        }
        return tail;
    }
    public void flatten2(BNode root) {
        if (root == null) return;
        flatten2(root);
    }


    /**
     * 特定深度节点链表（层序遍历）（非原地，新创建链表结构）
     */
    public ListNode[] listOfDepth(BNode root) {
        List<ListNode> result = new ArrayList<>();

        Queue<BNode> storeQueue = new LinkedList<>();
        storeQueue.offer(root);
        while (!storeQueue.isEmpty()) {
            ListNode head = new ListNode();
            ListNode curr = head;
            int currLevelSize = storeQueue.size();
            for (int i = 0; i < currLevelSize; i++) {
                BNode pollNode = storeQueue.poll();
                curr.next = new ListNode(pollNode.data);
                curr = curr.next;
                if (pollNode.left != null) storeQueue.offer(pollNode.left);
                if (pollNode.right != null) storeQueue.offer(pollNode.right);
            }
            result.add(head.next);
        }
        return result.toArray(new ListNode[result.size()]);
    }

}
