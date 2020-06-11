package tree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 15:58
 * 二叉树的序列化和反序列化-- 层次遍历版本；
 */

public class Main25 {
    public static void main(String[] args) {
        String[] split = "1,12,".split(",");
        System.out.println(Arrays.toString(split));
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4; // 1 2 3 null 4;
        String ans = serialize(t1);
        System.out.println(ans);
        TreeNode treeNode = deserialize(ans);
        ans = serialize(treeNode);
        System.out.println(ans);
    }
    // Encodes a tree to a single string.

    /**
     * 层序遍历
     *    1
     *  n   2
     *     4
     *  1 n 2 4;
     */

    public static String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        String ans= "(";
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur==null){
                ans += "null,";
                continue;
            }
            ans += cur.val+",";
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return ans+")";
    }

    // Decodes your encoded data to tree.
    // (1,null,2, 4)
    public static TreeNode deserialize(String data) {
        // [1,2,null, 4]
        if (data==null || data.length()==0) return null;
        String[] strs = data.substring(1,data.length()-1).split(",");
        TreeNode[] nodes = new TreeNode[strs.length];
        for (int i=0;i<strs.length;i++){
            String cur = strs[i].trim();
            if (cur.equals("null")){
                nodes[i] = null;
            }else {
                nodes[i] = new TreeNode(Integer.parseInt(cur));
            }
        }
        Queue<TreeNode> q = new LinkedList();

        TreeNode head = nodes[0];
        q.offer(nodes[0]);

        int index =1;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (index<nodes.length &&nodes[index]!= null){
                cur.left = nodes[index];
                q.offer(cur.left);
            }
            index++;
            if (index<nodes.length && nodes[index]!= null){
                cur.right = nodes[index];
                q.offer(cur.right);
            }
            index++;
        }
        return head;
    }
}
