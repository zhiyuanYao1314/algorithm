package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 14:21
 * Describe:二叉树的后续遍历-- 迭代
 * version:1.0
 */
public class Main20 {

    /**
     * 后续遍历，stack
     * 顶点永远是最后一个；
     * 然后左右子树中的右子树的节点是最后一个；
     * 后续遍历的结果从后往前看和 前序遍历类似。
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root ==null) return ans;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left !=null) stack.push(cur.left);
            if (cur.right !=null) stack.push(cur.right);
        }
        return ans;
    }


    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode cur = root;
    //     stack.add(cur);
    //     while (cur != null || !stack.isEmpty()){
    //         while (cur.left != null){
    //             stack.add(cur.left);
    //             cur = cur.left;
    //         }
    //         // no left
    //         if (cur.right != null){
    //             stack.add(cur.right);
    //             cur = cur.right;
    //         // no left and no right
    //         }else {
    //             ans.add(cur.val);
    //             cur = stack.pop();
    //         }
    //
    //
    //     }
    //
    // }

}
