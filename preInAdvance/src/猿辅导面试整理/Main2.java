package 猿辅导面试整理;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 13:53
 * 路径等于指定和
 */
public class Main2 {
    public static void main(String[] args) {

    }

    class Node{
        int val;
        Node left;
        Node right;
    }

    public List<List<Integer>> targetPath(){
        //
        return ans;
    }
    List<List<Integer>> ans ;
    void help(Node root, List<Integer> path, int target, int sum ){
        if (root.left==null && root.right==null){
            sum += root.val;
            path.add(root.val);
            if (sum == target){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        path.add(root.val);
        sum += root.val;
        if (root.left!=null){
            help(root.left,path,target,sum);
        }
        if (root.right!=null){
            help(root.right,path,target,sum);
        }
        path.remove(root.val);
        sum -= root.val;
    }

}
