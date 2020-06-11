package A8TreeDFS;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 14:14
 * leetcode 337打家劫舍： 树状结构
 */
public class A11 {
    /**
     * 节点分为爷爷和儿子和孙子
     *  对比： 爷爷+孙子 vs 儿子 取最大
     */
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return dp(root);
    }

    HashMap<TreeNode, Integer> map;
    public int dp(TreeNode root){
        if (root==null) return 0;
        int money = root.val;
        Integer cur = map.get(root);
        if (cur!=null) return cur;
        if (root.left!=null)
            money += dp(root.left.left)+dp(root.left.right);
        if (root.right!=null)
            money += dp(root.right.left)+dp(root.right.right);
        cur =Math.max(money, dp(root.left)+dp(root.right));
        map.put(root,cur);
        return cur;
    }
}
