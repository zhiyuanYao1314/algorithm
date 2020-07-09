package byted;

/**
 * 二叉树的最近公共祖先
 *
 * 236
 * root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 */
public class Main7 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {


    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Info info = help(root,p,q);
        return info.common;
    }

    /**
     * hasP =
     *
     *
     */
    private Info help(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return new Info(false, false, null);
        Info leftInfo = help(root.left, p,q);
        Info rightInfo = help(root.right, p,q);
        boolean hasP = leftInfo.hasP || rightInfo.hasP || root.val == p.val;
        boolean hasQ = leftInfo.hasQ || rightInfo.hasQ || root.val == q.val;
        TreeNode common=null;
        if (leftInfo.common!=null){
            common = leftInfo.common;
        }
        if (rightInfo.common !=null)
            common =  rightInfo.common;
        if(hasP && hasQ)
            common = root;
        return new Info(hasP, hasQ, common);

    }

    private class Info{
        boolean hasP;
        boolean hasQ;
        TreeNode common;
        public  Info(boolean hasP, boolean hasQ, TreeNode common){
            this.hasP = hasP;
            this.hasQ = hasQ;
            this.common = common;
        }
    }








}
