package others;

import com.sun.org.apache.xpath.internal.operations.Or;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/21 17:41
 * Describe:
 * version:1.0
 */
public class One {

    public static void main(String[] args) {
        // System.out.println(test01(666));
        int[] arr = new int[] {1,3,8,5,3,7,2,9,10};
        System.out.println(LIS(arr));
        System.out.println(replace("A B"));
    }


    public static String replace(String str){
        str = str.replace(" ", "%20");
        return str;
    }

    /**
     * 复杂度：n*n
     * @param arr
     * @return
     */
    public static int LIS(int[] arr){
        int[] ends = new int[arr.length];
        for (int i=0;i<arr.length;i++) ends[i] =1;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    ends[i] = Math.max(ends[j]+1,ends[i]);
                }
            }
        }
        System.out.println(Arrays.toString(ends));
        int max =ends[0];
        for (int i=0;i<arr.length;i++){
            max = Math.max(max, ends[i]);
        }
        return max;
    }

    // 贪心策略
    public static int test01(int num){
        int[] denominations = new int[]{100,50,20,10,5,1};
        int count =0;
        for (int i=0;i<denominations.length && num !=0;i++){
            count += num/denominations[i];
            num = num%denominations[i];
        }
        return count;
    }

    public static int dimensionsDP(int num){
        return 0;
    }

    public int bd(int num, ArrayList<Integer> ds){
        // 退出条件：
        if (num ==0) return 0;
        if (ds.isEmpty()) return Integer.MIN_VALUE;

        int m1 = bd(num, ds);
        int m2 = bd(num-ds.get(ds.size()-1),ds)+1;
        return Math.min(m1,m2);
    }

    // 如果只有3个dimension
    public int bd2(int num){
        int m1=Integer.MAX_VALUE,m2=Integer.MAX_VALUE,m3 =Integer.MAX_VALUE;
        if (num==0) return 0;
        if(num>=1) m1 = bd2(num-1)+1;
        if (num>=5) m2 = bd2(num-5)+1;
        if (num>=11) m3 = bd2(num-11)+1;
        return Math.max(Math.min(m1,m2),m3);
    }

    public int bd3(int num){
        int[] res =new int[num];
        res[1] = 1;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE;
        for (int i=1;i<=num;i++){
            if (i-1>=0) m1 = res[i-1];
            if (i-5>=0) m2 = res[i-5];
            if (i-11>=0) m3 = res[i-11];
            res[i] =min(m1, m2, m3)+1;
        }
        return  res[num];
    }

    public int min(int a, int b ,int c){
        return Math.min(a, Math.min(b,c));
    }



}
