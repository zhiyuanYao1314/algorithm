package xueersi;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 19:42
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(divide(n));
        // System.out.println((long)Math.pow(2,n));
    }

    public static long divide(int n){
        long ans=2;
        long other =1;
        while (n>1){
            if (n%2==0){//偶数
            }else {
                other *= ans;
            }
            ans = ans*ans;
            n=n/2;
        }
        return ans*other;
    }
}
