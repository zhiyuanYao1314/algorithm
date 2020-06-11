package A8TreeDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 16:49
 * Describe: 二叉树的路径和等于给定数
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 * A valid path is from root node to any of the leaf nodes.
 */
public class A2 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        t0.left = t1;
        t0.right= t2;
        t1.left = t3;
        t1.right = t4;
        A2 main24 = new A2();
        List<List<Integer>> lists = main24.pathNum(t0, 5);
        for (List l: lists){
            System.out.println(l);
        }
    }

    public List<List<Integer>> pathNum(TreeNode node, int sum){
        if (node ==null) return ans;
        help(node,sum, new ArrayList<>());
        return ans;
    }
    ArrayList<List<Integer>> ans = new ArrayList<>();
    private void help(TreeNode node, int sum, ArrayList<Integer> list) {
        sum -= node.val;
        list.add(node.val);
        // 叶子节点且sum为给定值
        if ( node.left==null && node.right==null  && sum ==0) {
            ans.add(list);
            return;
        }
        // 叶子节点或者sum给定值，不同时满足
        if (node.left==null && node.right==null) return;
        if (node.left!= null){
            ArrayList<Integer> newList1 = (ArrayList<Integer>) list.clone();
            help(node.left,sum, newList1);
        }
        if (node.right!= null){
            ArrayList<Integer> newList2 = (ArrayList<Integer>) list.clone();
            help(node.right, sum,newList2);
        }
    }
}
