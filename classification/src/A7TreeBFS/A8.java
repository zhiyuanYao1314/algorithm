package A7TreeBFS;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 15:03
 * 二叉树的最大宽度
 */
public class A8 {
    int maxWidth(TreeNode node){
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(node);
        int max =0;
        while (!q.isEmpty()){
            int size = q.size();
            if (size>max) max = size;
            for (int i=0;i<size;i++){
                TreeNode cur = q.removeFirst();
                if (cur.left!=null){
                    q.addLast(cur.left);
                }
                if (cur.right!=null){
                    q.addLast(cur.right);
                }
            }
        }
        return max;
    }

    // 记录每一层的最右边的节点
    // 每次到达最右边的节点的时候换一层！
    int maxWidth2(TreeNode node){
        if (node==null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(node);
        int max = 0;
        int len = 0;
        TreeNode cur = null;
        // 记录当前层和下一层的最有节点
        TreeNode rightest = node;
        TreeNode nextRighest = null;

        while (!q.isEmpty()){
            cur = q.removeFirst();
            if (cur.left!=null){
                q.addLast(cur.left);
                nextRighest = cur.left;
            }
            if (cur.right!=null){
                q.addLast(cur.right);
                nextRighest = cur.right;
            }
            len++;
            if (cur==rightest){
                // 更新max
                max = Math.max(max,len);
                // 更新新层的len
                len =0;
                // 更新最有节点
                rightest = nextRighest;
            }
        }
        return max;
    }
}