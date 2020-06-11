package recursion;
/**
 * 反转链表
 */
public class Main1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode root = printListFromTailToHead(l1);
        while (root!= null){
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode printListFromTailToHead(ListNode listNode) {
        if (listNode.next == null){
            return listNode;
        }
        ListNode node = printListFromTailToHead(listNode.next);
        node.next = listNode;
        listNode.next = null;
        return  node;
    }


}
