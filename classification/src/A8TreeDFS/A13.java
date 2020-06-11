package A8TreeDFS;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 21:10
 * 反序列化
 * [1,2,3,4,null,2,4,null,null,4] 这是一个层序遍历的结果
 * 构造一个Tree
 */
public class A13 {
    public static String unbuild(TreeNode node){
        Queue<TreeNode> q = new LinkedList();
        q.offer(node);
        StringBuffer ans = new StringBuffer("[");
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur==null){
                ans.append(null+",");
                continue;
            }
            ans.append(cur.val+",");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        ans.append("]");
        return ans.toString();
    }
    public static TreeNode build(String str){
        String[] nodes = str.substring(1, str.length() - 1).split(",");
        Queue<TreeNode> q = new LinkedList();
        TreeNode[] tree = new TreeNode[nodes.length];
        for (int i=0;i<nodes.length;i++){
            if (nodes[i].equalsIgnoreCase("null")){
                tree[i] = null;
            }else {
                tree[i] = new TreeNode(Integer.parseInt(nodes[i]));
            }
        }
        q.offer(tree[0]);
        TreeNode head = tree[0];
        int index =1;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (index<tree.length && tree[index]!=null){
                cur.left = tree[index];
                q.offer(cur.left);
            }
            index++;
            if (index<tree.length && tree[index]!=null){
                cur.right = tree[index];
                q.offer(cur.right);
            }
            index++;
        }
        return head;
    }

}
