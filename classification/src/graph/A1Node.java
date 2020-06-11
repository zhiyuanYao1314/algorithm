package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/1 17:23
 *
 */
public class A1Node {

    int value;
    int in; // 入度
    int out; // 出度
    List<A1Node> nexts;
    List<A1Edge> edges;

    public A1Node(int value){
        this.value = value;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public A1Node(int value, int in, int out) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
