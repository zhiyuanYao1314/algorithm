/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 11:38
 * Describe:
 * version:1.0
 */
public class Fifteen {

    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
    }

    /**
     * n & n-1 将低位的1去掉 直到该数为0
     */
    public static  int NumberOf1(int n) {
        int cnt =0;
        while (n != 0){
            cnt++;
            n = n & (n-1);
        }
        return cnt;
    }
}
