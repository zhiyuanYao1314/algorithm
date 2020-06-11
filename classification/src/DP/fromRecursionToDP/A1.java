package DP.fromRecursionToDP;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/3 10:58
 *
 * 汉诺塔问题
 *
 * 打印移动全过程
 */
public class A1 {

    public static void main(String[] args) {
        hannuota(3);
    }
    public static void hannuota(int n){
        fromToOther(n, "left", "right", "middle");
    }

    private static void fromToOther(int n, String left, String right, String middle) {
        if (n==1)
            System.out.println("move 1 from "+left +" to " +right);
        else {
            fromToOther(n-1, left,middle, right);
            System.out.println("move "+ n + " from "+left +" to " +right);
            fromToOther(n-1, middle, right,left);
        }
    }


}
