package yuanjinzhineng;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        int count=0;
        while (n>9){
            n =mul(n);
            count++;
        }
        System.out.println(count);
    }
    public static long mul(long n){
        int ans =1;
        while (n !=0){
            long t = n%10;
            ans *=t;
            n /=10;
        }
       return ans;
    }
}
