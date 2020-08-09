package kuaishou;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 16:41
 * Describe:
 * version:1.0
 */
public class Main7 {
    public static void main(String[] args) {

    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 判断A是不是Bde子树
     */
    boolean AisB(TreeNode A, TreeNode B){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(B);
        while (!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if (checkChild(A, cur)){
                return true;
            }
            if (cur.left!=null){
                queue.addLast(cur.left);
            }
            if (cur.right!=null)
                queue.addLast(cur.right);
        }
        return false;
    }

    private boolean checkChild(TreeNode a, TreeNode b) {
        if (a==null && b==null){
            return true;
        }
        if (a==null || b==null){
            return false;
        }
        if (a.val!=b.val){
            return false;
        }
        return checkChild(a.left, b.left) && checkChild(a.right, b.right);
    }
}
