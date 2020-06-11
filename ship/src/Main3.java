/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/7 13:23
 * Describe:
 * version:1.0
 */
public class Main3 {
    public static void main(String[] args) {

    }

    public class Node{
        int value;
        Node left;
        Node right;
    }

    public static void pre(Node node){
        if (node == null) return;
        System.out.println(node.value);
        pre(node.left);
        pre(node.right);
    }


}
