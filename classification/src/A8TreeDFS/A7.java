package A8TreeDFS;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 20:58
 * 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class A7 {
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        preOrder(root,0);
        return ans;
    }

    int ans;
    void preOrder(TreeNode node, int num){
        num = num*10+node.val;
        if (node.left==null && node.right==null){ // 路径和
            ans += num;
        }
        if (node.left!=null){
            preOrder(node.left, num);
        }
        if (node.right!=null){
            preOrder(node.right, num);
        }

    }

}
