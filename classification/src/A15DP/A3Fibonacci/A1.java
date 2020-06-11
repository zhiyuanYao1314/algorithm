package A15DP.A3Fibonacci;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 10:59
 * 斐波那契数
 */
public class A1 {

    /**
     * 1. 自底向上,
     */
    public int fib(int N) {
        if (N<=1) return N; // 0 1
        int[] F = new int[N+1];
        F[1] = 1;
        for (int i=2;i<N+1;i++){
            F[i] = F[i-1]+F[i-2];
        }
        return F[N];
    }

    /**
     * 2. 递归: 复杂度2^N
     */
    public int fib2(int N) {
        if (N<=1) return N; // 0 1
        return fib2(N-1)+fib2(N-2);
    }

    /**
     * 3. 自顶向下 memo
     */
    int[] memo;
    public int fib3(int N) {
        memo = new int[N];
        return upToDown(N);
    }
    public int upToDown(int N){
        if (N<=1) return N;
        if (memo[N]!=0) return memo[N];
        int k = upToDown(N-1)+upToDown(N-2);
        memo[N] = k;
        return k;
    }

    /**
     * 存储临时变量
     */
    public int fib4(int N) {
        if (N<=1) return N; //0:1 1:1 2:1 3:2
        int left=0;
        int right =1;
        int cur=1;
        for (int i=2;i<=N;i++){
            cur = left +right;
            left = right;
            right =cur;
        }
        return cur;
    }



}
