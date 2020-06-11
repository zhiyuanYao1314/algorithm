package tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Main9 {
    public static void main(String[] args) {

    }
    /**
     * 先找到一个相同的root，然后开始递归，直到root2为null
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 ==null) return false;
        if (root1 == null) return false;
        if (root1.val == root2.val && (compare(root1,root2))){
            return true;
        }else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    public boolean compare(TreeNode root1,TreeNode root2) {
        if (root2 ==null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val){
            return compare(root1.left, root2.left) && compare(root1.right, root2.right);
        }else {
            return false;
        }
    }
}
