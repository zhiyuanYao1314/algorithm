package byted;

/**
 *
 * 814
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * 确保自身和子树全是0 才能剪切
 */
public class Main53 {

    public TreeNode pruneTree(TreeNode root) {
        if (isOnly0(root))
            return null;
        return root;
    }

    public boolean isOnly0(TreeNode root){
        if (root==null)
            return true;
        boolean left = isOnly0(root.left);
        boolean right = isOnly0(root.right);
        if (left)
            root.left=null;
        if (right)
            root.right = null;
        if (left && right && root.val==0)
            return true;
        return false;
    }
}
