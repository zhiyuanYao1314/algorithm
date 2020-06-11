package A7TreeBFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 1:22
 * 二叉树层序遍历
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){
        this.val = val;
    }
}
public class A1 {
    public ArrayList<Integer> travel(TreeNode node){
        if (node==null ) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        ArrayList<Integer> ans = new ArrayList();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            ans.add(cur.val);
            if (cur.left!=null) queue.add(cur.left);
            if (cur.right!=null) queue.add(cur.right);
        }
        return ans;
    }

}
