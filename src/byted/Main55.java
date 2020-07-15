package byted;

/**
 * lc 剑指offer 36 二叉搜索树 与双向链表
 */
public class Main55 {
    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        Main55 m = new Main55();
        Node ans = m.treeToDoublyList(n4);
        while (ans!=null){
            System.out.println(ans.val);
            ans = ans.right;
        }

    }

    public Node treeToDoublyList(Node root) {
        if (root==null)
            return null;
        Node preAns = pre;
        help(root);
        Node ret = preAns.right;
        ret.left = pre;
        pre.right = ret;
        return ret;
    }
    Node pre = new Node(-1);
    public void help(Node node){
        if (node==null)
            return;
        help(node.left);
        pre.right = node;
        node.left = pre;
        pre = node;

        help(node.right);
    }


}
