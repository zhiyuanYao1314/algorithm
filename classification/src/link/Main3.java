package link;

import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Main3 {
    public static void main(String[] args) {

    }

    // 111 2
    public ListNode deleteDuplication2(ListNode pHead){
        return null;
    }

    /**
     * 去除所有重复元素，
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = pHead;
        ListNode par = root;
        ListNode cur = pHead;
        while (cur != null){
            ListNode next =cur.next;
            int count =0;
            // 直到找到不相同的node
            while (next != null && next.val == cur.val){
                cur.next = next.next;
                next = cur.next;
                count++;
            }
            // 把相同的点都删除
            if (count>0){
                par.next=cur.next;
                cur = par.next;
            // 保留唯一的点
            }else {
                par = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }
}