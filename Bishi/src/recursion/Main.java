package recursion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/1 12:33
 * Describe:
 * version:1.0
 */
public class Main {

    public static class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        Node er = reverse(n1);
        while (er != null){
            System.out.println(er.value);
            er= er.next;
        }
    }

    /**
     * 链表反转--递归
     *
     * 1. 退出条件，最简化的情况
     * 2. 递推关系式和处理
     * 3.
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        if (node == null || node.next==null) return node;
        Node tmp = reverse(node.next);
        node.next.next=node;
        node.next = null;
        return tmp;
    }
}
