package qiAnxin;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 11:49
 * Describe:
 * version:1.0
 */
public class QiAnxin {


    public static void main(){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[]{2,3,1,5,4,3};
        int[] v = new int[]{2,2,3,1,5,2};
        int n = sc.nextInt();
        // 递归表达式
        // f(i,n) = Math.max(f(i-1,n-v[i])+num[j],f(i-1,n))
        int[][] max = new int[n+1][7];
        for (int i=0;i<=n;i++){
            max[i][0] =0;
        }
        for (int j=0;j<=6;j++){
            max[0][j] = 0;
        }
        for (int i=1;i<=6;i++){
            for (int j=1;j<=n;j++){
                if (j>=v[i-1]){
                    max[j][i] = Math.max(max[j-v[i-1]][i-1]+num[i-1],max[j][i-1]);
                }else {
                    max[j][i] = max[j][i-1];
                }

            }
        }
        System.out.println(max[n][6]);
    }

}
