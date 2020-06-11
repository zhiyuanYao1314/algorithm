package A13KwayMerge;


import java.util.PriorityQueue;
import java.util.logging.Level;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 11:02
 *
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

    /**
     * 使用heap进行 kway归并；
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((o1,o2)-> (((ListNode)o1).val-((ListNode)o2).val));
        for (ListNode node: lists)
            if (node != null) minHeap.add(node);
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while (!minHeap.isEmpty()){
            ListNode cur = minHeap.poll();
            pre.next = cur;
            if (cur.next!=null) minHeap.add(cur.next);
            pre = cur;
        }
        return ans.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        ListNode node =merge(lists, 0,lists.length-1);
        return node;
    }

    private ListNode merge(ListNode[] lists, int s, int e) {
        if (s>=e) return lists[s];
        int mid = (s+e)/2;
        ListNode m1 = merge(lists, s, mid);
        ListNode m2 = merge(lists, mid + 1, e);
        ListNode ans = mergeTwoList(m1, m2);
        return ans;
    }

    /**
     * 递归
     */
    private ListNode mergeTwoList2(ListNode m1, ListNode m2) {
        if ( m1 == null) return m2;
        if ( m2 == null) return m1;
        if (m1.val>m2.val){
            m2.next = mergeTwoList2(m1, m2.next);
            return m2;
        }else {
            m1.next = mergeTwoList2(m1.next, m2);
            return m1;
        }
    }
    /**
     * 迭代
     */
    private ListNode mergeTwoList(ListNode m1, ListNode m2) {
        ListNode ans = new ListNode(0);
        ListNode pre =ans;
        while (m1 != null && m2 !=null){
            ListNode smaller ;
            if (m1.val>m2.val) {
                smaller=m2;
                m2 = m2.next;
            }
            else {
                smaller=m1;
                m1 = m1.next;
            }
            pre.next = smaller;
            pre = smaller;
        }
        if (m1==null){
            while (m2!=null){
                pre.next = m2;
                pre = m2;
                m2 = m2.next;
            }
        }else {
            while (m1!=null){
                pre.next = m1;
                pre = m1;
                m1 = m1.next;
            }
        }
        return  ans.next;
    }

    //


}
