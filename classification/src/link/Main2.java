package link;


import com.sun.xml.internal.bind.v2.util.FatalAdapter;

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}


//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class Main2 {


    public static void main(String[] args) {

    }
    /**
     * 快慢指针，
     * 假设入口到起始点的距离 x, 相遇点到入口的距离y，
     * 则慢指针走的距离 x+y, 快指针2(x+y),
     * 所以，x+y是 环长度N的倍数，
     * 所以，一个指针从头开始，一个指针从相遇点开始，肯定会在入口处相遇
     *
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 异常情况
        if (pHead == null || pHead.next == null) return null;

        ListNode fast = pHead;
        ListNode slow  = pHead;
        // 找寻相遇点
        do {
         fast = fast.next.next;
         slow = slow.next;
        } while (fast != slow || fast== null);
        // 没有回环
        if (fast== null ) return null;

        // 找寻起始点
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
