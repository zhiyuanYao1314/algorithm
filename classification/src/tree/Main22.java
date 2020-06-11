package tree;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 15:54
 * Describe:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Main22 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    TreeNode pre ;
    TreeNode head;
    private void inOrder(TreeNode node) {
        if (node ==null) return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null) pre.right= node;
        else head= node; // 记录头节点。
        node = pre;
        inOrder(node.right);
    }


}
