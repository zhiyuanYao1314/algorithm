package tree;
import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 14:38
 * 序列化和反序列化二叉树: 前序遍历
 */

public class Main24 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4; // 1 2 3 null 4;
        Main24 main24 = new Main24();
        String ans = main24.serialize(t1);
        System.out.println(ans);
        TreeNode treeNode = main24.deserialize(ans);
        ans = main24.serialize(treeNode);
        System.out.println(ans);
    }

    // 前左右
    public String serialize(TreeNode root) {
        if (root==null ) return "null,";
        String str = root.val+",";
        String left = serialize(root.left);
        String right= serialize(root.right);
        return str+left+right;
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<Integer> datas = new ArrayList<>();
        for (int i=0;i<strs.length;i++){
            if (strs[i].equals("null")){
                datas.add(null);
            }else {
                datas.add(Integer.parseInt(strs[i]));
            }
        }
        return dp(datas);
    }

    TreeNode dp(List<Integer> datas ){
        if (datas ==null || datas.size()==0) return null;
        if (datas.get(0)==null) {
            datas.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(datas.remove(0));
        cur.left = dp(datas);
        cur.right= dp(datas);
        return cur;
    }

}