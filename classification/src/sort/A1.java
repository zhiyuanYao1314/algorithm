package sort;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 9:37
 *  排序链表
 *  输入: 4->2->1->3
 * 输出: 1->2->3->4
 * time nlogn
 * space o(1)
 */
class ListNode{
    int val;
    ListNode next;
    ListNode (int val){
        this.val = val;
    }
}

public class A1 {
    /**
     * 归并排序
     * 分 快慢指针
     * 和：归并
     */
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head; // 考虑全面
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre=null;
        while (fast!=null && fast.next!=null){
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next=null; // 注意：需要断开前后两段
        head = sortList(head);
        slow = sortList(slow);
        return merge(head, slow);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        while (left!=null && right!=null){
            if (left.val<right.val){
                head.next = left;
                left = left.next;
                head = head.next; // 注意：head也需要向后移动。
            }else {
                head.next = right;
                right= right.next;
                head = head.next;
            }
        }
        ListNode remain = left==null?right:left;
        head.next = remain; // 注意，是直接全部接在后面
        return ans.next;
    }
}
