package A8TreeDFS;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 0:04
 * Describe:
 * version:1.0
 */
public class A10 {

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalance;
    }

    boolean isBalance =true;
    public int height(TreeNode node){
        if (node==null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left-right)>1){
            isBalance = false;
            return -1;
        }
        return Math.max(left,right)+1;
    }


}
