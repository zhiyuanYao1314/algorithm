package graph;

import java.util.*;

/**
 * 图的DFS BFS
 */

public class Main1 {
    public static class Node{
        int node;
        int value;
        public Node(int i, int j) {
            node =i;
            value=j;
        }
    }

    public static void main(String[] args) {
        // BFS();
        // DFS();
        System.out.println(minDistance(0,3));
    }
    static int[][] graph = new int[][]{
            {0,1,1,0},
            {0,0,0,8},
            {0,0,0,3},
            {0,0,0,0}
    };

    // 拓扑排序
    /**
     * 一个queue 放入每个node及其入度。
     * 依次弹出入度为0的点。。。
     */

    /**
     *所有点最短路径
     * DP
     */
    static int[][] allMinDistance(){
        // 垫脚石
        int[][] ans = new int[graph.length][graph.length];
        for (int i=0;i<graph.length;i++){
            for (int j=0;j<graph.length;j++){
                for (int k=0;k<graph.length;k++){
                    if (graph[i][k]>0 && graph[k][j]>0){
                        ans[i][j] = Math.min(ans[i][j], graph[i][k]+graph[k][j]);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 迪杰斯特拉 求最短路径
     * 贪婪
     */
    static int minDistance(int start, int end){
        int[] ans = new int[graph.length];
        boolean[] marked = new boolean[graph.length];
        // 建立优先队列 用于存放所有点的距离，需要自己定义Node，并指定Comparator。
        PriorityQueue<Node> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Node)o1).value - ((Node)o2).value;
            }
        });
        Node node = new Node(start, 0);
        queue.add(node);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            if (n.node==end){
                return n.value;
            }
            for (int i=0;i<graph.length;i++){
                if (graph[n.node][i]>0 && !marked[i]){
                    Node newN = new Node(i, n.value + graph[n.node][i]);
                    queue.add(newN);
                }
            }
        }
        return 0;
    }
    /**
     * stack, 递归
     */
    public static void DFS(){
        //
        boolean[] marked = new boolean[graph.length];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if (marked[cur]) continue;
            marked[cur] =true;
            System.out.println(cur);
            for (int i=0;i<graph.length;i++){
                if (graph[cur][i]!=0 && !marked[i]){
                    stack.push(i);
                }
            }
        }
    }

    /**
     * queue
     */
    public static void BFS(){
        boolean[] marked = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            if (marked[cur]) continue;
            marked[cur] = true;
            System.out.println(cur);
            for (int i=0;i<graph.length;i++){
                if (graph[cur][i] != 0 && !marked[i]){
                    queue.add(i);
                }
            }
        }
    }
}
