package meiTuan;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 18%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // int i=0;
        // int j = n-1;
        int[] res = new int[n];
        for (int i=0;i<n;i++){
            // arr[i]+x

        }
        System.out.println(1);
        // while (i<j && arr[j]-arr[i]>x){
        //
        // }
    }
    public static int find(int[] arr, int x){
        for (int i=0;i<arr.length;i++){
            if (x >arr[i]){
                return i-1;
            }
        }
        return 0;
    }

}
