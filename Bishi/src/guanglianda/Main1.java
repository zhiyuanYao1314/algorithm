package guanglianda;

import java.util.LinkedList;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 11:49
 * 链表的中间节点
 *
 */

public class Main1 {
    class LinkedNode{
        int val;
        LinkedNode next;
        LinkedNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
    }

    public LinkedNode getMiddleNode(LinkedNode node){
        if (node== null) return null;
        if (node.next == null) return node;

        LinkedNode slow = node;
        LinkedNode fast = node.next;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
