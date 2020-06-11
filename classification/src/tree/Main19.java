package tree;
import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 12:40
 *  二叉树的中序遍历--迭代
 */
public class Main19 {
    List<Integer> ans = new ArrayList<>();
    /**
     * 递归
     */
    void inOrder1(TreeNode node){
        if (node == null) return;
        inOrder1(node.left);
        ans.add(node.val);
        inOrder1(node.right);
    }

    /**
     * 栈 迭代
     */
    public List<Integer> inOrderTraversal(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()){ // 开始进入或者后续不等空
            while (cur != null){ // 一直添加左节点
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop(); // 弹出当前最小值
            ans.add(cur.val);
            cur = cur.right; // 访问它的右节点
        }
        return ans;
    }


    /**
     * 栈
     * 迭代
     */
    List<Integer> inOrder2(TreeNode node){
        if (node == null) return new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        stack.add(node);
        HashSet<TreeNode> hasTraveled = new HashSet<>();
        hasTraveled.add(node);
        while (! stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (cur.left!=null && hasTraveled.contains(cur.left)){
                    stack.add(cur.left);
                    hasTraveled.add(cur.left);
            }else {
                stack.pop();
                ans.add(cur.val);
                if (cur.right!=null)
                    stack.add(cur.right);
            }
        }
        return ans;
    }
}
