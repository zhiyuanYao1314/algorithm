package kuaishou;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 16:17
 * 链表环的入口
 */
public class Main5 {

    class Node{
        int val;
        Node next;
    }
    Node inCycle(Node node){
        Node slow = node;
        Node fast = node;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow){
                break;
            }
        }
        if (fast!=slow){
            return null;
        }
        slow = node;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
