package byted;

/**
 * 86 分割链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class main69 {

    public ListNode partition(ListNode head, int x) {

        if (head==null || head.next==null){
            return head;
        }

        // pre 表示第一个大于等于x的前一个位置；
        // post 表示在i后面的小于x的位置
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode ret = pre; // 用于最后返回

        while (pre.next!=null && pre.next.val<x){
            pre = pre.next;
        } //结束后，当前的pre是
        if (pre.next==null){
            return ret.next;
        }

        ListNode post =pre.next;
        ListNode postPre = pre; // 用于删除当前元素
        while (post!=null){
            ListNode next = post.next;

            if (post.val<x){
                // 移除post
                postPre.next = next;
                // 添加到pre的位置；
                post.next = pre.next;
                pre.next = post;
                pre = pre.next;
                post = next;
            }else {
                postPre = post;
                post = next;
            }
        }
        return ret.next;
    }

}
