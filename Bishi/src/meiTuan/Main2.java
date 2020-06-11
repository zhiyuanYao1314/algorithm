package meiTuan;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();

        int[] arr = new int[n];
        long sum =0;

        for (int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
            sum  += arr[i];
        }
        long size = m/sum; //size*n;
        long remain = m%sum;
        long last = 0;
        for (int i=0;i<n;i++){
             if (remain>=arr[i]){
                 last++;
                 remain -=arr[i];
             }
        }
        System.out.println(size*n+last);
    }

}
