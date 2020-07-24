package others;


import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Main4 m = new Main4();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node c = m.reverseByK(n1,2);
        while (c!=null){
            System.out.println(c.val);
            c = c.next;
        }

    }
    /**
     *  pre a b c d e
     *
     * 1. 每k个加入一个stack，a b c, pre,
     * 2. 反转栈  c b a 返回a作为pre， 链接 next元素d，循环
     */
    static  class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public Node reverseByK(Node n, int k){
        Node pre = new Node(-1);
        // 用于最后返回
        Node retPre = pre;
        Node next;
        Deque<Node> stack = new ArrayDeque();
        Node cur = n;
        int count =0;
        while (cur!=null){
            next = cur.next;
            stack.addLast(cur);
            count++;
            if (count==k){
                count=0;
                pre = reverse(stack, pre);
                pre.next = next;
            }
            cur = next;
        }
        return retPre.next;
    }

    // a b c  pre - c -b -a
    Node reverse(Deque<Node> stack, Node pre){
        while (!stack.isEmpty()){
            Node cur = stack.pollLast();
            pre.next = cur;
            pre = cur;
        }
        return pre;
    }

}
