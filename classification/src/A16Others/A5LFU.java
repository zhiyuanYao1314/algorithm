package A16Others;
import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/15 14:34
 *  LFU least frequent use 最低使用频率，
 *  相比于 LRU, least recent use， 多了一个使用频率
 *
 *  构建一个hashmap作为cache缓存， 存储key-value,  value为ListNode。
 *  再构建一个HashMap 作为作为存储使用频率及对应的DoubleLinkedList， 双向链表。
 */
public class A5LFU {

    public A5LFU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity==0) return -1;
        // map.get()
        // if null -1;
        // 1.remove(Node )  minFrequent++,  2.addFirst(frequent, Node) 3.return
        // TODO
        return 0;
    }

    // remove(node ) addFirst(frequent, node) == move2next

    public void put(int key, int value) {
        // get()
        // if !=null node.修改 remove addFist()
        // null addNew(); map.size>cap move(minFrequent);
    }



    int capacity;
    // 存储缓存，直接get获取！
    HashMap<Integer,ListNode> cache = new HashMap();
    class ListNode{
        int key;
        int value;
        int frequent;
        ListNode pre;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    // key为访问的频率，value为
    HashMap<Integer,DoubleLinkedList> frequentCache = new HashMap();
    class DoubleLinkedList{
        ListNode head, tail;
        int count =0;
        DoubleLinkedList(){
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-2);
            head.next = tail;
            tail.pre = head;
        }
    }
}
