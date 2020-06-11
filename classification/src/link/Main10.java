package link;

import java.util.Stack;

/**
 * Time:2020/4/23 16:59
 * 每k个元素反转
 */
public class Main10 {

    public static void main(String[] args) {
        Main10 main10 = new Main10();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next=l3;
        l3.next=l4;
        ListNode n = main10.reverseByK(l1, 3);
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }
    public ListNode reverseByK (ListNode root, int k){
        Stack<ListNode> s = new Stack();
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = root;

        ListNode first = null;
        int count =0;
        while (cur != null){
            s.push(cur);
            next = cur.next;
            count++;
            if (count==k){
                if (first==null) first = cur;
                pre = reversK(s,pre,next);
                count=0;
            }
            cur = next;
        }
        return first;
    }

    private ListNode reversK(Stack<ListNode> s, ListNode pre, ListNode next) {
        ListNode cur = s.peek();
        while (!s.isEmpty()){
            cur = s.pop();
            if (pre != null)
                pre.next = cur;
            pre = cur;
        }
        cur.next = next;
        return cur;
    }
}
