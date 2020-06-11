package tree;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 15:00
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class Main21 {

    /**
     * 修改 中序遍历的栈实现
     */
    public int kthSmallest(TreeNode root, int k) {
        if (k<=0) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!= null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k ==0){
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }

    /**
     *修改 中序遍历的递归实现
     */
    public int kthSmallest2(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }
    int ans;
    int k;
    public void inorder(TreeNode root){
        if (root==null || k<=0) return;
        inorder(root.left); // 左节点递归
        if (--k==0) { // 当前层判断 k
            ans = root.val;
            return;
        }
        inorder(root.right); // 右节点递归
    }

}
