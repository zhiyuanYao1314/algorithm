package duxiaoman;

import java.util.Scanner;

// 55%
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i][j]= (i+1)*(j+1)%10;
            }
        }
        int ans=0;
        int tt =0;
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                if (arr[i][j]>tt){
                    tt =arr[i][j];
                }
            }
        }
        for (int i=a;i<=n-a;i++){
            for (int j=b;j<=m-b;j++){
                int max=tt;
                int tr =-10000;
                int tc =-10000;
                for (int M=0;M<a;M++){
                    if (arr[i+M][j]>max){
                        max = arr[i+M][j];
                    }
                }
                ans +=max;
            }
        }


        System.out.println(ans);
    }
    // static int[][] arr;
    // static int a;
    // static int b;
    // public static int sum(int rs, int cs){
    //     int max =0;
    //     for (int i=rs;i<a;i++){
    //         for (int j=cs;j<b;j++){
    //             if (arr[i][j]>max){
    //                 max=arr[i][j];
    //             }
    //         }
    //     }
    //     return max;
    // }
}
