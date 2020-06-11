package A16Others;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/15 11:46
 * Leetcode146. LRU缓存机制
 * 在O(1)的复杂度
 */
public class A4LRU {
    public static void main(String[] args) {
        A4LRU test = new A4LRU(3);
        test.put(1,1);
        test.put(2,2);
        test.put(3,3);
        test.get(1);
        test.put(4,4); //3 1 4
        System.out.println(test.get(2));
        System.out.println(test.get(3));
    }

    class Node{
        int key;
        int val;
        Node left;
        Node right;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    int size =0;

    HashMap<Integer, Node> map = new HashMap<>();
    public A4LRU(int capacity) {
        this.capacity = capacity;
        head.right= tail;
        tail.left=head;
    }

    // 在尾部添加一个元素
    private void add(Node node){
        node.right = tail;
        node.left = tail.left;
        tail.left.right = node;
        tail.left= node;
    }


    private void remove(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
    }

    // 移除头部的一个元素
    private Node removeFirst(){
        Node node = head.right;
        remove(node);
        return node;
    }

    private void removeToTail(Node node){
        remove(node);
        add(node);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node==null) {
            return -1;
        }else {
            removeToTail(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node==null){
            Node cur = new Node(key, value);
            map.put(key, cur);
            add(cur);
            size++;
            if (size>capacity){
                size--;
                Node node1 = removeFirst();
                map.remove(node1.key);
            }
        }else {
            node.val= value;
            removeToTail(node);
        }
    }
}