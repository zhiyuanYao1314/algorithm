import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 反转链表
 */
public class Test2 {
    static class Node{
        int val;
        Node next;
        Node(int v) {
            val = v;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        Node ans = trverseByK(n1,2);
        while (ans !=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static Node traverse(Node node){
        if (node.next ==null ) return node;
        Node ans = traverse(node.next); // 递归
        Node next = node.next; // 下一个节点指向自己；
        next.next = node;
        node.next = null;
        return ans;
    }

    public static Node traverse2(Node node){
        if (node==null || node.next==null)
            return node;
        Node pre = null;
        Node cur = node;
        Node next = cur.next;
        while (cur!=null){
            next = cur.next; // 用于记录向前推进的
            cur.next =pre;
            pre = cur;
            cur = next; // 循环
        }
        return pre;
    }

    // 对链表每k个反转； 最后返回pre.next
    private static Node trverseByK(Node node, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = node;
        Node pre = new Node(-1);
        pre.next = node;
        Node ansPre = pre;
        Node next ;
        Node start;
        int count=0;
        while (cur !=null){
            next = cur.next;
            stack.addLast(cur);
            count++;
            if (count ==k){
                count=0;
                start = reverseByStack(stack, pre);
                pre.next =start;
                pre = start;
            }
            cur = next;
        }
        return ansPre.next;
    }

    private static Node reverseByStack(Deque<Node> stack, Node pre) {
        Node cur;
        while (!stack.isEmpty()){
            cur = stack.removeLast();
            pre.next = cur;
            pre = cur;
        }
        return pre;
    }

    // 对于迭代，需要一个变量依次向前推进，
    // 对于链表，可以使用next记录下一个节点， 然后每次，next=cur.next; cur = next;
    // 对于递归，while 循环

    // k反转
    // a b c d e   ba dc  e

}
