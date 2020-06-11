package link;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Main4 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode right = head;
        while (k-->0){
            right = right.next;
        }
        ListNode left = head;
        while (right!=null){
            right = right.next;
            left = left.next;
        }
        return left;
    }
}
