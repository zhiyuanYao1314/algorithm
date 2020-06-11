package A7TreeBFS;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/20 14:30
 *  LC103. 二叉树的锯齿形层次遍历
 */
public class A6 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList();
        boolean isLeftToRight = true;
        if (root==null) return ans;
        Deque<TreeNode> q = new ArrayDeque();
        q.addLast(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> row = new LinkedList();
            for (int i=0;i<sz;i++){
                TreeNode cur = q.removeFirst();
                row.add(cur.val);
                if (cur.left!=null){
                    q.addLast(cur.left);
                }
                if(cur.right!=null){
                    q.addLast(cur.right);
                }
            }
            if (!isLeftToRight){
                //Collections.reverse
                Collections.reverse(row);
            }
            isLeftToRight= !isLeftToRight;
            ans.add(row);
        }
        return ans;
    }
}
