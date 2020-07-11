package byted;


/**
 * 二叉树的in遍历
 */
public class Main13 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    void in(TreeNode node){
        if (node ==null)
            return;
        in(node.left);
        System.out.print(node.val);
        in(node.right);
    }
}
