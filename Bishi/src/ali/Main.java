package ali;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 养鸡场个数
        int day = sc.nextInt(); // 天数
        int k = sc.nextInt(); // 每天增加个数
        int[] chang = new int[num];
        for (int i=0;i<num;i++){
            chang[i] = sc.nextInt();
        }
        for (int i=0;i<day;i++){
            // 每个元素+k
            addKAndHalf(chang, k);
        }
        int sum =0;
        for (int a : chang){
            sum += a;
        }
        System.out.println(sum);
    }
    public static void addKAndHalf(int[] arr, int k){
        int index =0;
        for (int i=0;i<arr.length;i++){
            arr[i] += k;
            if (arr[i]>arr[index]) index=i;
        }
        arr[index] /= 2;
    }
}
