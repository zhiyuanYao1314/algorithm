package tree;
import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Stack;
import java.util.zip.Inflater;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class Main8 {
    public static void main(String[] args) {

    }


    // 方法2：利用递归
    TreeNode KthNode2(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return Kth;
    }
    // 记录点
    TreeNode Kth;
    // 这是全局共享的；
    int cur=0;
    void inOrder(TreeNode pRoot, int k){
        // 当到达最底层或者已完成，立即结束；
        if (pRoot==null || cur>=k) return;
        // 当没有左节点了，再将计数+1；
        inOrder(pRoot.left,k);
        cur ++;
        // 自己+1，判断是否等于k，
        if (cur==k) Kth=pRoot;
        inOrder(pRoot.right,k);
    }



    // 中序遍历查找第k个最小点
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null) return null;
        if (k<=0) return null;
        Stack<TreeNode> stack = new Stack();
        HashSet<TreeNode> set = new HashSet<>();
        stack.push(pRoot);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek.left!=null && set.add(peek.left)){
                stack.push(peek.left);
            }else if (peek.right!=null && set.add(peek.right)){
                stack.pop();
                k--;
                stack.push(peek.right);
            }else {
                stack.pop();
                k--;
            }
            if (k==0) return peek;
        }
        return null;
    }
    //
    /**
     *使用栈进行中序遍历
     * 相比前序遍历，要麻烦一些；
     *
     */
    void midTravel(TreeNode node){
        if (node ==null) System.out.println("node不能为空");;
        HashSet<TreeNode> set = new HashSet<>(); // 记录所有已经访问过的点
        Stack<TreeNode> stack= new Stack();
        stack.push(node);

        while (!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            if (tmp.left != null && set.add(tmp.left)){ // 如果有左子树且未被访问过，则放入；
                stack.push(tmp.left);
                // 如果有右子树且未被访问过，将当前最小值弹出，再放入右子树；
            }else if (tmp.right != null && set.add(tmp.right)){
                stack.pop();
                System.out.println(tmp.val);
                stack.push(tmp.right);
            }else {
                stack.pop();
                System.out.println(tmp.val);
            }
        }
    }
    // 用栈进行pre travel
    void preTravel(TreeNode node){
        if (node== null) {
            System.out.println("not null!");
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.left != null){
                stack.push(cur.left);
            }else if (cur.right!=null){
                stack.push(cur.right);
            }
        }
    }

}
