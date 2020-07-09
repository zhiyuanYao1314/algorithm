package tree;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 16:02
 * Describe: 将二叉树的后续遍历改为 双向链表
 */
public class Main23 {

    public static void main(String[] args) {

    }

    public TreeNode doubleLink(TreeNode node){
        postTravel(node);
        return head;
    }
    TreeNode pre;
    TreeNode head;
    private void postTravel(TreeNode node) {
        if (node==null) return;
        postTravel(node.left);
        postTravel(node.right);
        node.left= pre;
        if (pre!= null) pre.right = node;
        else head = node;
        node = pre;
    }

}
