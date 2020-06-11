package xueersi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/9 11:31
 *
 * 有两个结构完全相同的树，将所有的节点相加，构造一颗新的树！
 * 要求，不适用递归！
 */

public class Main4 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode rifht;
        TreeNode(int val){
            this.val =val;
        }
    }

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        TreeNode node1 = main4.read("1,2,null,null,3,null,4");
        TreeNode node2 = main4.read("2,3,null,null,4,null,5");
        TreeNode node3 = main4.combain(node1, node2);
        System.out.println(main4.serilize(node3));

    }

    String serilize(TreeNode node){
        if (node==null) return null;
        return  node.val + serilize(node.left)+serilize(node.rifht);
    }

    TreeNode read(String str){
        String[] strs = str.split(",");
        ArrayList<TreeNode> tree = new ArrayList<>();
        for (int i =0;i<strs.length;i++){
            if ("null".equalsIgnoreCase(strs[i])){
                tree.add(null);
            }else
                tree.add(new TreeNode(Integer.parseInt(strs[i])));
        }
        TreeNode ans = help(tree);
        return ans;
    }
    TreeNode help(ArrayList<TreeNode> strs){
        if (strs==null || strs.size()==0) return null;
        if (strs.get(0)==null){
            strs.remove(0);
            return null;
        }
        TreeNode cur = strs.remove(0);
        cur.left= help(strs);
        cur.rifht= help(strs);
        return cur;
    }

    /**
     * 使用递归！
     * 前序遍历；
     */
    public static TreeNode combain2(TreeNode a , TreeNode b){
        if (a== null) return null;
        TreeNode cur = new TreeNode(a.val + b.val);
        cur.left = combain2(a.left, b.left);
        cur.rifht = combain2(a.rifht, b.rifht);
        return cur;
    }

    /**
     * 使用三个队列！
     * 新的节点和原来的节点保持同步，
     * 然后在每一层，将新的节点和左右子树连接；
     */
    public static TreeNode combain(TreeNode a , TreeNode b){
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        Queue<TreeNode> q3 = new LinkedList();
        q1.add(a);
        q2.add(b);
        TreeNode c = new TreeNode(a.val+b.val);
        q3.add(c);
        while (!q1.isEmpty()){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            TreeNode t3 = q3.poll();
            if (t1.left!=null){
                q1.add(t1.left);
                q2.add(t2.left);
                t3.left = new TreeNode(t1.left.val+t2.left.val);
                q3.add(t3.left);
            }
            if (t1.rifht!=null){
                q1.add(t1.rifht);
                q2.add(t2.rifht);
                t3.rifht = new TreeNode(t1.rifht.val+t2.rifht.val);
                q3.add(t3.rifht);
            }
        }
        return c;
    }
}
