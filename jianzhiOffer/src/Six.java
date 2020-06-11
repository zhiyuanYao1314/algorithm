import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 9:35
 * Describe:
 * version:1.0
 */

public class Six {

    /**
     * 总结：
     * 1. 从尾到头，使用stack 或者 递归;
     * 2. JAVA中的数据结构：int[], arrayList, Stack, Queue, PriorityQueue，
     *    Tree, Graph
     * 3.
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode current = listNode;
        // 将点放入到栈中
        Stack<Integer> stack = new Stack();
        while (current != null){
            stack.push(current.val);
            current = current.next;
        }
        ArrayList<Integer> list  = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 使用递归:
     *  传递的参数和返回值，还有退出条件。
     * time: length,
     * space: length.
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (listNode == null) return arr;
        arr.addAll(printListFromTailToHead2(listNode.next));
        arr.add(listNode.val);
        return arr;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;

        Six six = new Six();
        System.out.println(six.printListFromTailToHead(ln1));
        System.out.println(six.printListFromTailToHead2(ln1));

    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode (int val){
            this.val = val;
        }
    }

}


