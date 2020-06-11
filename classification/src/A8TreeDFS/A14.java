package A8TreeDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 10:36
 * 二叉树的序列化和反序列化
 * -- 前序遍历
 *
 */
public class A14 {

    String serialize(TreeNode node){
        String s = seriDp(node);
        return "["+s+"]";
    }
    private String seriDp(TreeNode node){
        if (node ==null )return null;
        return node.val +","+ serialize(node.left)+","+serialize(node.right);
    }

    TreeNode deserialize(String str){
        String[] strs = str.substring(1, str.length() - 1).split(",");
        List<String> list = new ArrayList();
        for (int i=0;i<strs.length;i++){
            list.add(strs[i]);
        }
        TreeNode root = deseriDp(list);
        return root;
    }
    TreeNode deseriDp(List<String> strs){
        if (strs.size()==0) return null;
        if (strs.get(0).equalsIgnoreCase("null")){
            strs.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(strs.remove(0)));
        cur.left = deseriDp(strs);
        cur.right = deseriDp(strs);
        return cur;
    }
}
