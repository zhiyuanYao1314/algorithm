import sun.reflect.generics.tree.Tree;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 11:25
 * Describe:
 * version:1.0
 */
public class Eight {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val){
            this.val = val;
        }
    }

    /**
     * 1. 如果有右子树，那么右子树的最左节点就是下一个
     * 2. 没有右子树，如果没有父节点，return null
     * 3. 有父节点，当前节点是父节点的子节点，return 父
     * 4. 当前节点不是父节点的子节点，继续找父节点。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode.right != null){
            TreeLinkNode root = pNode.right;
            while (root.left != null){
                root = root.left;
            }
            return root;
        }else {
            while (pNode.next!= null){
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

}
