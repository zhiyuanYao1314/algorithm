package array;

import sort.Main;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Main5 {
    public static void main(String[] args) {
        Main5 main5 = new Main5();
        int[] mul = main5.multiply(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(mul));
    }

    /**
     * 数组的累乘操作。
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B =new int[len];
        int[] C =new int[len];
        int multiL = 1;
        int multiR = 1;
        B[0]=1;C[len-1]=1;
        for (int i=1;i<len;i++){
            multiR *= A[len-i];
            multiL *= A[i-1];
            B[i] = multiL;
            C[len-i-1] = multiR;
        }
        int[] res = new int[len];
        res[0] = C[0];
        res[len-1] = B[len-1];
        for (int i=1;i<len-1;i++){
            res[i] = B[i]*C[i];
        }
        return res;
    }

    public static void multiplicative(int[] arr){

        for (int i=1;i<arr.length;i++){
            // int tmp = arr[i];
            arr[i] = arr[i-1]*arr[i];
            // a1 = a0*a1 a2 = a1*a2 a3 = a2*a3
        }
    }
}
