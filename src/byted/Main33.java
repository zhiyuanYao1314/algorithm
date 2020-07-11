package byted;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23 合并k个排序数组
 *  最小堆 大小k
 */
public class Main33 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        ListNode pre = new ListNode(-1);
        ListNode ansPre = pre;
        PriorityQueue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val -o2.val;
            }
        });
        for (ListNode node: lists){
            if (node !=null)
                heap.add(node);
        }
        while (!heap.isEmpty()){
            ListNode node =heap.poll();
            pre.next = node;
            pre = node;
            if (node.next!=null)
                heap.add(node.next);
        }
        return ansPre.next;
    }

}
