import java.time.OffsetDateTime;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 11:47
 * Describe:
 * version:1.0
 */
public class Ten1 {

    public static void main(String[] args) {
        Ten1 ten1 = new Ten1();
        System.out.println(ten1.Fibonacci(10));
        System.out.println(ten1.Fibonacci2(10));
        System.out.println(ten1.fb2(10));

    }

    // 动态规划，从前往后，求最后一个值
    public int Fibonacci(int n) {
        if (n==0) return 0;
        int[] fs = new int[n+1];
        fs[1] = 1;
        for (int i=2;i<=n;i++){
            fs[i] = fs[i-1]+fs[i-2];
        }
        return fs[n];
    }

    private int[] arr = new int[40];
    // memo 从后往前 记录下需要求的值
    public int Fibonacci2(int n){
        for (int i=0;i<arr.length;i++) arr[i] =-1;
        arr[0] =0;
        arr[1] =1;
        return fb(n);
    }
    public int fb(int n) {
        if (arr[n] != -1) return arr[n];
        arr[n] =fb(n-1)+fb(n-2);
        return arr[n];
    }


    // DP PUSH
    public int fb2(int n) {
        int f =0;
        int s = 1;
        for (int i=2;i<=n;i++){
            int t = s;
            s = f+t;
            f = t;
        }
        return  s;
    }
}
