package A8TreeDFS.Inorder;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/29 11:37
 * 给定一个节点，求它的后继节点，每个节点都含有父指针！
 */
public class A2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode father;
    }
    public TreeNode inorderSuccessor(TreeNode node) {
        if (node==null)return null;
        // 1. 如果有右子树，则是右子树的最左节点
        if (node.right!=null){
            TreeNode cur = node.right;
            while (cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }
        // 没有右子树
        // 2. 父节点 ，直到父节点为空或者自己是父节点的左儿子；
        while (node.father!=null && node.father.right==node){// 退出条件：
            node = node.father;
        }
        return node.father==null?null: node.father;
    }
}
