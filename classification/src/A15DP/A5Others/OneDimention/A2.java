package A15DP.A5Others.OneDimention;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 12:59
 * 823. 带因子的二叉树
 *给出一个含有不重复整数元素的数组，每个整数均大于 1。
 *
 * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
 *
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 *
 * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
 *
 *
 * 解法：
 *  排序后，每一个元素，依赖于前面几个元素的值，具有传递性，所以，可以进行dp；
 *
 */
public class A2 {
    public static void main(String[] args) {
        A2 a4 = new A2();
//        int[] ints = {2,4};
        int[] ints = {2,4,5,10,20};
        // int[] ints = {2,3,5,6,15,30}; //1 1 1 3
        int i = a4.numFactoredBinaryTrees(ints);
        System.out.println(i);
    }

    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        HashMap<Integer, Integer > loc = new HashMap<>();
        for (int i=0;i<A.length;i++){
            loc.put(A[i], i);
        }
        // 以当前元素为根节点的元素树共有多少种；
        HashMap<Integer,Long> ans = new HashMap();
        for (int i=0;i<A.length;i++){
            ans.put(A[i], 1L);
        }
        for (int i=0;i<A.length;i++){
            Long sum =1L;
            for (int j=0;j<i;j++){ //A[j]第一个因子； 4 2
                if (A[i]%A[j]!=0) continue;
                int other = A[i]/A[j];
                if (loc.get(other)==null)
                    continue;
                sum += ans.get(A[j])*ans.get(other);
                ans.put(A[i], sum);
            }
        }
        Long sum=0L;
        for (Long e:ans.values()){
            sum +=e;
        }
        return (int)(sum%(1_00000000_7));
    }
}
