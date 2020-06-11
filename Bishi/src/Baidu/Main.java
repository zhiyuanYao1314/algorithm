package Baidu;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max =0;
        int[][] gcd = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                gcd[i][j] = gcd(i,j);
            }
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                int lc = gcd[i][j];
                long ma = i*j/lc;
                max = Math.max(max,ma-lc);
            }
        }
        System.out.println(max);
    }

    public static int gcd(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int r;
        while (min >0){
            r = max%min;
            max=min;
            min = r;
        }
        return max;
    }
}
