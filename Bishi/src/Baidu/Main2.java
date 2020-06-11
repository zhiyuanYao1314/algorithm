package Baidu;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        long[] arr = new long[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        int count =0;
        while (arr[max(arr)]>=n){
            arr[max(arr)] -= (n+1);
            addOne(arr);
            count++;
        }
        System.out.println(count);
    }
    public static void addOne(long[] arr){
        for (int i=0;i<arr.length;i++){
            arr[i] +=1;
        }
    }
    public static int max(long[] arr){
        int index =0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>arr[index]){
                index = i;
            }
        }
        return index;
    }

}
