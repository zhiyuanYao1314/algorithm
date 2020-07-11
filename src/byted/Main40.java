package byted;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/**
 * 155 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 再加一个stack， 每次push的时候，从原来stack中peek（） 选最小的放入
 */
public class Main40 {


}

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int size=0;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (size==0){
            minStack.push(x);
        }else
            minStack.push(Math.min(minStack.peek(), x));
        size++;
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        size--;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
