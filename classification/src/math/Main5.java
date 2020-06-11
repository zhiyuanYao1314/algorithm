package math;

import java.util.Arrays;

/**
 * Time:2020/4/21 21:25
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Main5 {
    public static void main(String[] args) {
        Main5 main5 = new Main5();
        int i = main5.GetUglyNumber_Solution2(7);
        System.out.println(i);
    }
    // 1 2 3 4 5 6  8 9 10 11 7

    // 方法2， dp
    // 一定是2 3 5的几个数的乘积，后面的数建立在前面数的基础上。
    public int GetUglyNumber_Solution2(int index) {
        if (index<7) return index;
        int[] dp = new int[index];
        dp[0] =1;
        // i2 i3 i5记录 2，3，5的倍数的数走到哪了
        int i2 = 0, i3=0,i5=0;
        for (int i=1;i<index;i++){
            int next2 = dp[i2]*2;
            int next3 = dp[i3]*3;
            int next5 = dp[i5]*5;
            dp[i] = Math.min(next2, Math.min(next3,next5));
            if (next2==dp[i]) i2++;
            if (next3==dp[i]) i3++;
            if (next5==dp[i]) i5++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[index-1];
    }

    public int GetUglyNumber_Solution(int index) {
        if (index==1) return 1;
        int i=2;
        int ans=1;
        while (index>1){
            if (isUgly(i)) {
                index--;
                ans = i;
                System.out.println(ans);
            }
            i++;
        }
        return ans;
    }
    public boolean isUgly(int num){
        // 2 3 5
        while (num%2==0){
            num = num/2;
        }
        while (num%3==0){
            num = num/3;
        }
        while (num %5==0){
            num = num/5;
        }
        if (num>1) return false;
        return true;
    }
}
