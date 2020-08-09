package kuaishou;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 16:50
 *
 * z子型 层序遍历
 */
public class Main10 {

    void getZ(TreeNode node){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        List<List<Integer>> ans = new ArrayList<>();
        boolean isReverse = false;
        while (!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> list = new ArrayList<>();
            while (sz>0){

                TreeNode cur = queue.pollFirst();
                // list.add(cur);
                sz--;
            }
            if (isReverse){
                Collections.reverse(list);
            }
            isReverse = !isReverse;


        }
    }


}
