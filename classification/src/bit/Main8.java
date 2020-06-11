package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:08
 * LC371 两整数之和
 */
public class Main8 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
    /**
     * a^b 表示没有进位情况下的两个数的加法；
     * a&b <<1 表示进位 ，都是1的向前进一位；
     */
    public int getSum(int a, int b) {
        return b==0?a: getSum(a^b, (a&b)<<1);
    }
}
