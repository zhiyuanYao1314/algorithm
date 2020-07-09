package test;

import java.util.*;

/**
 * 图的表达：
 *  邻接矩阵，邻接表， 其他表达（from, to, weight)
 *  统一表示：
 *      test.Node (int value, List<node> neighbors, List<test.Edge> edges)
 *      test.Edge (int weight, test.Node from, test.Node to);
 *
 * 图的dfs, bfs,
 * 图的有环：dfs（没想清楚？），拓扑排序；
 *
 *
 * 图的最小生成树；
 * 图的单原点最短路径；
 *
 * 图的可达性分析；
 * 图的所有点的最短路径；
 *
 *
 *
 */
public class Test6 {

    public static void main(String[] args) {
    }

    // queue, Set, 进入的时候确保只有一个；
    List<Integer> bfs(Node node){
        Deque<Node> q = new ArrayDeque<>();
        Set<Node> s = new HashSet<>();
        q.addLast(node);
        s.add(node);
        List<Integer> ret = new ArrayList<>();
        while (!q.isEmpty()){
            Node cur = q.removeFirst();
            ret.add(cur.val);
            List<Node> ns = cur.neighbors;
            for (Node n:ns){
                if (s.contains(n))
                    continue;
                q.addLast(n);
                s.add(n);
            }
        }
        return ret;
    }

    // stack
    List<Integer> dfs(Node node){
        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> s = new HashSet<>(); // 已经进入到stack的node；
        stack.addLast(node);
        s.add(node);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()){
            Node cur = stack.removeLast();
            ret.add(cur.val);
            List<Node> ns = cur.neighbors;
            for (Node n:ns){

                if (s.contains(n))
                    continue;
                stack.addLast(n);
                s.add(n);
            }
        }
        return ret;
    }

    // 最小生成树；
    // 1. 每次选最小生成树
    List<Integer> minSpanTree(Node node){
        // 每次从最小的树中选择一个；
        PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        List<Integer> ret = new ArrayList<>();
        List<Edge> edges = node.edges;
        for (Edge e: edges){
            q.add(e);
        }
        while (!q.isEmpty()){
            Edge e = q.poll();
            if (visited.contains(e.to)){
                continue;
            }
            visited.add(e.to); // 访问过了
            ret.add(e.weight); //
        }
        return ret;
    }

    // 2. 单原点最短距离
    Map<Node, Integer> minDistance(Node start, List<Node> nodes){
        //
        PriorityQueue<Node> q = new PriorityQueue(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });
        for (Node n: nodes){
            n.val = Integer.MAX_VALUE;
            q.add(n);
        }
        Map<Node, Integer> ret = new HashMap<>();
        // q不是空的时候;
        while (!q.isEmpty()){
            Node cur = q.poll();
            ret.put(cur, cur.val);
            List<Edge> edges = cur.edges;
            for (Edge e: edges){
                Node to = e.to;
                // 不包含，说明已经弹出去了，不管了
                if (!q.contains(to))
                    continue;
                to.val = Math.min(to.val, cur.val+ e.weight);
                //这里更新优先队列 update q;
            }
        }
        return ret;
    }
}

class Node{
    int val;
    List<Node> neighbors;
    List<Edge> edges;
}

class Edge{
    int weight;
    Node from;
    Node to;
}