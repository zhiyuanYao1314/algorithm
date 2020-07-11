package byted;

import java.util.ArrayList;
import java.util.List;

/**
 * 113 路径总和II
 * 典型的回溯算法 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * [1,-2,-3,1,3,-2,null,-1]
 *
 *           1
 *        -2   -3
 *      1   3  -2 n
 *     -1
 *
 *
 */
public class Main28 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)
            return ans;
        help(root, new ArrayList<>(),0, sum);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 每一层做决定；
     * 如果该层有多个决定，则每做完一次决定，下传回来后都应该撤销；
     * 如果该层只选择一个值，下传到不同路径后，也应该进行撤销。
     */
    void help(TreeNode node, List<Integer> path,int total, int sum){
        path.add(node.val);
        total += node.val;
        if (node.right==null && node.left==null){
            if(total ==sum){
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size()-1);
            total -= node.val;
            return;
        }
        if (node.left!=null){
            help(node.left, path,total, sum);
        }
        if (node.right!=null){
            help(node.right, path,total, sum);
        }
        path.remove(path.size()-1);
        total -= node.val;
    }
}