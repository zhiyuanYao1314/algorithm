package quNaEr;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] pre = new int[num]; // 1 2 4 5 3
        int[] order = new int[num]; // 4 2 5 1 3
        for (int i=0;i<num;i++){
            pre[i] = sc.nextInt();
        }
        for (int i=0;i<num;i++){
            order[i] = sc.nextInt();
        }
        int pl=0,ol=0, pr=num-1,or=num-1;
        Node node = build(pre, order, pl,pr,ol,or);

        level(node);
    }
    public static class Node{
        public int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static void level(Node root){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left!= null) queue.offer(node.left);
            if (node.right!= null) queue.offer(node.right);
            System.out.print(node.value+" ");
        }
    }

    public static Node build(int[] pre,int[] order,int pl,int pr,int ol,int or){
        if (pr<pl){
            return null;
        }
        Node root = new Node(pre[pl]);
        int index = 0;
        for (int i=ol;i<=or;i++){
            if (order[i]==root.value){
                index=i;
            }
        }
        int leftLen =index-ol;
        root.left= build(pre, order,pl+1,pl+leftLen,ol,ol+leftLen-1);
        root.right= build(pre, order,pl+leftLen+1,pr,ol+leftLen+1,or);
        return root;
    }
}
