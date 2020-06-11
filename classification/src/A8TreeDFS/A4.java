package A8TreeDFS;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureECDSA;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import sun.security.provider.Sun;

import java.util.logging.Level;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/27 17:30
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class A4 {

    public int pathSum(TreeNode root, int sum) {
        sum(root, sum);
        return ans;
    }
    public void sum(TreeNode root, int sum){
        if (root==null) return;
        help(root, sum);
        sum(root.left, sum);
        sum(root.right, sum);
    }
    int ans=0;
    void help(TreeNode root, int sum){
        sum -=root.val;
        if (sum==0) {
            ans++;
        }
        if (root.left!=null)
            help(root.left, sum);
        if (root.right!=null)
            help(root.right,sum);
    }
}
