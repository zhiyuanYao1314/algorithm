package A3FastAndSlowPointer;

import org.w3c.dom.ls.LSException;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 23:44
 * 请判断一个链表是否为回文链表。
 *
 */
public class A2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        // ListNode l4 = new ListNode(4);
        l1.next =l2;l2.next =l3;
        System.out.println(isPalindormic(l1));
    }

    /**
     * 使用快慢指针+ 反转数组
     */
    public static boolean isPalindormic(ListNode node){
        if (node ==null || node.next==null) return true;
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //
        ListNode cur = slow.next;
        // 反转
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        } // 反转后pre是secondHead;
        while (pre != null && node.val == pre.val){
            pre=pre.next;
            node = node.next;
        }
        if (pre == null)return true;
        return false;
    }

    public static ListNode reverse(ListNode node){
        if (node ==null || node.next==null) return node;
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
