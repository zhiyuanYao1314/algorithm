package byted;

import java.util.HashMap;
import java.util.Map;

/**
 * 146 LUR缓存机制
 *获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 */
public class Main8 {

}

class LRUCache{

    int capacity;
    Map<Integer, Node> map =new HashMap<>();
    Node head;
    Node tail;
    int size=0;

    class  Node{
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value =value;
        }
    }

    LRUCache(int capacity){
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    void deleteLast(){
        Node pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    void addNode(Node node){
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    void deleteNode(Node node){
        
    }


    void moveToHead(Node node){


    }

    public int get(int key){
        Node cur = map.get(key);
        if (cur==null){
            return -1;
        }
        moveToHead(cur);
        return cur.value;
    }

    public void put(int key,int  value){
        Node cur =map.get(key);
        //
        if(cur!=null){
            cur.value = value;
            moveToHead(cur);
            return;
        }else{
            if (size==capacity){
                deleteLast();
                size--;
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addNode(newNode);
            size++;
        }
    }
}
