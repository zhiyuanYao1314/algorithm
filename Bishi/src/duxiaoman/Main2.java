package duxiaoman;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int[] tmp = new int[N];
        for (int i=0;i<N;i++){
            tmp[i] = N-arr[i]+C;
        }
        int max=tmp[0];
        for (int i=0;i<N;i++){
            if (max>tmp[i]+A){
                max = tmp[i]+A;
            }
        }
        System.out.println(max);
    }
}
