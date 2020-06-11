package link;

import java.nio.channels.ClosedChannelException;
import java.util.Random;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Main8 {
    public static void main(String[] args) {
        Main8 main8 = new Main8();
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        RandomListNode r5=new RandomListNode(5);
        r1.next =r2;
        r2.next =r3;
        r3.next =r4;
        r4.next =r5;
        r1.random = r3;
        r2.random = r5;
        r4.random = r2;
        System.out.println(main8.Clone(r1).label);
    }

    public RandomListNode Clone(RandomListNode pHead){
        cloneNext(pHead);
        cloneRandom(pHead);
        return getRandom(pHead);
    }
    public void cloneNext(RandomListNode cur){
        if (cur==null) return;
        RandomListNode c = new RandomListNode(cur.label);
        c.next = cur.next;
        cur.next= c;
        cloneNext(c.next);
    }

    public void cloneRandom(RandomListNode cur){
        if (cur==null) return;
        RandomListNode copy = cur.next;
        if (cur.random !=null)
            copy.random = cur.random.next;
        cloneRandom(cur.next.next);
    }

    public RandomListNode getRandom(RandomListNode cur){
        if (cur==null) return null;
        RandomListNode copy = cur.next;
        cur.next = copy.next;
        if (cur.next !=null){
            copy.next = cur.next.next;
        }else copy.next = null;
        getRandom(cur.next);
        return copy;
    }
}
