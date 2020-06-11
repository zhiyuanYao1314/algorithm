package graph;

import com.sun.javafx.geom.Edge;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 22:45
 *
 *
 */
public class A1MinSpanTree {

    /**
     * ff1: unionFind K算法
     */
    public static Set<A1Edge> kruskalMST(A1Graph graph){
        Set<A1Edge> ret = new HashSet<>();
        // 0. 把所有的nodes放到unionFind中
        // 1. 把所有的edges按weight从小到大排序；
        // 2. for循环遍历
        // 3. 通过isSameSet判断是否连接起来了，
        // 4. 没有连接的化，edge放入ret中，然后union from和to点
        return ret;
    }
    /**
     * ff2: 贪心算法 Prim算法
     */
    public static Set<A1Edge> PrimMST(A1Graph graph){
        Set<A1Edge> ret = new HashSet<>();
        // 0.优先队列，放入边edge，
        // 1.先放入一个点和它的所有的边；
        // 2. 然后当优先队列不为空的时候，
        // 3. 每次弹出最小值，
        // 4. 如果to点没有访问过，visited加入to点，ret加入edge
        // 5. 在加入to的所有的边；

        return ret;

    }




}
