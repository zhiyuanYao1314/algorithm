package graph;

import com.sun.deploy.util.UpdateCheck;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 23:32
 * Dijkstra
 */
public class A1Dijkstra {

    public static HashMap<A1Node, Integer> dijkstra(A1Graph graph,A1Node node){
        HashMap<A1Node, Integer> ret = new HashMap<>();
        // 1. 最小堆，放的是节点Node, 每个Node有一个weight， 记录到愿点node的距离；
        // 2. 当最小堆不是空
        // 3. 每次弹出一个node，
        // 4. 更新所有临界节点的weight到最小堆中，
        // 5.
        PriorityQueue<A1Node> pq = new PriorityQueue<>(new Comparator<A1Node>() {
            @Override
            public int compare(A1Node o1, A1Node o2) {
                return o1.value-o2.value; // 按value值从小到大排序；
            }
        });
        Set<A1Node> visited = new HashSet<>();
        pq.add(node);
        visited.add(node);
        while (!pq.isEmpty()){
            A1Node cur = pq.poll();
            ret.put(cur, cur.value);
            // 更新所有边连接的下一个点；
            List<A1Edge> edges = cur.edges;
            for (A1Edge edge:edges){
                A1Node toNode = edge.to;
                toNode.value = Math.min(toNode.value, cur.value+ edge.weight);
                update();// 更新最小堆；
            }
        }
        return ret;
    }

    static void update(){

    }


}
