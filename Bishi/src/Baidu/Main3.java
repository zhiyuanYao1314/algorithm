package Baidu;

import java.util.Scanner;
public class Main3 {

    public static class Node{
        int key;
        int value;
        Node left;
        Node right;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Node[] nodes = new Node[num];
        for (int i=0;i<num;i++){
            nodes[i] = new Node(i, sc.nextInt());
        }
        // 构建树
        sc.nextLine();
        while (sc.hasNextLine()){
            try{
                String s = sc.nextLine();
                String[] ss = s.split(" ");
                int i1 = Integer.parseInt(ss[0])-1;
                int i2 = Integer.parseInt(ss[1])-1;
                if (nodes[i1].left !=null){
                    nodes[i1].left = nodes[i2];
                }else nodes[i1].right = nodes[i2];
            }catch (NumberFormatException e){
                break;
            }

        }
        // 找最长。
        Node root = nodes[0];
        System.out.println(max(root)+1);
    }

    public static int max(Node node){
        int res =0;
        int value1=0;
        int value2=0;
        if (node == null) return 0;
        if (node.right != null && node.value<node.right.value){
            value1 = max(node.right)+1;
        }
        if (node.left != null && node.value<node.left.value){
            value2 = max(node.left)+1;
        }
        return Math.max(value1,value2);
    }
}
