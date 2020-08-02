
import java.util.*;

/**
 * 构建多叉树，然后找到连续相加最大路径
 */
public class Main2 {

    static class TreeNode {
        int val;
        List<TreeNode> childs;
        int loc; // 自己的父亲
        TreeNode parent;
        TreeNode(int val, int loc) {
            this.loc = loc;
            this.val = val;
            childs = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());

        HashMap<Integer, TreeNode> ts = new HashMap<>();
        TreeNode root = null;
        // 1. 构造树结构
        for (int i = 2; i < n + 2; i++) {
            String line = sc.nextLine();
            String[] ls = line.split(" ");
            if (new Integer(ls[1]).equals(0)) { // 根节点放自己
                root = new TreeNode(new Integer(ls[0]), i); // 是自己；
                ts.put(i, root);
                continue;
            }
            TreeNode c = new TreeNode(new Integer(ls[0]), new Integer(ls[1]));
            ts.put(i, c); // 自己所在的层，和自己
            if (ts.get(new Integer(ls[1]))!=null){
                ts.get(new Integer(ls[1])).childs.add(c); // 爸爸放自己
            }
        }
        //2.找连续路径最大值；
        Deque<TreeNode> qu = new ArrayDeque<>();
        qu.addLast(root);
        while (!qu.isEmpty()) {
            TreeNode cc = qu.pollFirst();
            if (cc != null) {
                trace(cc, 0);
                for (TreeNode ccc : cc.childs) {
                    qu.addLast(ccc);
                }
            }
        }
        System.out.println(max);
    }

    static int max = -100000;

    public static void trace(TreeNode root, int path) {
        if (root == null) {
            return;
        }
        path += root.val;
        max = Math.max(max, path);
        for (TreeNode c : root.childs) {
            trace(c, path);
        }
    }

}