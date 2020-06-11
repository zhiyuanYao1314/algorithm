package graph;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/1 17:24
 * 图： 包含所有点的集合和边的集合
 */
public class A1Graph<T> {
    Map<T, A1Node> nodes;
    Set<A1Edge> edges;
    public A1Graph() {
        this.nodes =new HashMap<>();
        edges = new HashSet<>();
    }
}
