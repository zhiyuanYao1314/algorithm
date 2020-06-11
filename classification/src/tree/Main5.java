package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class Main5 {

    /**
     * 之字型打印：
     *  falg, 轮流切换
     *  每一层放入一个list中， 取到size>0
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        queue.add(pRoot);
        boolean isReverse = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node==null) continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (isReverse){
                Collections.reverse(list);
            }
            isReverse = !isReverse;
            if (list.size()!= 0)
                lists.add(list);
        }
        return lists;
    }
}