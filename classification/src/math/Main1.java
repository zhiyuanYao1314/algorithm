package math;


/**
 * 给两个整数k，n 求将n分成k份后的最大乘积
 */
public class Main1 {

    // 对n平分，然后将余数分给每个元素
    public static long divide(int n, int k){
        int s = n/k;
        int re = n%k;
        long ans = (long) (Math.pow(s+1,re)*Math.pow(s,k-re));
        return ans;
    }

}
