package recursion;

import java.util.List;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 15:13
 * 每k个元素反转链表
 */


public class Main2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    ListNode reverseByK(ListNode node , int k){
        if (node==null || k<=1) return node;
        Stack<ListNode> stack = new Stack();
        ListNode pre = null;
        ListNode head = null; // 存放头元素
        int count=0;
        while (node !=null){
            stack.add(node);
            pre = node; // 1 2 3  (4 5 6 pre)  next7 8 9
            node = node.next;
            if (++count %k ==0){
                if (head==null)
                    head = stack.peek();
                ListNode cur = reverse(stack);
                cur.next = node;
            }
        }
        return head;
    }


    /**
     * 记录前一个元素pre和当前元素cur。
     * 每次将pre.next = cur, and cur.next = null
     */
    private ListNode reverse(Stack<ListNode> stack) {
        ListNode pre = null;
        while (!stack.isEmpty()){
            ListNode cur = stack.pop();
            if (pre!=null)
                pre.next = cur;
            cur.next = null; // 否则最后一个元素1 还记录着下一个元素，
            pre = cur;
        }
        return pre;
    }

    // 递归版本也是。 cur.next.next = cur, cur.next = null;

    // 二叉树排序改成双链表
    // 中序遍历 左中右 因为它的顺序遍历顺序就是从前往后
    // pre

}
