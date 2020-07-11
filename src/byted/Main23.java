package byted;

/**
 * 226 反转二叉树
 */
public class Main23 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
