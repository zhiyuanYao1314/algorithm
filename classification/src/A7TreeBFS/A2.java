package A7TreeBFS;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 1:26
 * 之字形遍历
 */
public class A2 {

    public List<List<Integer>> zigTravel(TreeNode node){
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (node ==null ) return ans;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(node);
        boolean flag = false;
        while (! queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> ins = new ArrayList<>();
            while (size-->0){
                TreeNode cur = queue.poll();
                ins.add(cur.val);
                if(cur.left !=null) queue.add(cur.left);
                if(cur.right !=null) queue.add(cur.right);
            }
            if (flag){
                Collections.reverse(ins);
                flag = !flag;
            }
            ans.add(ins);
        }
        return ans;
    }
}
