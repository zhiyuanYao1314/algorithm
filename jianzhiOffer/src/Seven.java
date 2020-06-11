import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 10:02
 * Describe:
 * version:1.0
 */

public class Seven {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {
        Seven seven = new Seven();
        int[]pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        TreeNode t = seven.reConstructBinaryTree(pre,in);
        System.out.println(seven.pre(t));
    }

    private static HashMap<Integer,Integer> inMap = new HashMap();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i=0;i<in.length;i++) {
            inMap.put(in[i],i);
        }
        return reCon(pre, 0,pre.length-1, 0);

    }

    /**
     * 递归，每一步找到一个root，然后再找left和right.
     * 调整的是前序遍历的左右节点，左子树的长度需要根据中序遍历的左节点来定。
     * 退出条件是左节点>右节点。
     *
     * @param pre
     * @param preL
     * @param preR
     * @param inL
     * @return
     */
    public TreeNode reCon(int[] pre, int preL, int preR, int inL){
        if (preL>preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int index =inMap.get(pre[preL]);
        int leftTreeLength = index-inL;
        root.left = reCon(pre, preL+1,preL+leftTreeLength,inL);
        root.right = reCon(pre, preL+leftTreeLength+1,preR,inL+leftTreeLength+1);
        return root;
    }


    public ArrayList<Integer> pre(TreeNode node){
        ArrayList<Integer> arr = new ArrayList<>();
        if (node==null) return arr;
        arr.add(node.val);
        arr.addAll(pre(node.left));
        arr.addAll(pre(node.right));
        return arr;
    }
    public ArrayList<Integer> inorder(TreeNode node){
        ArrayList<Integer> arr = new ArrayList<>();
        if (node==null) return arr;
        arr.addAll(pre(node.left));
        arr.add(node.val);
        arr.addAll(pre(node.right));
        return arr;
    }
}
