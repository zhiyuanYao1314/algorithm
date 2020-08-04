package kuaishou;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/4 2:46
 * LC92 todo！
 */
public class Main3 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1<=m<=n<=链表长度;
        ListNode f = head;
        ListNode s = head;
        for (int i=1;i<=m-1;i++){
            f = f.next; // 前一个
        }
        ListNode pre = f;
        //
        s = f.next;
        ListNode pre2 = f;
        for (int i=m;i<n;i++){
            ListNode next = s.next;
            s.next = f;
            f = s;
            s=next;
        }
        pre.next = s;
        pre2.next = s.next;
        return head;
    }
}
