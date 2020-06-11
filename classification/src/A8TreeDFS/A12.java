package A8TreeDFS;

import jdk.nashorn.internal.runtime.FindProperty;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 18:20
 * 652leetcode 寻找重复的子树
 *
 */
public class A12 {
    public static void main(String[] args) {
        TreeNode node = A13.build("[0,0,0,0,null,null,0,null,null,null,0]");
        List<TreeNode> all = findDuplicateSubtrees(node);
        for (TreeNode e: all){
            System.out.println(A13.unbuild(e));
        }
    }
    /**
     * 思路：
     * 每个节点都序列化，放到hashmap里，
     * 如果存在， 放到结果集中！
     */
    static HashMap<String, Integer> map  = new HashMap<>();
    static List<TreeNode> ans = new LinkedList<>();
    static public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }
    static String serialize(TreeNode node){
        if (node==null) return "#";
        String str = node.val+","+serialize(node.left)+","+serialize(node.right);
        map.put(str, map.getOrDefault(str,0)+1);
        if(map.get(str)==2){
            ans.add(node);
        }
        return str;
    }

}
