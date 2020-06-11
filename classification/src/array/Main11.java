package array;

/**
 * Time:2020/4/21 20:29
 * 连续子序列的最大和
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 */

public class Main11 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0) return 0;
        int max=array[0];
        int sum =0;
        for (int i=0;i<array.length;i++){
            if (sum>=0) sum +=array[i];
            else sum = array[i];
            if (sum>max) max = sum;
        }
        return max;
    }
}
