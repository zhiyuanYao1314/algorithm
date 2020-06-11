package kuaishou;


import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){

        }

    }

    ArrayList<Integer[]> all = new ArrayList<>();
    // public int[] getAll(int[] arr, int s, int e){
    //     if(s==e){
    //         if ()
    //     }else {
    //         for (int i)
    //     }
    // }


    // 20%
    public int[] WaitInLine (int[] a, int[] b) {
        int n = a.length;
        int[] ans = new int[n];
        for (int i=0;i<ans.length;i++){
            ans[i] =i+1;
        }
        long sum =0;
        for (int i=0;i<n;i++){
            sum +=a[i]*(ans[i]-1)+b[i]*(n-ans[i]);
        }
        return ans;


    }
}
