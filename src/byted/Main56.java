package byted;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 515 在每个树行中找最大值
 *输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 */
public class Main56 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root==null)
            return ret;
        Deque<TreeNode> queue = new ArrayDeque();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int sz = queue.size();
            int max=Integer.MIN_VALUE;
            for (int i=0;i<sz;i++){
                TreeNode cur = queue.pollFirst();
                max = Math.max(max, cur.val);
                if (cur.left!=null)
                    queue.addLast(cur.left);
                if (cur.right!=null)
                    queue.addLast(cur.right);
            }
            ret.add(max);
        }
        return ret;
    }
}
