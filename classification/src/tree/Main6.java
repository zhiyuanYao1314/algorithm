package tree;

import com.sun.org.apache.regexp.internal.RE;
import sort.Main;
import sun.plugin.viewer.LifeCycleManager;

import java.util.*;

/**
 * 从上到下按层打印二叉树，
 * 同一层结点从左至右输出。每一层输出一行。
 */
public class Main6 {


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(pRoot);
        while (! queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- >0){
                TreeNode node = queue.poll();
                if (node== null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (! list.isEmpty())
                lists.add(list);
        }
        return lists;
    }
}
