package unionFind;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 11:52
 *
 * 朋友圈大小
 */
public class A1 {

    public static void main(String[] args) {
        A1 a1 = new A1();
        int[][] ints = new int[][]{{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        int circleNum = a1.findCircleNum(ints);
        System.out.println(circleNum);
    }

    // 记录父节点下面有多少个元素
    Map<Integer, Integer> counts = new HashMap();
    //
    Map<Integer, Integer> ps = new HashMap();

    public int findCircleNum(int[][] M) {
        int n = M.length;// 3
        init(n);
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (M[i][j]==1){
                    union(i,j);
                }
            }
        }
        return counts.size();
    }

    void union(Integer i, Integer j){
        Integer p1 =  findP(i);
        Integer p2 = findP(j);
        if (p1==p2)
            return;
        Integer c1 = counts.get(p1);
        Integer c2 = counts.get(p2);
        Integer small = c1<c2?p1:p2;
        Integer big = c1<c2?p2:p1;
        counts.put(big,c1+c2);
        counts.remove(small);
        ps.put(small, big);
    }

    Integer findP(Integer i){
        Deque<Integer> stack = new ArrayDeque();
        while(i!= ps.get(i)){
            stack.addLast(i);
            i = ps.get(i);
        }
        while (!stack.isEmpty()){
            ps.put(stack.removeLast(),i);
        }
        return i;
    }

    void init(Integer n){
        for (Integer i=0;i<n;i++){
            counts.put(i, 1);
        }
        for(Integer i=0;i<n;i++){
            ps.put(i, i);
        }
    }

}
