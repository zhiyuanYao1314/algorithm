package test;

/**
 * 1. 链表判断 是否有环 快慢指针，while 快指针不为null， 快慢指针是否相等；
 * 2. 环的入口处： 快指针从头开始， 相等的时候
 * 3. 判断回文链表
 * 4.
 */
public class Test3 {

    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        n1.next =n2;
        n2.next =n3;
        boolean is = isPa(n1);
        System.out.println(is);
    }
    // 1。是否环
    public static boolean isCycle(Node node){
        Node slow = node;
        Node fast = node;
        while (fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    // 2。环的入点
    public static Node CycleIn(Node node){
        Node slow = node;
        Node fast = node;
        while (fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast != slow){
            return null;
        }
        fast = node;
        while (fast !=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 3。 判断回文 方法1：stack：空间浪费； 方法2： 快慢指针+反转

    public static boolean isPa(Node node){
        // 特殊
        if (node==null || node.next ==null)
            return true;
        // 2。 快慢 取慢
        Node s = node;
        Node f = node.next;
        // 3。 反转
        while (f !=null && f.next !=null){
            f = f.next.next;
            s = s.next;
        }
        Node reverseStart = s.next;
        s.next =null;
        Node s2 = reverse(reverseStart);
        // 4。对比 s2在奇数的时候少一个点
        Node s1 = node;
        while (s2 !=null){
            if (s1.val !=s2.val){
                return false;
            }
            s1 = s1.next;
            s2 = s2.next;
        }
        return true;
    }

    private static Node reverse(Node node) {
        if (node.next==null)
            return node;
        Node ans = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return ans;
    }
}
