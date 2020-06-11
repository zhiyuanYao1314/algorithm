package A7TreeBFS;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 17:03
 * 二叉树的最小深度
 */

public class A5 {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        Deque<TreeNode> q = new ArrayDeque();
        q.addLast(root);
        int count =0;
        while (!q.isEmpty()){
            count++;
            int size = q.size();
            for (int i=0;i<size;i++){
                TreeNode cur = q.removeFirst();
                if (cur.left==null && cur.right==null)
                    return count;
                if (cur.left!=null){
                    q.addLast(cur.left);
                }
                if (cur.right!=null){
                    q.addLast(cur.right);
                }
            }
        }
        return count;
    }
}