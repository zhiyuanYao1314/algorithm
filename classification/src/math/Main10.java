package math;

/**
 * Time:2020/4/22 15:57
 * 不使用+ - * /计算两数和
 */
public class Main10 {
    public static void main(String[] args) {

    }

    /**
     *  num1^num2 表示不考虑进位的两数和
     *  num1 & num2<<1 表示两数的进位
     * 终止的条件是 num2==0
     */
    public int Add(int num1,int num2) {
        return num2==0? num1: Add(num1^num2, (num1 &num2 )<<1);
    }
}
