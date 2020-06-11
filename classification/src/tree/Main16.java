package tree;

import sun.reflect.generics.tree.Tree;

/**
 * Time:2020/4/21 23:45
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class Main16 {

    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
