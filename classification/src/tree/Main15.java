package tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

public class Main15 {

    public static void main(String[] args) {

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    private TreeNode head;
    private TreeNode pre;
    public void inOrder(TreeNode node){
        if (node ==null) return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null) pre.right=node;
        pre = node;
        if (head==null) head=node;
        inOrder(node.right);
    }
}
