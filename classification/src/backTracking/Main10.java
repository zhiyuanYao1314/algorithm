package backTracking;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 23:06
 * leetcode473 火柴拼正方形
 */
public class Main10 {

    public static void main(String[] args) {
        Main10 main10 = new Main10();
        int[] ints = {5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511};
        boolean makesquare = main10.makesquare(ints);
        System.out.println(makesquare);
    }
    int[] part4 = new int[4];
    int len;
    int[] nums;
    public boolean makesquare(int[] nums) {
        len = nums.length;
        if (nums==null || nums.length<4) return false;
        int sum =0;
        for (int i: nums) sum += i;
        if (sum %4 != 0) return false;
        sum /=4;
        this.nums = nums;
        return backtrack(0, sum);
    }

    boolean backtrack(int n, int sum){
        if (n==len){
            for (int i: part4)
                if(i!=sum) return false;
            return true;
        }
        for (int i=0;i<4;i++){
            if (!check(i,n, sum)) continue;
            part4[i] += nums[n];
            if (backtrack(n+1,sum))
                return true;
            part4[i] -= nums[n];
        }
        return false;
    }
    // i 放入part4中的第i个， n 当前元素
    private boolean check(int i, int n, int sum) {
        if (part4[i]+nums[n]>sum) return false;
        return true;
    }
}

