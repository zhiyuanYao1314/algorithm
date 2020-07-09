import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈 队列 的三种实现
 * 栈的  数组 链表 双队列 实现
 * 队列的数组 链表 双栈 实现
 */
public class Test4 {

    public static void main(String[] args) {

    }


}
// 2.1 链表实现队列
class Queue{
    class Node {
        int val;
        Node next;
        Node pre;
        Node(int val){
            this.val = val;
        }
    }
    int size =0;
    Node head = new Node(-1);
    Node tail = new Node(-2);
    {
        head.next = tail;
        head.pre =null;
        tail.next = null;
        tail.pre = head;
    }
    void add(int val){
        Node cur = new Node(val);
        Node next = head.next;
        head.next = cur;
        cur.pre =head;
        cur.next = next;
        next.pre = cur;
        size++;
    }
    int remove(){
        // 先判断size
        //
        if (size==0) return -1;
        int ans = tail.pre.val;
        Node pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
        return ans;
    }
    int peek(){
        if (size==0) return -1;
        int ans = tail.pre.val;
        return ans;
    }
}

// 2.2 数组实现队列
class Queue2{
    int[] queue;
    int capacity;
    // 添加所在下标
    int addIndex =0;
    // 移除所在下标
    int removeIndex =0;
    int size =0;
    Queue2(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
    }
    void add(int val){

    }
    int remove(){
        return 0;
    }
    int peek(){
        return 0;
    }


}

// 2.3 双satck实现queue


// 1.1 链表实现栈
class Stack1{
    class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    int size =0;
    Node head = new Node(-1);
    Node tail = new Node(-2);
    void add(int val){
        Node cur = new Node(val);
        Node next = head.next;
        head.next = cur;
        cur.next = next;
        size++;
    }
    void remove(){
        if (size==0) return;
        head.next = head.next.next;
        size--;
    }

    int peek(){
        if (size==0) return -1;
        return head.next.val;
    }
    
}
// 1.2 数组实现栈
class Stack2{
    int[] stack;
    int capacity;
    int index=0; // 下一个要放入的位置
    Stack2(int capacity){
        stack = new int[capacity];
        capacity = capacity;
    }
    void add(int val){
        if (index==capacity)
            return;
        stack[index] = val;
        index++;
    }
    int remove(){
        if (index==0)
            return -1;//
        return stack[--index];
    }

    int peek(){
        if (index==0)
            return -1;//
        return stack[index-1];
    }
}

// 1.3 双queue实现stack
class Stack3{
    Deque<Integer> addQueue = new ArrayDeque();
    Deque<Integer> removeQueue = new ArrayDeque();
    int size =0;
    void add(int val){
        size++;
        addQueue.addLast(val);
    }

    int remove(){
        // 没有
        if (size==0)
            return -1;
        size--;
        while (addQueue.size()!=1){
            removeQueue.addLast(addQueue.removeLast());
        }
        Deque<Integer> tmp = addQueue;
        addQueue = removeQueue;
        removeQueue = tmp;
        return removeQueue.removeLast();

    }

}
