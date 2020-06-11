package A8TreeDFS;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/15 17:16
 * 合并两颗二叉树
 * 两颗二叉树合并， 如果有一棵树没有元素，则另一颗作为当前点
 */
public class A15 {
    public static void main(String[] args) {

    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1==null) return t2;
        if (t2==null) return t1;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        TreeNode cur = new TreeNode(t1.val + t2.val);
        cur.left = left;
        cur.right = right;
        return cur;
    }

    // 递归 迭代
    TreeNode mergeTrees2(TreeNode t1, TreeNode t2){
        Stack<TreeNode[]> stack = new Stack();
        if (t1==null) return t2;
        TreeNode[] treeNodes = {t1, t2};
        stack.push(treeNodes);
        while (!stack.isEmpty()){
            TreeNode[] nodes = stack.pop();
            if (nodes[1]!=null) nodes[0].val +=nodes[1].val;
            else continue;
            if (nodes[0].left != null)
                stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
            else nodes[0].left = nodes[1].left; // 没必要再继续下去了
            if (nodes[0].right!=null)
                stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            else nodes[0].right = nodes[1].right;
        }
        return t1;
    }

}
