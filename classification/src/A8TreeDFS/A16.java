package A8TreeDFS;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 16:09
 * LC99 恢复二叉搜索树
 *  难点在取出x, y  需要两次，然后y切换，x不切换；
 */
public class A16 {
    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(x, y);
    }
    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
    TreeNode x, y, pre= new TreeNode(Integer.MIN_VALUE);
    public void dfs(TreeNode node){ //找到x, y 表示右边的节点；
        if (node==null) return;
        dfs(node.left);
        // 中序遍历；
        if (node.val<pre.val){ // 错误点 node, pre
            // 出现一次；
            y = node;
            if (x==null) x = pre;
            else return;
        }
        pre = node;
        dfs(node.right);
    }
}