package ali;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    /**
     * 求数组的所有子集的最大值的和。
     */
    public static void test(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] arrs = new int[len][len];
        int sum = 0;
        for (int i=0;i<len;i++){ //起始点
            int max = arr[i];
            for (int j=i;j<len;j++){ // 终止点
                if (arr[j]>max){
                    max = arr[j];
                }
                sum +=max;
                arrs[i][j] = max;
            }
        }
        int s = ((1+len)*len)/2;
        double ss = (double)sum/s;
        System.out.println(String.format("%.6f",ss));
    }

    public static void main(String[] args) {
        test(args);
        // Scanner sc = new Scanner(System.in);
        // int len = sc.nextInt();
        // int[] arr = new int[len];
        // for (int i = 0; i < len; i++) {
        //     arr[i] = sc.nextInt();
        // }
        // Arrays.sort(arr);
        // int sum =0;
        // for (int i = 0; i < len; i++) {
        //     sum =sum + (arr[i]*(i+1));
        // }
        // int s = ((1+len)*len)/2;
        // double res = (double)sum/s;
        // String ss = Double.toString(res);
        // ss = ss.substring(0,ss.indexOf(".")+7);
        // System.out.println(ss);
    }
}
