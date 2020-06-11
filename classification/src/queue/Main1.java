package queue;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 15:11
 * 实现栈实现队列
 *
 */
public class Main1 {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    int size=0;
    void put(int n){
        s1.add(n);
        size++;
    }
    int get(){
        if (size==0)
            throw new RuntimeException("空！");
        if (s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        size--;
        return s2.pop();
    }
}
