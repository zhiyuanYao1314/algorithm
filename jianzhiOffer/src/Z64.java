/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 20:03
 * Describe:
 * version:1.0
 */
public class Z64 {

    public static void main(String[] args) {
        Z64 z64 = new Z64();
        System.out.println(z64.Sum_Solution(3));
    }
    // &&短路与有前面条件满足，后面不计算的效果。
    public int Sum_Solution(int n) {
        int sum =n;
        boolean b = n>0 && (sum +=Sum_Solution(n-1))>0;
        return sum ;
    }

}
