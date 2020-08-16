package 猿辅导;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 判断对称二叉树
 * 递归 非递归
 *
 */
public class Main4 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    static boolean isSymmetric2(TreeNode node){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.pollFirst();
            if (cur.left==null && cur.right==null){
                continue;
            }
            if (cur.left==null || cur.right==null){
                return false;
            }
            if (cur.left.val == cur.right.val){
                queue.addLast(node.left);
                queue.addLast(node.right);
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归
     */
    static boolean isSymmetric(TreeNode node){
        if (node==null){
            return true;
        }
        if (node.left==null && node.right==null){
            return true;
        }
        if (node.left==null || node.right==null){
            return false;
        }
        boolean isLeft = isSymmetric(node.left);
        boolean isRight = isSymmetric(node.right);
        if (!isLeft || !isRight){
            return false;
        }
        if (node.left.val == node.right.val){
            return true;
        }
        return false;
    }

    boolean isCompleteTree(TreeNode node){
        // 队列
        /**
         * 有左无有
         * 双无； 进入：
         */
        return false;
    }

    public static void main(String[] args){
        System.out.println("---");
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(isSearchTree(node1));
    }

    static int pre = -100000;
    static boolean isSearchTree(TreeNode node){
        if (node==null){
            return true;
        }
        if (!isSearchTree(node.left)){
            return false;
        }
        if (node.val<pre){
            return false;
        }
        pre = node.val;
        return isSearchTree(node.right);
    }
}
