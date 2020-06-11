package tree;

import java.util.UnknownFormatConversionException;
import java.util.logging.Level;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Main4 {
    public static void main(String[] args) {


    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSyemme(pRoot.left, pRoot.right);
    }

    boolean isSyemme(TreeNode l, TreeNode r){
        if (l == null && r==null) return true;
        if (l == null || r == null) return false;
        if (l.val== r.val){
            return isSyemme(l.left, r.right) &&
                    isSyemme(l.right, r.left) ;
        }else {
            return false;
        }
    }
}
