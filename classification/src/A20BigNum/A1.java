package A20BigNum;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 11:14
 *
 * 字符串转换成整数(atoi)
 */
public class A1 {
    public static void main(String[] args) {
        // System.out.println('0'-'7');
        A1 a1 = new A1();
        int i = a1.myAtoi("   -42");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        int i=0;
        boolean isPositive = true;
        long num=0L;
        str = str.trim();
        if (str==null || str.length()==0) return 0;
        int len = str.length();
        if (str.charAt(i)=='-'){
            isPositive=false;
            i++;
        }else if (str.charAt(i)=='+'){
            isPositive=true;
            i++;
        }
        // 数字
        while (i<len){
            // 数字为1-9
            if (str.charAt(i)>='0' &&
                    str.charAt(i)<='9'){
                if (isPositive){ // 整数
                    num =num*10+ str.charAt(i)-'0';
                    if (num> Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }else {
                    num =num*10-(str.charAt(i)-'0');
                    if (num<Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }
                // 不为1-9
            }else{
                return (int)num;
            }
            i++;
        }
        return (int)num;
    }
}