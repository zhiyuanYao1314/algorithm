package A8TreeDFS;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sort.Main;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 17:52
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 *           return 3;
 */
public class A5 {

    /**
     * 方法2：使用后续遍历 DP的味道
     */
    public int longestUnivaluePath2(TreeNode root) {
        postorder(root);
        return max;
    }
    int max =0;
    public int postorder(TreeNode node){
        if (node==null) return 0;
        int left = postorder(node.left);
        int right = postorder(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left !=null && node.left.val==node.val){
            arrowLeft = left+1;
        }
        if (node.right!=null && node.right.val==node.val){
            arrowRight= right+1;
        }
        max = Math.max(max,arrowLeft+arrowRight);
        return Math.max(arrowLeft,arrowRight);
    }

    /**
     * 方法1： 分层思考
     */
    public int longestUnivaluePath(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        int ans=0;
        if (root==null) return ans;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            int len = help(cur);
            if (len>ans) ans=len;
            if (cur.left!=null) stack.add(cur.left);
            if (cur.right!=null) stack.add(cur.right);
        }
        return ans;
    }
    public int help(TreeNode node){
        int s1=0;
        int s2=0;
        if (node.left!=null && node.left.val==node.val){
            s1 = single(node.left)+1;
        }
        if (node.right!=null && node.right.val==node.val){
            s2 = single(node.right)+1;
        }
        return s1+s2;
    }
    public int single(TreeNode node){
        int left=0;
        if (node.left!=null && node.left.val==node.val){
            left = single(node.left);
            left+=1;
        }
        int right=0;
        if (node.right!=null && node.right.val==node.val){
            right = single(node.right);
            right+=1;
        }
        return Math.max(left, right);
    }


}
