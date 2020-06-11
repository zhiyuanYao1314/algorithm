package meiTuan;

import java.util.Scanner;

// 100%
public class Main3 {
    static int[] p;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] p = new double[n];
        for (int i =0;i<n;i++){
            p[i] = sc.nextDouble();
        }
        int[] a = new int[n];
        for (int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }

        double[][] arr = new double[n+1][n+1];
        for (int i=0;i<n+1;i++){
            arr[0][i] = 0;
        }
        for (int i=0;i<n+1;i++){
            arr[i][0] = 0;
        }
        // i表示剩余子弹数量，j表示当前可以选择的子弹数量
        // 如j=3, 表示可以选择1,2,3个子弹射击
        for (int i=1;i<n+1;i++){
            for (int j=1;j<n+1;j++){
                // 有的子弹小于可以选择的，直接退化为i,i
                if (i<j){
                    arr[i][j] = arr[i][i];
                }else {
                    double x = p[j-1]*a[j-1]+ p[j-1]*(arr[i-j][j]);// 选择了j个子弹
                    double y = arr[i][j-1]; // 不选择
                    arr[i][j] = Math.max(x,y); // 取两者的最大方案
                }
            }
        }
        System.out.println(String.format("%.2f",arr[n][n]));
    }

}
