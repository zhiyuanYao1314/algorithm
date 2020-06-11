package A8TreeDFS;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 21:13
 * 从叶子节点开始的最小字符串
 */
public class A8 {

    public static void main(String[] args) {
        System.out.println(new Character((char) 125));
    }
    String ans = "}";
    public String smallestFromLeaf(TreeNode root) {
        preorder(root,"");
        return ans;
    }
    public void preorder(TreeNode node, String str){
        str = (char)(node.val+'a')+str;
        if (node.left==null && node.right==null)
            if (str.compareTo(ans)<0)    ans = str;
        if (node.left!=null)
            preorder(node.left, str);
        if (node.right!=null)
            preorder(node.right, str);
    }


}
