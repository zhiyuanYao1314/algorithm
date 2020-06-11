package recursion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 15:47
 * 搜索二叉树转成升序的双向链表
 * 指定一个pre和head， 中序遍历，修改pre.right = node, node.right = null; node.left = pre; pre = node;
 */
public class Main3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    TreeNode pre = null;
    TreeNode head = null;
    TreeNode reverseToLink(TreeNode node){
        if (node==null) return null;
        reverseToLink(node.left);

        if (pre!= null)
            pre.right = node;
        if (head==null)
            head=node;
        node.left = pre;
        node.right = null;
        node =pre;
        reverseToLink(node.right);
        return head;
    }
}
