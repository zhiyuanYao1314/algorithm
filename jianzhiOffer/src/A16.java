/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 12:39
 * Describe:
 * version:1.0
 */
public class A16 {

    public static void main(String[] args) {
        A16 a = new A16();
        System.out.println(a.Power2(2,-3));
    }

    /**
     * 1. 注意整数的正负；
     * 2. 递归和迭代的转换。
     */
    public double Power(double base, int exponent) {
        // 迭代
        if (base ==0) return 0;
        if (exponent==0) return 1;
        double out=1;
        while (exponent !=1 && exponent !=-1){
            int mod = exponent%2;
            if (mod != 0) out *= base;
            base *= base;
            exponent /= 2;
        }
        if (exponent>0) return base*out;
        return 1/(base*out);
    }

    /**
     * 递归表达式
     *  p(base, exponent) = p(base*base, exp/2)
     *  注意判断正负，
     * 因为负的指数只需要再最后1/res就好，所以记录一下，然后转成正的传递下去！
     */
    public double Power2(double base, int exponent) {
        boolean isPositive = true;
        if (base==0) return 0;
        if (exponent==0) return 1;
        if (exponent<0) {
            exponent = -exponent;
            isPositive=false;
        }
        double res = 0;
        if (exponent%2==0) res = Power2(base*base,exponent/2);
        else res = base*Power2(base*base,exponent/2);

        if (isPositive) return res;
        else return 1/res;
    }
}
