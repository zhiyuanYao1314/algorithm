package tree;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(Integer val){
        this.val=val;
    }

}

class BTreeNode{
    int val;
    BTreeNode[] children;
}

public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.left = node4;
        node3.right = node5;
        main1.stackMidDFS(node1);
    }

    Queue<TreeNode> queue = new LinkedList();

    /**
     * 1. 层序遍历： queue
     */
    public void level(TreeNode node) {
        TreeNode root = node;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }

    /**
     * 2. 先序pre遍历: 递归
     * 中序mid后序follow类似
     */
    public void pre(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    /**
     * stack做前序遍历
     * @param node
     */
    public void stackPreDFS(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) return;
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right!=null) stack.push(cur.left);
            if (cur.left!= null) stack.push(cur.right);
        }
    }

    /**
     * stack做中序遍历
     * stack, 只有有左子树，就一直放，
     * 没有了，就取出来。。。
     */
    public void stackMidDFS(TreeNode node){
        Stack<TreeNode> stack = new Stack();
        if (node==null) return;
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (cur.left != null){
                stack.push(cur.left);
                cur.left = null;
            }else {
                TreeNode p = stack.pop();
                System.out.println(p.val);
                if (p.right!=null){
                    stack.push(p.right);
                }
            }
        }
    }

    // 3. 求高度
    public int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 3. 求B树的高度
    public int Bheight(BTreeNode node) {
        if (node == null) return 0;
        BTreeNode[] children = node.children;
        // 取所有儿子中的最大值
        int max = 0;
        for (BTreeNode n : children) {
            if (max < Bheight(n) + 1) {
                max = Bheight(n) + 1;
            }
            ;
        }
        return max;
    }

    /**
     * 4. 二叉树搜索， 找到返回true， 没有返回false;
     */
    public boolean search(TreeNode node, int target){
        if (node == null) return false;
        if (node.val == target) return true;
        if (node.val>target) return search(node.left, target);
        else return search(node.right, target);
    }

    /**
     * 5. 在搜索二叉树中 找到离target最接近的值。
     */
    public double nearest(TreeNode node,int target){
        double min = Double.MAX_VALUE;
        while (node != null){
            int val = node.val;
            if (Math.abs(val-target)<min){
                min = Math.abs(val-target);
            }
            if (target>val){
                node =node.right;
            }else if (target<val){
                node = node.left;
            }else {
                return 0;
            }
        }
        return min;
    }

    /**
     * 6. 给定一个二叉树中一个node，
     * 返回中序遍历中，该点的下一个节点。
     * 节点node中有含有父节点 parent
     * 没有，返回null
     */
    public TreeNode midNext(TreeNode node, int target){
        if (node == null) return null;
        // 如果有右子树，一直找到最左点
        TreeNode right = node.right;
        if (right != null){
            // TreeNode cur =
            while (right.left!= null){
                right = right.left;
            }
            return right;
        }
        // 一直找父节点， 直到找到当前节点是父节点的左节点。
        if (node.parent != null){
            if (node.parent.left== node){
                return node.parent;
            }else {
                node = node.parent;
            }
        }
        return null;
    }




}
