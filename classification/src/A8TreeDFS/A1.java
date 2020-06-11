package A8TreeDFS;


import java.lang.annotation.Target;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 1:36
 * 树上所有路径上表示的数字的和
 */


public class A1 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.right =n3;
        int sum = sum(n1, 0);
        System.out.println(sum);
    }


    /**
     * 每一层加上自己的点数；
     */
    public static int sum(TreeNode node, int sum){
        sum += node.val;//
        if (node.left == null && node.right == null) return sum;// 叶子节点返回所有的和
        int sum1=0, sum2=0;
        // 如果只有一边的化，只能算一遍
        if (node.left!= null)
            sum1=sum(node.left, sum);
        if (node.right != null)
            sum2=sum(node.right, sum);
        return sum1+sum2;
    }

}
