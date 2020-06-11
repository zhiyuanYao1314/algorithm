package A7TreeBFS;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 15:26
 * Describe:
 * version:1.0
 */
public class A9 {
    /**
     * 不为null， 添加， 加入队列
     * 为null 添加，
     */
    List<Integer>  serialize(TreeNode node){
        ArrayList<Integer> ret = new ArrayList<>();
        if (node==null) {
            ret.add(null);
            return ret;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(node);
        while (!q.isEmpty()){
            node = q.removeFirst();
            ret.add(node.val);
            if (node.left!=null){
                q.addLast(node.left);
                ret.add(node.val);
            }else {
                ret.add(null);
            }
            if (node.right!=null){
                q.addLast(node.right);
                ret.add(node.val);
            }else {
                ret.add(null);
            }
        }
        return ret;
    }

    /**
     *
     */
    TreeNode unserialize(List<Integer>  list){
        if (list==null) return null;
        if (list.size()==1 && list.get(0)==null) return null;
         Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode head = build(list.remove(0));
         q.addLast(head);
        TreeNode cur = null;
         while (!q.isEmpty()){
            cur = q.removeFirst();
            if (list.size()>0){
                TreeNode l = build(list.remove(0));
                cur.left = l;
                if (l!=null) q.addLast(l);
            }
             if (list.size()>0){
                 TreeNode r = build(list.remove(0));
                 cur.right =r;
                 if (r!=null) q.addLast(r);
             }
         }
         return head;
    }
    TreeNode build(Integer val){
        if (val==null)return null;
        return new TreeNode(val);
    }


    // 方法二：先序

    List<Integer> preSe(TreeNode node, List<Integer> list){
        if (node==null) {
            list.add(null);
            return list;
        }
        list.add(node.val);
        preSe(node.left,list);
        preSe(node.right,list);
        return list;
    }

    TreeNode preUnSerialize(List<Integer> list){
        if (list.size()==0) return null;
        Integer v = list.remove(0);
        if (v==null) return null;
        TreeNode cur = new TreeNode(v);
        cur.left = preUnSerialize(list);
        cur.right = preUnSerialize(list);
        return cur;
    }
}
