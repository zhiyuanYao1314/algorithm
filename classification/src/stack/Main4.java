package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 14:53
 * 队列实现栈
 */
public class Main4 {
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();
    int size =0;
    void put(int n){
        q1.add(n);
        size++;
    }
    int get() throws Exception {
        if (size==0){
            throw new Exception("没有元素");
        }
        int k=-1;
        while (!q1.isEmpty()){
            k = q1.remove();
            q2.add(k);
        }
        q1 =q2;
        q2= new LinkedList();
        size--;
        return k;
    }



}
