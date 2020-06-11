package recursion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/1 21:42
 * Describe:
 * version:1.0
 */
public class Main1 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        Node r1 = reverse(n1);
        while (r1 !=null) {
            System.out.println(r1.value);
            r1 = r1.next;
        }
    }
    private static class Node{
        int value;
        Node next;
        public Node(int vale){
            this.value = vale;
        }
    }

    public static Node reverse(Node root){
        if (root == null || root.next == null) return root;
        Node t1 = reverse(root.next);
        root.next.next= root;
        root.next= null;
        return t1;
    }

}
