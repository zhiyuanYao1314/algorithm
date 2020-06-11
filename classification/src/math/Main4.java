package math;

/**
 * Time:2020/4/21 20:37
 * 整数中1出现的次数，(从1到n整数中1出现的次数)
 * 1~13中包含1的数字有1、10、11、12、13 共6次。
 *
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(10)); // 1 10 11 12 13
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;

        for (int i=1;i<=n;i++){
            String s = String.valueOf(i);
            int in = s.indexOf("1");
            while (in != -1){
                count++;
                in = s.indexOf("1",in+1);
            }
        }
        return count;
    }
}
