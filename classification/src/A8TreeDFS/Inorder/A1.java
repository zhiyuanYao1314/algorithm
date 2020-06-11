package A8TreeDFS.Inorder;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/29 11:02
 *
 * 给定一个节点和它的根节点，求后继节点
 */
class A1 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    // 对于TreeNode中记录自己父节点的解法
    // 1. 如果有右子树，则是右子树的最左节点
    // 2. 父节点 ，直到父节点为空或者自己是父节点的左儿子；
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return ans;
    }

    TreeNode ans;
    boolean isNext = false;
    public void inorder(TreeNode root, TreeNode p){
        if (root==null) return;
        inorder(root.left, p);
        if(isNext){
            isNext = false;
            ans = root;
        }
        if (root==p){
            isNext = true;
        }
        inorderSuccessor(root.right,p);
    }
}
