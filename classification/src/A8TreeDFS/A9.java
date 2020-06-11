package A8TreeDFS;

import sun.security.x509.IssuerAlternativeNameExtension;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 21:40
 * 二叉搜索树的插入操作
 *
 *
 */
public class A9 {

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        if (val>root.val) root.right = insertIntoBST2(root.right, val);
        else root.left = insertIntoBST2(root.left,val);
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        TreeNode newRoot = copy(root);
        insert(newRoot, val);
        return newRoot;
    }

    /**
     * 为什么要在当层处理呢？
     */
    private void insert(TreeNode root, int val) {
        if (val<root.val && root.left==null) {
            TreeNode child = new TreeNode(val);
            root.left = child;
            return;
        }
        if (val>=root.val && root.right==null){
            TreeNode child = new TreeNode(val);
            root.right = child;
            return;
        }
        if (val<root.val){
            insert(root.left, val);
        }else {
            insert(root.right, val);
        }
    }

    public TreeNode copy(TreeNode root){
        if (root==null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copy(root.left);
        newRoot.right = copy(root.right);
        return newRoot;
    }

}
