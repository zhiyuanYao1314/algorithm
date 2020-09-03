package unionFind;
import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/1 17:35
 * 并查集: 要求：
 *  复杂度O(1) 实现 isSameSet 和uion操作
 */
public class UnionFind<T> {

    // 所有的T的集合
    Set<T> sets;

    // 映射父节点；
    Map<T, T> parents;

    // 集合数量， 只记录父节点和集合的数量；
    Map<T, Integer> counts;

    public UnionFind(T[] nums) {
        this.sets = new HashSet<>();
        // 添加所有的nums
        for (T t: nums){
            sets.add(t);
        }
        parents = new HashMap<>();
        // 父为自己
        for (T t: nums){
            parents.put(t, t);
        }

        counts = new HashMap<>();
        // 数量为1
        for (T t: nums){
            counts.put(t, 1);
        }
    }

    T findParent(T t){
        Deque<T> stack = new ArrayDeque<>();
        while (t != parents.get(t)){
            stack.addLast(t);
            t = parents.get(t);
        }
        // 扁平化处理
        while (!stack.isEmpty()){
            parents.put(stack.removeLast(),t);
        }
        return t;
    }

    boolean isSameSet(T t1, T t2){
        //1. set.contain
        if (t1==null || t2==null ||
            !sets.contains(t1) || !sets.contains(t2)){
            return  false;
        }
        // 2. 看parent是否相同
        if (findParent(t1)==findParent(t2))
            return true;
        return false;
    }

    void union(T t1, T t2) {
        // 1. 查找
        // 没找到，
        if (t1==null || t2==null || !sets.contains(t1) || !sets.contains(t2))
            return;

        // 2.找父节
        if (findParent(t1)==findParent(t2))
            return;
        // 3. 父不一样
        t1 = findParent(t1);
        t2 = findParent(t2);
        int c1 = counts.get(t1);
        int c2 = counts.get(t2);
        T cSmall = c1>c2?t2:t1;
        T cBig = c1<c2?t2:t1;
        counts.put(cBig, c1+c2);
        counts.remove(cSmall);
        parents.put(cSmall, cBig);
    }

    // 效率问题
    void delete(){

    }


}
