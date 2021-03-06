package datastructure;


/**
 * 二叉树
 */
public class Solution9 {

    /**
     *【9-1】二叉树前中后序遍历
     */

    // 9-1.1 二叉树前序遍历 {力扣-144}

    // 9-1.2 二叉树中序遍历 {力扣-94}

    // 9-1.3 二叉树后序遍历 {力扣-145}

    // 9-1.4 N叉树前序遍历 {力扣-589}

    // 9-1.5 N叉树后续遍历 {力扣-590}




    /**
     *【9-2】二叉树按层遍历
     */

    // 9-2.1 从上到下打印二叉树（顺序输出） {剑指Offer32-I}
    /*
    解法：同BST层序遍历（连续输出）
     */


    // 9-2.2 二叉树的层序遍历（按层分组输出） {力扣102} {剑指Offer32-II}
    /*
    解法一：同BST层序遍历（按层分组输出），统计每层个数。
    解法二：每层结束向storeQueue里面插入null作为每层的分界点。
     */


    // 9-2.3 从上到下打印二叉树III（之字形打印） {剑指Offer32-III}
    /*
    解法一：同BST按层遍历（Z字蛇形打印）
    解法二：先按层打印，对二维数组位置是单数的数组再执行反转数组操作。
    解法三：
     */


    // 9-2.4 N叉树的层序遍历 {力扣429}
    /*
    解法：同N叉树层序遍历（从左至右）（按层分组输出）
     */


    // 9-2.5 找树左下角的值 {力扣513}
    /*
    （1）思路同【BST按层遍历（从右到左）（顺序输出）】
    （2）取遍历的最后一个元素，就是该树左下角的值
     */


    // 9-2.6 找树右下角的值 {力扣513}
    /*
    （1）思路同【BST按层遍历（从左到右）（顺序输出）】
    （2）取遍历的最后一个元素，就是该树右下角的值
     */


    // 9-2.7 二叉树的右侧视图 {剑指Offer II 046}
    /*
    （1）思路同【BST按层遍历（从右至左）（按层分组输出）】
    （2）只存储每一层（从右至左遍历）第一个元素
     */



    /**
     *【9-3】二叉树上的递归
     */

    // 9-3.1 二叉树最大深度 {力扣-104}
    /*
        见 BTUtils.maxDepth
     */


    // 9-3.2 N叉树最大深度 {力扣-559}
    /*
        见 NTUtils.maxDepth
     */


    // 9-3.3 判断是否为平衡二叉树 {剑指offer55-II}
    /*
        见 BTUtils.isBalancedTree
     */


    // 9-3.4 合并二叉树 {力扣-617}
    /*
        见 BTUtils.mergeTrees
     */


    // 9-3.5 翻转二叉树 {力扣-226}
    /*
        见 BTUtils.invertTree
     */


    // 9-3.6 对称二叉树 {力扣-101}
    /*
        见 BTUtils.isSymmetric
     */


    // 9-3.7 验证二叉搜索树 {力扣-98}
    /*
        见 BTUtils.isValidBST
     */




    /**
     *【9-4】二叉查找树BST
       利用BST中序遍历结果从小到大的特性
     */

    // 9-4.1 二叉搜索树的第K大节点 {剑指Offer54}
    /*
        见 BST.kthLargest
     */


    // 9-4.2 把二叉搜索树转换为累加树 {力扣-538} {力扣-1038}
    /*
        见 BTUtils.invertBST2AccT
     */


    // 9-4.3 后继者 {面试题金典-04.06}
    /*
        见 BST.inorderSuccessor
     */




    /**
     *【9-5】LCA最近公共祖先
     */

    // 9-5.1 二叉树的最近公共祖先 {力扣-236}
    /*
        见 BTUtils.lowestCommonAncestor
     */


    // 9-5.2 BST的最近公共祖先 {剑指Offer 68-I}
    /*
        见 BST.lowestCommonAncestor
     */




    /**
     *【9-6】二叉树转单、双、循环链表
     */

    // 9-6.1 二叉树展开为链表 {力扣-114}
    /*
        方法一：BTUtils.flatten
        方法二：BTUtils.flatten2
     */


    // 9-6.2 BiNode {面试题金典 7.12.}
    /*
        见：BST.
     */


    // 9-6.3 二叉搜索树与双向链表 {剑指Offer 36}


    // 9-6.4 特定深度节点链表 {面试题金典 04.03.}
    /*
        见 BTUtils.listOfDepth
     */




    /**
     *【9-7】按照遍历结果反向构建二叉树
     */

    // 9-7.1 从前序与中序遍历序列构造二叉树 {力扣-105}


    // 9-7.2 根据前序与后序遍历序列构造二叉树 {力扣-889}


    // 9-7.3 从中序与后序遍历序列构造二叉树 {力扣-106}


    // 9-7.4 二叉搜索树的后序遍历序列 {剑指Offer-33}



    /**
     *【9-8】二叉树上的最长路径和
     */

    // 9-8.1 二叉树的直径 {力扣-543}


    // 9-8.2 二叉树中和为某一值的路径 {剑指Offer-34}


    // 9-8.3 二叉树中的最大路径和** {力扣-124}


    // 9-8.4 路径总和III** {力扣-437}

}
