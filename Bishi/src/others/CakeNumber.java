package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 10:05
 * Describe:
 * version:1.0
 */
public class CakeNumber {
    public static void main(String[] args) {
        CakeNumber ck = new CakeNumber();
        System.out.println(ck.cakeNumber(2));
        System.out.println(ck.cakeNumber2(3));

    }

     /**
     * 1. 动态规划，递归， 从外往内
     * 先找出递推式，在找出退出条件，
     * 参数，向下传递，返回值，向上传递。
     *
     * 2. 循环，从内往外，
     */

    public int cakeNumber (int n) {
        // write code here
        if (n==1)
            return 1;
        return ((cakeNumber(n-1)+1)*3/2);
    }

    /**
     * for 循环版本
     */
    public int cakeNumber2 (int n) {
        // write code here

        int cn=1;
        for (int i =2;i<=n;i++){
            cn = (cn+1)*3/2;
        }
        return cn;
    }

}