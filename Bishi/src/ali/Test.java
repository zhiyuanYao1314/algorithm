package ali;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] arr = new int[len][len];
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++)
            arr[i][j] = sc.nextInt();
        }
        for (int[] ar : arr){
            System.out.println(Arrays.toString(ar));
        }
    }

}
