package A17designMode;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 23:00
 */
public class Other {

    class TreeNode{
        int val;
        TreeNode[] childs;
    }

    public int height(TreeNode node){
        if (node ==null) return 0;
        int max =0;
        for(TreeNode n:node.childs){
            int height = height(n);
            if (height+1>max) max = height+1;
        }
        return max;
    }
}
