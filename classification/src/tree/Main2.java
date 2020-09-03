package tree;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Main2 {

    // pre 1,2,4,7,3,5,6,8
    // in  4,7,2,1,5,3,8,6
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return reCon(0, pre.length-1, 0, in.length-1);
    }

    int[] pre;
    int[] in;
    // 人总是希望自己被认可， 关键还是提升自己的能力。
    public TreeNode reCon(int preL, int preR, int inL, int inR){
        if (preL>preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int index = map.get(pre[preL]);
        int leftLen = index-inL;
        root.left = reCon(preL+1, preL+leftLen,inL,in[index]-1);
        root.right = reCon(preL+leftLen+1,preR, in[index]+1, inR);
        return root;
    }

}
