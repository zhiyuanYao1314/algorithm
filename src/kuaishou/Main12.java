package kuaishou;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 19:57
 * 两个栈实现 队列
 */
public class Main12 {
    public static void main(String[] args) {

    }

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    int size =0;

    public void put(int n){
        s1.push(n);
        size++;
    }

    public int get(){
        if (size<=0)
            return -1;
        if (s1.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        int ret = s2.pop();
        size--;
        return ret;
    }
}