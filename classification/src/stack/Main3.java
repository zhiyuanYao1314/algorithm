package stack;

import javax.swing.*;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 13:01
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class Main3 {
    /**
     * 两个栈 一个pushStack ,一个popStack.
     */
    Stack<Integer> pushStack = new Stack();
    Stack<Integer> popStack = new Stack();
    int size =0;

    public void appendTail(int value) {
        pushStack.add(value);
        size++;
    }

    public int deleteHead() {
        if (size==0) return -1;
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        size--;
        return popStack.pop();
    }
}
