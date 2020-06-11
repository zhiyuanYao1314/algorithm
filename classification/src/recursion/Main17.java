package recursion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 17:55
 * 整数替换
 *
 */
public class Main17 {
    public static void main(String[] args) {
        Main17 main17 = new Main17();

        int i = main17.integerReplacement(2147483647);
        System.out.println(i);
        int j = main17.integerReplacement(3);
        System.out.println(j);
        // 172
    }

    public int integerReplacement(int n) {
        if (n==1) return 0;
        if (n==Integer.MAX_VALUE) return Integer.bitCount(n)+1;
        if ((n&1)==0){
            return 1+integerReplacement(n >>1);
        }else {
            return 1+ Math.min(integerReplacement(n+1), integerReplacement(n-1));
        }
    }
}
