package graph;
import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 22:26
 * Topological 拓扑排序
 *
 *
 */

public class A1Topo {
    // 给定的Node是入度为0的点
    public static void topologic( A1Node node){
        Deque<A1Node> q = new ArrayDeque<>();
        q.addLast(node);
        Set<A1Node> visited = new HashSet<>();
        visited.add(node);
        while (!q.isEmpty()){
            A1Node cur = q.removeFirst();
            System.out.println(cur.value);
            List<A1Node> nexts = cur.nexts;
            for (A1Node next: nexts){
                next.in--; // 入度为0且没有访问过
                if (next.in==0 && !visited.contains(next)){
                    q.addLast(next);
                    visited.add(next);
                }
            }
        }
    }
}