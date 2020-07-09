package byted;

/**
 * 160 相交链表
 */
public class Main14 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int v){
            val = v;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(-1);
        ListNode headB = new ListNode(-2);
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(2);
        headA.next =a;
        a.next = b;
        b.next = c;
        headB.next = c;

        ListNode no = getIntersectionNode(headA, headB);
        System.out.print(no.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        for (int i=0;i<2;i++){
            while (nodeA != null && nodeB!=null){
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            if (nodeA==null){
                nodeA = headB;
            }else {
                nodeB = headA;
            }
        }
        while (nodeA != null && nodeB!=null){
            if (nodeA==nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
