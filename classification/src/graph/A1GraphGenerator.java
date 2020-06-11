package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 16:47
 * 图的生成器
 */
public class A1GraphGenerator {
    //
    // N*3的矩阵
    // [weight, from, to];
    public static A1Graph createGraph(Integer[][] matrix){
        A1Graph<Integer> graph = new A1Graph();
        int n = matrix.length;
        for (int i=0;i<n;i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new A1Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new A1Node(to));
            }
            A1Node fromNode = graph.nodes.get(from);
            A1Node toNode = graph.nodes.get(to);
            A1Edge edge = new A1Edge(weight, fromNode, toNode);
            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            toNode.in++;
            graph.edges.add(edge);
        }
        return graph;
    }

}
