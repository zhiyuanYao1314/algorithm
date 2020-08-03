package Shopee;

public class Main1 {
    public static void main(String[] args) {

    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    // 判断对称二叉树
    boolean isSym(TreeNode root){
        if (root==null)
            return true;
        if (root.left==null && root.right==null)
            return true;
        if (root.left==null || root.right==null)
            return false;
        boolean leftIs = isSym(root.left);
        boolean rightIs = isSym(root.right);
        if (leftIs && rightIs && root.left.val==root.right.val){
            return true;
        }else {
            return false;
        }
    }
}