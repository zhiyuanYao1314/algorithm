import java.util.*;

/**
 * 树
 *
 * 树的BFS: 用于处理层次关系
 * 树的serialize 和unSerialize；
 *
 * 树的dfs:
 *  前中后的递归 迭代遍历法
 *  pre: 序列化， 需要先构建当前点，
 *  in: 有序性
 *  post: 树的DP，先收集左右子树的信息，再交给父节点继续处理；
 *
 */
public class Test5 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    // 1.bfs
    void bfs(TreeNode node){
        if (node==null) return;
        Deque<TreeNode> q = new ArrayDeque();
        q.addLast(node);
        TreeNode cur;
        while (!q.isEmpty()){
            cur = q.removeFirst();
            System.out.println(cur.val);
            if (cur.left !=null)
                q.addLast(cur.left);
            if (cur.right!=null)
                q.addLast(cur.right);
        }
    }

    // 2. z子打印
    List<List<Integer>> bfsZ(TreeNode node){
        List<List<Integer>> ret = new ArrayList<>();
        if (node==null) return ret;
        Deque<TreeNode> q = new ArrayDeque();
        q.addLast(node);
        TreeNode cur;
        boolean isNeg = false;
        while (!q.isEmpty()){
            // 设置每一层的循环次数
            int sz = q.size();
            ArrayList<Integer> curList = new ArrayList();
            for (int i=0;i<sz;i++){
                cur = q.removeFirst();
                curList.add(cur.val);
                System.out.println(cur.val);
                if (cur.left !=null)
                    q.addLast(cur.left);
                if (cur.right!=null)
                    q.addLast(cur.right);
            }
            if (isNeg){
                Collections.reverse(curList);
            }
            ret.add(curList);
        }
        return ret;
    }

    // 3. pre 进行serialize
    String serialize(TreeNode node){
        if (node==null) return "null";
        return node.val +" "+ serialize(node.left)+" "+serialize(node.right);
    }

    // 4. pre 进行serialize
    int s =0;
    TreeNode unSerialize(String[] str){
        if ("null".equals(str[s])){
            s++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(str[s]));
        s++;
        cur.left = unSerialize(str);
        cur.right = unSerialize(str);
        return cur;
    }

    void dfs(TreeNode node){
        if (node==null) return;
        // pre
        dfs(node.left);
        // in
        dfs(node.right);
        // post
    }

    // pre-递归
    void pre(TreeNode node){
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.removeLast();
            System.out.println(cur.val);
            if (cur.right!=null)
                stack.addLast(cur.left);
            if (cur.left !=null)
                stack.addLast( cur.right);
        }
    }

    // in -递归 中续遍历 有序
    void in(TreeNode node){
        if (node==null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(node);
        TreeNode cur = node;
        while (!stack.isEmpty()){
            while (cur !=null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.removeLast();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    // post 后续 先前序，再reverse。
    void post(){

    }

    // in 将树转化为有序的双向链表
    TreeNode pre;
    TreeNode ret;
    TreeNode TreeNodeToDoubleLink(TreeNode node){
        pre = new TreeNode(-1);
        in2(node);
        ret.left = null;
        return ret;
    }

    //
    void in2(TreeNode node){
        if (node==null){
            return;
        }
        in2(node.left);
        // 第一个节点 返回；
        if (ret==null)
            ret = node;
        pre.right = node;
        node.left = pre;
        pre = node;
        in2(node.right);

    }

    /**
     * node
     * 双儿子： 加入
     * 单儿子： 有右无左： return false；
     *    反（有左无右）： 进入新的循环，一定都无儿子，否则返回false
     *    无儿子;
     *    出现有一个空儿子后， 后面queue中的所有弹出的点的儿子都必须是空；
     */

    public boolean isCompleteTree(TreeNode node){
        // 队列
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(node);
        while (!q.isEmpty()){
            TreeNode cur = q.removeFirst();
            if (node.left==null && node.right!=null){
                return false;
            }
            if (node.right !=null && node.left!=null){
                q.addLast(node.left);
                q.addLast(node.right);
            }else {
                if (node.left==null){
                    q.addLast(node.left);
                }
                while (!q.isEmpty()){
                    TreeNode n = q.removeFirst();
                    if (n.left !=null || n.right!=null)
                        return false;
                }
            }
        }
        return true;
    }
}