package A8TreeDFS;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 14:33
 *
 * 二叉树的前 中 后序遍历的迭代实现方式
 * 任何递归函数都可以改成递归函数；
 * 自己设计栈来实现！
 *
 * 递归就不写了
 */
public class A17 {

    /**
     *  1. 点从栈中弹出打印，
     *  2. 加入右节点
     *  3. 加入左节点
     */
    List<Integer> pre(TreeNode node){
        ArrayList<Integer> ret = new ArrayList<>();
        if (node ==null) return ret;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.removeLast();
            ret.add(cur.val);
            if (cur.left!=null){
                stack.addLast(cur.left);
            }
            if (cur.right!=null){
                stack.addLast(cur.right);
            }
        }
        return ret;
    }

    /**
     * 一直先处理左节点，再处理右节点
     * 一个游标节点一直取左子树，
     */
    List<Integer> in(TreeNode node){
        ArrayList<Integer> ret = new ArrayList<>();
        TreeNode cur = node;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur!=null){
            if (cur!=null){
                stack.addLast(cur);
                cur = cur.left;
            }else{ // 左子树完了；
                cur = stack.removeLast();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }

    /**
     * 后序遍历(左右中)的倒序就是(中右左) 和前序遍历类似，最后反转一下
     */
    List<Integer> post(TreeNode node){
        ArrayList<Integer> ret = new ArrayList<>();
        Deque<Integer> reverse = new ArrayDeque<>(); // 用于反转
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = node;
        stack.addLast(cur);
        while (!stack.isEmpty()){
            cur =stack.removeLast();
            reverse.addLast(cur.val);
            if (cur.left!=null){
                stack.addLast(cur.left);
            }
            if (cur.right!=null){
                stack.addLast(cur.right);
            }
        }
        while (!reverse.isEmpty()){
            ret.add(reverse.removeLast());
        }
        return ret;
    }
}
