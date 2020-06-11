package link;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 11:29
 */
public class Main12 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next =n2;
        // n2.next = n3;
        ListNode ans = upOrMedium(n1);
        System.out.println(ans.val);
    }

    static ListNode upOrMedium(ListNode node){
        if (node ==null || node.next==null){
            return node;
        }
        ListNode s = node;
        ListNode f = node.next;
        while (f != null && f.next!=null){
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
