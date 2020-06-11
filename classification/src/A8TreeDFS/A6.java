package A8TreeDFS;

import sun.reflect.generics.tree.Tree;

import java.util.SortedMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 18:57
 * 二叉树的最大路径和
 *给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *  -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 */
public class A6 {
    public static void main(String[] args) {
        A6 a6 = new A6();
        TreeNode treeNode = new TreeNode(-2);
        int i = a6.maxPathSum(treeNode);
        System.out.println(i);
    }

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max; //34
    }
    int MIN = -999999999;
    int max = MIN;
    public int postOrder(TreeNode node){
        if (node==null) return MIN;
        int left = MIN, right =MIN;
        if (node.left!=null){
            left = postOrder(node.left);
        }
        if (node.right!=null){
            right = postOrder(node.right);
        }
        int ret = Math.max(Math.max(left+node.val,right+node.val),node.val);// return 数必须包含当前节点
        // max ret left, right, left+right+node.val
        max =Math.max(ret, Math.max(node.val+left+right,max));
        return ret;
    }

}
