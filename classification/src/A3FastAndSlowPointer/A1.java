package A3FastAndSlowPointer;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 22:28
 * 链表是否有环
 */

class ListNode {
    int val;
    ListNode next;
    ListNode (int val){
        this.val = val;
    }
}

public class A1 {
    public static void main(String[] args) {

    }

    public  static boolean isCycle(ListNode root){
        ListNode slow = root;
        ListNode fast= root;
        while (fast!=null){
            if (slow==fast) return true;
            slow = slow.next;
            fast = fast.next;
            if (fast ==null) return false;
            fast = fast.next;
        }
        return false;
    }
}
