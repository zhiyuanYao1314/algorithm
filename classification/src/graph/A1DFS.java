package graph;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 22:18
 * Describe:
 * version:1.0
 */
public class A1DFS {

    public static void main(String[] args) {
        A1Node n1 = new A1Node(1);
        A1Node n2= new A1Node(2);
        A1Node n3 = new A1Node(3);
        A1Node n4 = new A1Node(4);
        n1.nexts.add(n2);
        n2.nexts.add(n3);
        n1.nexts.add(n4);
        dfs(n1);

    }
    public static void dfs(A1Node node){
        Deque<A1Node> stack = new ArrayDeque<>();
        stack.add(node);
        Set<A1Node> visited =new HashSet<>();
        visited.add(node); // 进栈表示访问过了
        while (!stack.isEmpty()){
            A1Node cur =stack.removeLast();
            // 出栈的时候打印；
            System.out.println(cur.value);
            List<A1Node> nexts = cur.nexts;
            for (A1Node next: nexts){
                // 入栈的时候检验访问过；
                if (!visited.contains(next)){
                    stack.addLast(next);
                    visited.add(next);
                }
            }
        }

    }
}
