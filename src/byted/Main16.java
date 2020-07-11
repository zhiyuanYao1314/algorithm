package byted;

/**
 * 543 二叉树的直径；
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是
 * 任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 */
public class Main16 {
    public static void main(String[] args) {




    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;
        return help(root).path-1;
    }

    public Info help(TreeNode node){
        if (node==null)
            return  new Info(0,0);
        Info lInfo = help(node.left);
        Info rInfo = help(node.right);
        int h = Math.max(lInfo.height, rInfo.height)+1;
        int path = Math.max( Math.max(lInfo.path, rInfo.path), lInfo.height+rInfo.height+1); // m, m,
        return new Info(path, h);
    }

    class Info{
        int path;// 经过该店的
        int height;
        Info(int path, int height){
            this.height = height;
            this.path = path;
        }
    }
}
