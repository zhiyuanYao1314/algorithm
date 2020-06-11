package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Main14 {
    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null) return ans;
        find(root, target,list);
        ArrayList<Integer>[] re = new ArrayList[ans.size()];
        int i=0;
        for (ArrayList<Integer> e: ans){
            re[i++] = e;
        }
        Arrays.sort(re, (o1,o2)->(o2.size()-o1.size()));
        ans = new ArrayList<>();
        for (ArrayList<Integer> e: re){
            ans.add(e);
        }
        return ans;
    }

    void find(TreeNode root, int target, ArrayList list){
        // 叶节点并且等于target
        int newTarget = target-root.val;
        list.add(root.val);
        if (newTarget==0 && root.left==null && root.right==null)
            ans.add(list);
        ArrayList<Integer> left = (ArrayList<Integer>) list.clone();
        ArrayList<Integer> right =(ArrayList<Integer>) list.clone();
        if (root.left !=null)
            find(root.left,newTarget, left);
        if (root.right!=null)
            find(root.right,newTarget, right);
    }
}
