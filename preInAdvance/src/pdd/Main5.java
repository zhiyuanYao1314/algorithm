package pdd;

/**
 * 求两个数的最大公约数
 */
public class Main5 {

    int commonDivisor(int n, int m){
        int max = Math.max(n, m);
        int min = Math.max(n, m);
        while (min!=0){
            int tmp = max%min;
            max = min;
            min = tmp;
        }
        return max;
    }
}
