package byted;

/**
 * 111. 二叉树的最小深度；
 */
public class Main60 {

    public int minDepth(TreeNode root) {
        if (root ==null)
            return 0;
        if (root.left==null && root.right==null)
            return 1;
        int min =Short.MAX_VALUE;
        if (root.left!=null){
            min = minDepth(root.left);
        }
        if (root.right!=null)
            min = Math.min(min, minDepth(root.right));
        return min+1;
    }
}
