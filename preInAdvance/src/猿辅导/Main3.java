package 猿辅导;

/**
 * 两个数的最大公约数
 */
public class Main3 {
    public static void main(String[] args) {

    }
    int maxCommonDividor(int n, int m){
        int max = Math.max(n, m);
        int min = Math.min(n,m);
        while (min!=0){
            int tmp = max%min;
            max = min;
            min = tmp;
        }
        return max;
    }

}
