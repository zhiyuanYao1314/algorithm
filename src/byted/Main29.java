package byted;


/**
 * 142 环形链表II
 * 返回listNode
 */
public class Main29 {

    public static void main(String[] args) {

    }
    // 1- 2
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next ==null)
            return null;

        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow){
                break;
            }
        }
        if (fast !=slow){
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}


