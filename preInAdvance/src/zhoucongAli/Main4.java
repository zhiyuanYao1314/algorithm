package zhoucongAli;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/4 1:19
 * Describe:
 * version:1.0
 */

public class Main4 {
    public static void main(String[] args) {
        // 测试
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node node = removeLastK(n1, 5);// 删除倒数第二个元素
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 第一题思路:
     * 1.通过双指针s,e定位到倒数第k个元素的前一个元素，
     * 2. 再通过s.next = s.next.next删除倒数第k个元素
     */
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    /**
     *
     * k表示倒数第k个数
     */
    static Node removeLastK(Node node, int k){
        Node ans = node;
        Node start = node;
        Node end = node;
        for (int i=0;i<k+1;i++){
            if (end==null && i==k){ // 删除第一个元素
                return ans.next;
            }
            if (end==null && i<k){
                return null; // 表示k大于链表的长度
            }
            end = end.next;
        }
        while (end!=null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return ans;
    }
}
