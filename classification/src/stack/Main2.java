package stack;


import java.util.Stack;

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class Main2 {
    /**
     * 维护一个stack和一个最小栈。
     * 最小栈只需要存放最小值(最小栈顶，当前放入点)
     */
    public static void main(String[] args) {

    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>(); // 递减栈，新加入的元素比栈顶元素小，就加入，否则不加入
    public void push(int node) {
        stack.push(node);
        minStack.push(minStack.isEmpty()?node:Math.min(minStack.peek(), node));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
