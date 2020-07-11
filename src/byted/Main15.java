package byted;

/**
 * 124 二叉树中的最大路径和
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    42
 */
public class Main15 {

    // -3
    public int maxPathSum(TreeNode root) {
        return help(root).max;
    }

    public Info help(TreeNode root){
        if (root==null)
            return new Info(Short.MIN_VALUE,Short.MIN_VALUE);
        Info lInfo = help(root.left);
        Info rInfo = help(root.right);
        int h =Math.max(Math.max(lInfo.height, rInfo.height)+root.val, root.val);
        int max = Math.max(Math.max(lInfo.max, rInfo.max),Math.max(h, lInfo.height+rInfo.height+root.val));
        max = Math.max(max, root.val);
        return new Info(max, h);
    }

    class Info{
        int max;
        int height;
        Info(int max, int height){
            this.max = max;
            this.height = height;
        }
    }
}
/**
 * [1,-2,-3,1,3,-2,null,-1]
 *       1
 *    -2   -3
 *   1   3  -2  n
 * -1
 *
 */
