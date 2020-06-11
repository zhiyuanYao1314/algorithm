package link;

import org.w3c.dom.NodeList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 11:35
 * 判断回文链表
 */
public class Main13 {
    // 方法1：
    boolean isPalin(ListNode node){
        // 1.找到中点或下中点(偶数)
         ListNode s = node;
         ListNode f = node;
         while (f!=null && f.next!=null){
             s = s.next;
             f = f.next.next;
         }
        // 2.弹如栈中
        Deque<ListNode> stack = new ArrayDeque();
        while (s!=null){
            stack.addLast(s);
            s = s.next;
        }
        // 弹出对比 node==null， 退出；
        while (node != null){
            if (node.val != stack.poll().val){
                return false;
            }
        }
        return true;
    }

    // 方法2:反转后判断数组
    boolean isPalin2(ListNode node){
        // 1. 中点或中下点(偶数)
        ListNode s = node;
        ListNode f = node;
        while (f!=null && f.next!=null){
            s= s.next;
            f = f.next.next;
        }
        // 2. 反转后半段节点
        ListNode f2 = reverse(s);
        // 3. 对比
        while (node!=null){
            if (node.val !=f2.val){
                return false;
            }
        }
        return true;
    }

    ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next; // 保证节点向下推进
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
