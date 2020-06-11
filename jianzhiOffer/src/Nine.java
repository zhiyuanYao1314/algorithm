import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 11:35
 * Describe:
 * version:1.0
 */
public class Nine {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 弹出的时候，用到stack2.
     * 如果里面有元素，直接弹出
     * 如果没有元素，先从stack1全部push，在从stack2 pop。
     * @return
     */
    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
}
