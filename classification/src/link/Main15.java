package link;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 13:28
 * 复制一个含有随机节点的链表
 */
public class Main15 {

    // 方法1:一个hashmap，
    // time: O(N);
    // space: O(N);

    static class ListNode {
        int val;
        ListNode next;
        ListNode random;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 方法 1： 使用一个hashmap， 映射源链表和新的链表之间的一一对应关系，
     *          这样可以根据源链表找到新的链表
     *      复杂度:
     *      time N, space: N
     */
    static ListNode copy1(ListNode node){
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode head = node;
        ListNode ans = head;
        // 步骤1： 复制,并放入map
        while (node!=null){
            ListNode cur = new ListNode(node.val);
            map.put(node, cur);
            node = node.next;
        }
        // 步骤2: 复制对应的next和random！
        while (head!=null){
            ListNode cur = map.get(head);
            cur.next = map.get(head.next);
            cur.random = map.get(head.random);
            head = head.next;
        }
        return map.get(ans);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n2.random = n1;
        n3.random = n1;
        ListNode ans= copy1(n1);
        while (ans!=null ){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
    /**
     *  方法2： 复制一遍源节点到新的节点，这样可以找到源节点的对应节点；
     *  复杂度一样， 但是不使用hashmap
     */
    static ListNode copy2(ListNode node){
        // 1. 复制每个节点到该节点的next， 并连接起来1-1-2-2-3-3-null
        ListNode next = null;
        ListNode cur = node;
        while (cur != null){
            next = cur.next;
            ListNode copyNode = new ListNode(cur.val);
            cur.next = copyNode;
            copyNode.next = next;
            cur = next;
        }
        // 1-1-2-2-null;
        // 2. 复制random节点；
        cur = node;
        while (cur !=null){
            ListNode copy = cur.next;
            ListNode n = copy.next;
            copy.random = cur.random.next;
            cur = n;
        }
        // 3. 拆分开来
        cur = node;
        // 1 1 2 2 null
        ListNode ret = node.next;
        while (cur!=null){
            ListNode copy = cur.next;
            ListNode n = copy.next;
            cur.next = n;
            copy.next = n==null?null: n.next;
            cur = n;
        }
        return ret;
    }
}
