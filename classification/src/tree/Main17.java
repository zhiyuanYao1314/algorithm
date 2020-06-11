package tree;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.sun.xml.internal.bind.v2.util.FatalAdapter;

import java.nio.file.FileAlreadyExistsException;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/22 0:30
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Main17 {

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalance;
    }
    boolean isBalance=true;
    public int height(TreeNode node){
        if (node == null || !isBalance) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left-right)>1){
            isBalance = false;
        }
        return Math.max(left,right)+1;
    }
}
