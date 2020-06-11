package tree;


/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Main3 {

    /**
     * 如果有右子树，一直找右子树的左子树叶子节点
     * 没有右子树，找父节点，直到它是父节点的左儿子。
     * 否则 return null;
     */
    public TreeNode GetNext(TreeNode pNode) {
        if (pNode.right != null){
            TreeNode root = pNode.right;
            while (root.left != null){
                root = root.left;
            }
            return root;
        }else {
            while (pNode.parent!= null){
                TreeNode parent = pNode.parent;
                if (parent.left == pNode){
                    return parent;
                }
                pNode = pNode.parent;
            }
        }
        return null;
    }
}
