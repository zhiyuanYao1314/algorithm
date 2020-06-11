package A16Others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/15 15:23
 * Describe:
 * version:1.0
 */
public class A6 {
    public static void main(String[] args) {


    }

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }


    public Node test(Node a, Node b){
        Node pre = new Node(-1);
        Node head = pre;
        while (a != null && b!=null){
            Node cur = new Node(a.val + b.val);
            pre.next = cur;
            pre = cur;
            a = a.next;
            b = b.next;
        }
        if (a==null)
            pre.next = b;
        else pre.next = a;
        return head;
    }
}
