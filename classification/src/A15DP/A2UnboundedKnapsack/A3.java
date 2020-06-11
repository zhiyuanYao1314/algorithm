package A15DP.A2UnboundedKnapsack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 13:30
 * 换硬币的方法
 */
public class A3 {
    public static void main(String[] args) {
        A3 a2 = new A3();
        int i = a2.waysToChange(900750);
        System.out.println(i);
    }
    // 25 10 5
    public int waysToChange(int n) {
        if (n<=0) return 0;
        long count=0;
        int a1 = n/25;
        for (int i=0;i<=a1;i++){
            int a2 = n-i*25;
            int b1 = a2/10;
            for (int j=0;j<=b1;j++){
                int b2 = a2- j*10;
                int c1 = b2/5;
                count += c1+1;
            }
        }
        return (int)(count%1000000007);
    }
}
