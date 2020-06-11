package others;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 15:28
 * Describe:
 * version:1.0
 */
public class Move {

    // 二分 搬家
    // n 3 居民   1
    // m 2 搬家方案  350
    //  1,2,4,7,10,11 [14468928]
    //  5 8. [-31660160,99822800,-21227235,-58629996,-241390382,....

    public static void main(String[] args) {
        Move move = new Move();
        int n=5;
        int m =14;
        int[] a = new int[]{175202325,305348361,18225345,1076950,259307096};
        int[] x = new int[]{-435704854,-196047871,-40657348,-638779837,289329995,-324718544,
                -115340400,-93351250,160595325,-236468688,719489458,140189548,-54757692,-48347010};
        int[] ss = move.solve(n,m,a,x);
        System.out.println(Arrays.toString(ss));
    }

    /**
     *
     *
     * 注意：
     * 1. 是否预先排好序，
     * 2. 二分查找的递归和循环写法
     * 3. 二分查找的最近距离修改版本。
     * @param n
     * @param m
     * @param a
     * @param x
     * @return
     */
    public int[] solve (int n, int m, int[] a, int[] x) {
        Arrays.sort(a);
        int[] ans = new int[m];
        for (int i=0;i<m;i++){
            ans[i] = binarySearchMinDistance(a,x[i]);
        }
        return ans;
    }

    /**
     *
     * @param x
     * @param target
     * @return
     */
    public int binarySearchMinDistance (int[] x , int target){
        int start =0;
        int end =x.length-1;
        int min =Integer.MAX_VALUE;
        int dis;
        while (start<=end){
            int mid = (start+end)/2;
            if (target > x[mid]){
                dis = target- x[mid];
                if (dis<min) min = dis;
                start = mid+1;
            }else{
                dis = x[mid]- target;
                if (dis<min) min = dis;
                end = mid-1;
            }
        }
        return min;
    }

    /**
     * 递归版本 二分查找
     * @param x
     * @param tar
     * @param start
     * @param end
     * @return
     */
    public int bs (int[] x , int tar, int start, int end){
        if (start>end) return -1;
        int mid = (start+end)/2;
        if (tar == x[mid]) return mid;
        if (tar > x[mid]) return bs (x, tar,mid+1 , end);
        else return bs (x, tar,start ,mid-1);
    }

    /**
     * while循环 二分查找
     * while的条件控制循环条件；
     *
     * @param x
     * @param target
     * @return
     */
    public int binarySearch(int[] x, int target){
        int begin =0;
        int end = x.length;
        while (begin<=end){
            int mid = (begin+end)/2;
            if (x[mid]<target){
                begin = mid+1;
            }else if (x[mid] == target){
                return mid;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
}
