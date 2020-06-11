package zhaohang;
import java.util.Arrays;
public class Main1 {
    public static void main(String[] args) {
        int n=2;
        int w=4;
        int[] glasses = new int[]{1,1,1,1};
        System.out.println(water(n,w,glasses));
    }

    /**
     * @param n  n个男生和女生
     * @param w 总共w毫升水
     * @param glasses 2*n个水杯最多能装多少水
     * @return 一共能倒多少水？
     */
    public static String water(int n, int w, int[] glasses){
        Arrays.sort(glasses);
        double less = glasses[0];
        double more = glasses[n];
        double min = Math.min(less,more/2);

        double res ;
        if (3*min*n<=w) res=3*min*n;
        else res =w;
        return String.format("%.6f", res);
    }
}
