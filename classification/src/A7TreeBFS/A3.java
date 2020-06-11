package A7TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 23:39
 * 二叉树层的平均数
 */
public class A3 {
    public static void main(String[] args) {
    }
    /**
     * levelOrder
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if (root==null) return ans;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int tmp =size;
            long sum =0;
            while (size-->0){
                TreeNode cur = queue.poll();
                sum +=cur.val;
                if (cur.left!=null) queue.add(cur.left);
                if (cur.right!=null) queue.add(cur.right);
            }
            double avg = ((double)sum)/tmp;
            ans.add(avg);
        }
        return ans;
    }


}
