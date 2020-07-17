package byted;

import java.util.List;

/**
 * 328 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class Main64 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next=n3;
        ListNode n = oddEvenList(n1);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode first = h1;
        ListNode second = h2;
        while (second!=null && second.next!=null){
            first.next = first.next.next;
            first = first.next;
            second.next = second.next.next;
            second = second.next;
        }
        first.next = h2;
        return h1;
    }
}
