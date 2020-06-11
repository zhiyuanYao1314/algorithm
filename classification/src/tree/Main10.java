package tree;

/**
 * 求树的镜像
 */
public class Main10 {
    public static void main(String[] args) {

    }
    public void Mirror(TreeNode root) {
        if (root==null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
