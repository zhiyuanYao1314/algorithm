package ali;
/**
 * 小强得到了一个长度为n的序列，他想随机选择这个序列的一个连续子序列，并求出这个序列的最大值，请你告诉他这个最大值的期望是多少？
 * 输入第一行n表示序列长度，1<=n<=10^6；
 * 第二行为n个正整数，每个数字不超过10^5。
 * 输出这个最大值的期望，保留六位小数。
 */
public class MainAfter2 {
    /**
     * 1. 数组和子序列
     * 2. 以每个点作为最大值，往左右看有多少个。
     */
    public static void main(String[] args) {
        System.out.println(subSequence(new int[]{1, 3, 5}));
    }
    public static double subSequence(int[] n){
        int sum =0;
        for (int i=0;i<n.length;i++){
            int left =1;
            int right =1;
            while (i-left>=0 && n[i-left]<=n[i]) left++;
            while (i+right<n.length && n[i+right]<n[i]) right++;
            sum += n[i]*(left)*(right);
        }
        return sum/((double)n.length*(n.length+1)/2);
    }
}
