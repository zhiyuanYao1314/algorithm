package A8TreeDFS;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 16:58
 * 二叉树的所有路径
 */
public class A3 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return ans;
        inorder(root, new StringBuffer());
        return ans;
    }
    List<String> ans = new ArrayList<>();
    public void inorder(TreeNode node, StringBuffer str){
        if (str.length()==0){
            str = str.append(node.val);
        }else {
            str.append("->"+node.val);
        }
        if (node.left==null && node.right==null) ans.add(str.toString());
        if(node.left!=null){
            StringBuffer sb = new StringBuffer(str);
            inorder(node.left, sb);
        }
        if (node.right!=null){
            StringBuffer sb = new StringBuffer(str);
            inorder(node.right, sb);
        }
    }
}
