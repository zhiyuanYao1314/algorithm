package graph;

import java.beans.Visibility;
import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 17:06
 * Describe:
 * version:1.0
 */
public class A1BFS {

    public static void bfs(A1Node node){
        if(node==null) return;
        Deque<A1Node> q = new ArrayDeque();
        q.addLast(node);
        Set<A1Node> visited = new HashSet<>();
        visited.add(node);
        System.out.println();
        while (!q.isEmpty()){
            A1Node cur = q.removeFirst();
            // 出队列的时候打印；
            System.out.println(cur.value);
            List<A1Node> nexts = cur.nexts;
            for (A1Node n: nexts){
                // 进队列的时候判断唯一性
                if (!visited.contains(n)){
                    q.addLast(n);
                    visited.add(n);
                }
            }
        }


    }

}
