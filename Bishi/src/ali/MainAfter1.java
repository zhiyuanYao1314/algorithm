package ali;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. 每天减少最大的值，想到有限队列，
 * 2. java中的优先队列 PriorityQueue,改成最大堆 构造的时候new Comparator()...
 * 3.
 * 3.
 */
public class MainAfter1 {
    public static void main(String[] args) {
        int[] n = new int[]{1,3,5};
        int m = 3;
        int k = 2;
        System.out.println(remainChicken(n,m,k));

    }
    /**
     * @param n n个鸡场；
     * @param m m天后鸡的数量；
     * @param k 每天每个鸡场增加k只鸡；
     * @return
     */
    public static int remainChicken(int[] n, int m, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0;i<n.length;i++){
            pq.add(n[i]);
        }

        for (int i =1;i<=m; i++){
            int max = pq.poll();
            max = max - (max+k*i)/2;
            pq.add(max);
        }
        int sum =0;
        while (! pq.isEmpty()){
            sum += pq.poll();
        }
        return sum + m*n.length*k;
    }
}
