package A1SlidingWindow;

import java.util.LinkedList;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 17:40
 * 长度为k的 最大子序列之和
 * Maximum Sum Subarray of Size K
 */

public class A1 {
    public static void main(String[] args) {
        A1 leetCode325 = new A1();
        int length = A1.maxSumOfSizeK(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println(length);
    }

    public static int maxSumOfSizeK(int[] arr, int k){
        if (arr==null || arr.length<k) return 0;
        int sum=0;
        for (int i=0;i<k;i++) sum +=arr[i]; // 5
        int max=sum;
        for (int i=k;i<arr.length;i++){
            sum += arr[i]-arr[i-k];
            if (sum >max) max = sum;
        }
        return max;
    }

    // public static int maxLength(int[] arr,int k) {
    //     if (null ==arr || arr.length<k) return 0;
    //     if (k<1) return 0;
    //     int s=0;
    //     int e =1;
    //     int sum =arr[s]+arr[e];
    //     while (s<e && e<arr.length){
    //          if (sum<k){
    //              e++;
    //              sum += arr[e];
    //          }else if (sum>k){
    //              sum -= arr[s];
    //              s++;
    //          }else {
    //              return e-s+1;
    //          }
    //     }
    //     return 0;
    // }
}
