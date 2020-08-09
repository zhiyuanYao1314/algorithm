package kuaishou;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 16:47
 *
 * 最小stack
 */
public class Main8 {
    public static void main(String[] args) {

    }

    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack(); // min

    void put(int n){
        stack.push(n);
        if (minStack.isEmpty()){
            minStack.push(n);
            return;
        }
        minStack.push(Math.min(minStack.pop(), n));
    }
    void get(int n){

    }
    void poll(int n){

    }
    void getMin(int n){

    }

}
