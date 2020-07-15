package byted;

/**
 * 230 二叉搜索树中的第k小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class Main59 {

    public static void main(String[] args) {
        Main59 m = new Main59();
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        n4. left = n2;
        n4.right = n5;
        n2.left = n1;
        int n = m.kthSmallest(n4, 4);
        System.out.println(n);
        /**
         *    4
         *  2    5
         *1
         */
    }

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return res;
    }

    int s =0;
    int res;
    public void help(TreeNode node, int k){
        if (node==null)
            return;
        help(node.left, k);
        s++;
        if (s==k){
            res = node.val;
            return;
        }
        if (s>k)
            return;
        help(node.right, k);
    }

}
