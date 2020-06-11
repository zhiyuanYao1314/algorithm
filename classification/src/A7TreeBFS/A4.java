package A7TreeBFS;

import java.util.*;
/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 16:21
 */
public class A4 {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        List<Integer> ans = new LinkedList<>();
        while (!q.isEmpty()){
            TreeNode cur = q.removeFirst();

            ans.add(cur.val);
            if (cur.left!=null)
                q.addLast(cur.left);
            if (cur.right!=null)
                q.addLast(cur.right);
        }
        int[] ret = new int[ans.size()];
        for (int i=0;i<ans.size();i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
