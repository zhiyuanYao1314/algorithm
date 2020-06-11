package graph;

import java.util.Set;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/3 21:31
 */
public class A1Cycle {

    /**
     * 方法1： dfs的时候判断，某个点是否已经访问过了；
     */
    boolean isCycle(A1Node node){

        return  false;

    }

    void dfs(A1Node node, Set<A1Node> path ){

    }

    /**
     * 方法2: 拓扑排序；
     *
     * 从图种删除入度为0的点，加入到栈种，
     * 知道栈为空，图种还有点 就是有环
     *
     */

}
