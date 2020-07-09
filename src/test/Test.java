package test;

import java.util.ArrayDeque;
import java.util.Deque;

class Test {
    class TreeNode{
        TreeNode right;
        TreeNode left;
    }

    public boolean isCompleteTree(TreeNode node) {
        if (node==null) return true;
        Deque<TreeNode> q = new ArrayDeque();
        q.addLast(node);
        while(!q.isEmpty()){
            TreeNode cur = q.removeLast();
            if (cur.right!=null && cur.left==null){ //有右无左
                return false;
            }
            if(cur.right==null || cur.left==null){ // 只要有一个孩子为null。
                while(!q.isEmpty()){
                    TreeNode next = q.removeLast();
                    if (next.left !=null || next.right!=null){
                        return false;
                    }
                }
                return true;
            }else{ // 双全
                q.addLast(cur.left);
                q.addLast(cur.right);
            }
        }
        return true;
    }
}
