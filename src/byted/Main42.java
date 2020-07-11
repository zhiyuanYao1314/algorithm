package byted;

import java.util.HashMap;

/**
 * 460 LFU缓存
 */
public class Main42 {
}

/**
 * HashMap (key- Node节点)
 * HashMap(key-Node链表)
 * minFreq
 *
 */
class LFUCache {
    int capacity;
    int size;
    int minFrequent;
    class  Node{
        int key;
        int value;
        int frequent;
        Node pre;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
    HashMap<Integer, Node> findMap;
    HashMap<Integer, Node> frequencyMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        findMap = new HashMap<>();
        frequencyMap = new HashMap<>();
    }


    /**
     * find.get(key)
     * ==null; return -1;
     * != return
     * moveToNextFreq(node);
     *
     *
     */
    public int get(int key) {
        Node n = findMap.get(key);
        if (null==n)
            return -1;
        moveToNextFrequency(n);
        return n.value;
    }

    void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    void addToNextFreq(Node node){
        int freq = node.frequent+1;
        Node head = frequencyMap.get(freq);
        // 添加
        if (head!=null){
            Node next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
            // 新建node
        }else {
            head = new Node(-1,-1);
            Node tail = new Node(-1,-1);
            head.next = node;
            node.pre = head;
            node.next = tail;
            tail.pre = node;
            frequencyMap.put(freq, head);
        }
    }

    void moveToNextFrequency(Node node){
        removeNode(node);
        addToNextFreq(node);
    }

    void insertNewNode(Node node){
        node.frequent =0;
        addToNextFreq(node);
    }
    /**
     * frequencyMapvalue需要记录链表的head和tail
     * 方便进行操作！
     */

    void moveMinFrequent(){
        // 假设做完了
//        frequencyMap.get()
    }

    /**
     * 新点的频率是1；
     *
     * head最新-- tail时间最老
     * findMap有，
     *  对应修改值
     *  moveToNextFreq(node);
     *      // 删除当前点；
     *      // 添加到下一个frequent点，如果有，插入到head后，如果没有，new Head，插入；
     * 没有，
     *  size<capacity:
     *      new Node();
     *      findMap.put();
     *      insertNewNode(node);
     *          // 添加到当前frequent点，如果有，插入到head后，如果没有，new Head，插入；
     *  size==capacity
     *      moveMinFrequent();
     *          // 删除时间最老的点；
     *      insertNewNode(node);
     */
    public void put(int key, int value) {

    }
}