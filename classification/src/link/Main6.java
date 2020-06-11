package link;

import org.w3c.dom.ls.LSException;

import java.io.Reader;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Main6 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;l2.next=l3;l3.next=l4;
        Main6 main6 = new Main6();
        ListNode ans = main6.ReverseList(l1);
        while (ans != null){
            System.out.println(ans);
            ans = ans.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode ans = ReverseList(head.next);
        head.next.next=head;
        head.next=null;
        return ans;
    }
}
