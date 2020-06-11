package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/1 17:23
 * 图的所有的边
 */
public class A1Edge {
    int weight;
    A1Node from;
    A1Node to;
    A1Edge(int weight, A1Node from, A1Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
