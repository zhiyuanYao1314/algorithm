package link;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 11:09
 * 对链表进行插入排序
 */
public class Main11 {

    /**
     *思路： 双指针
     *  p q
     *  1 3 5 4 7
     *      p q
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode first = head, left = head, right = head.next;
        while (right!=null){
            if (left.val<=right.val) {
                left = left.next;
                right = right.next;
            }else {
                ListNode rNext = right.next;
                first = insertSort(first,right);
                left.next =rNext;
                right = rNext;
            }
        }
        return first;
    }

    private ListNode insertSort(ListNode left, ListNode right) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = left;
        left = head;
        ListNode pre=null;
        while (left.val<=right.val){
            pre = left;
            left = left.next;
        }
        if (pre!=null){
            pre.next = right;
        }
        right.next = left;
        return head.next;
    }
}
