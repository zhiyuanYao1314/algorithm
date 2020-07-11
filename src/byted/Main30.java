package byted;

/**
 * 112 路径总和
 * 是否存在
 */
public class Main30 {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        return help(root, 0, sum);
    }
    // 1 2 1
    boolean help(TreeNode root, int total, int sum){

        total += root.val;
        if (root.right==null && root.left==null){
            if (total==sum)
                return true;
            return false;
        }

        if (root.left !=null && help(root.left, total, sum)){
            return true;
        }
        if (root.right != null && help(root.right, total, sum)){
            return true;
        }
        total -= root.val;
        return false;
    }
}
