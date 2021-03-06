package datastructure.tree;

public class BST {

    private BNode root;

    public BST() {this.root = null;}

    public BST(int data) {this.root = new BNode(data);}

    public BNode getMe() {return this.root;}

    /**
     * BST搜索target（循环实现）
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     */
    public BNode search(int target) {
        BNode curr = this.root;
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
    public BNode searchR(int target) {
        BNode root = this.root;
        return searchR(root,target);
    }
    private BNode searchR(BNode root, int target) {
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
            this.root = new BNode(target);
            return;
        }
        BNode curr = this.root;
        while (curr != null) {
            if (target >= curr.data) {
                if (curr.right == null) {
                    curr.right = new BNode(target);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new BNode(target);
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
            this.root = new BNode(target);
            return;
        }
        insertR(this.root, target);
    }
    private void insertR(BNode root, int target) {
        if (target > root.data) {
            if (root.right == null) {
                root.right = new BNode(target);
                return;
            } else {
                insertR(root.right, target);
            }
        } else {
            if (root.left == null) {
                root.left = new BNode(target);
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
        BNode father = null;
        BNode curr = this.root;

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
            BNode minFather = curr;
            BNode minNode = curr.right;
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
        BNode child = null;
        if (curr.left != null) child = curr.left;
        else child = curr.right;

        if (father == null) root = child;   // 要删除待节点是跟节点
        else if (father.left == curr) father.left = child;
        else father.right = child;

    }


    // ====================================================
    // == BST的操作一般利用："中序遍历即从小到大顺序输出" 这一特性 ==
    // ====================================================

    /**
     * 获取BST第K大节点
     * 解法：中序遍历（右中左）
     */
    private int count = 0;
    private BNode result;
    public BNode kthLargest(int k) {
        inorderRL(this.root, k);
        return result;
    }
    private void inorderRL(BNode root, int k) {
        if (count >= k) return;
        if (root == null) return;
        inorderRL(root.right, k);
        count++;
        if (count == k) {
            result = root;
            return;
        }
        inorderRL(root.left, k);
    }


    /**
     * 获取BST第K小节点
     * 解法：中序遍历（左中右）
     */
    public BNode kthMinimal(int k) {
        inorderLR(this.root, k);
        return result;
    }
    private void inorderLR(BNode root, int k) {
        if (root == null) return;
        if (count == k) return;
        inorderLR(root.left, k);
        count++;
        if (count == k) {
            result = root;
            return;
        }
        inorderLR(root.right, k);
    }



    /**
     * 获取BST中指定节点的中序后继节点
     */
    private BNode successor;
    private boolean coming = false;
    public BNode inorderSuccessor(BNode p) {
        inorderSuccessorR(this.root, p);
        return successor;
    }
    private void inorderSuccessorR(BNode root, BNode p) {
        if (root == null) return;
        inorderSuccessorR(root.left, p);
        if (successor != null) return;
        if (coming == true) {
            successor = root;
            return;
        }
        if (p == root) coming = true;
        inorderSuccessorR(root.right, p);
    }


    /**
     * BST中指定两个节点的最近公共祖先（BST-LCA）
     */
    private BNode lcaBST;
    private void inorderForLCA(BNode root, int p, int q) {
        if (root == null) return;
        if (lcaBST != null) return;
        inorderForLCA(root.left, p, q);
        if ((root.data >= p && root.data <= q) || (root.data <= p && root.data >= q))
            lcaBST = root;
        if (lcaBST != null) return;
        inorderForLCA(root.right, p, q);
    }
    public BNode lowestCommonAncestor(int p, int q) {
        lcaBST = null;
        inorderForLCA(this.root, p, q);
        return lcaBST;
    }


    /**
     * 将BST展开为单链表（原地转换）
       ⚠️：返回新链表的头节点并非root节点！
     * 解法一：原地中序遍历处理
     */
    private BNode dummyHead = new BNode();
    private BNode tail = dummyHead;

    private void inorderForC2L(BNode root) {
        if (root == null) return;

        BNode left = root.left;
        BNode right = root.right;

        inorderForC2L(left);

        tail.right = root;
        tail = root;
        tail.left = null;

        inorderForC2L(right);
    }
    public BNode convert2List() {
        inorderForC2L(this.root);
        return dummyHead.right;
    }


    /**
     * 将BST转换为双向循环链表（原地转换）
     */
    private BNode inorderForC2DL(BNode root) {
        BNode leftHead = root.left;
        BNode rightHead = root.right;

        if (leftHead == null) {
            if (dummyHead != null) dummyHead = root;
            return root;
        }

        tail = inorderForC2DL(leftHead);

        tail.right = root;
        tail.left = null;
        tail = root;

        if (rightHead != null) {
            tail.right = rightHead;
            tail.left = null;
            tail = inorderForC2DL(rightHead);
        }
        return tail;
    }
    public BNode convert2DoublyList() {
        if (root == null) return null;
        tail = inorderForC2DL(this.root);
        tail.right = dummyHead.right;
        dummyHead.right.left = tail;
        return dummyHead.right;
    }

}
