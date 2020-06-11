package string;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.security.cert.TrustAnchor;

/**
 * Time:2020/4/22 16:03
 * 将一个字符串转换成一个整数，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Main11 {

    public static void main(String[] args) {
        Main11 main11 = new Main11();
        int i = main11.StrToInt("-214749");
        System.out.println(i);
        // TODO 有更好的方法！

    }
    // + - 12868126
    public int StrToInt(String str) {
        if (str==null || str.length()==0) return 0;
        if (str.charAt(0)=='+') return sToI(str.substring(1), true);
        if (str.charAt(0)=='-') return 0-sToI(str.substring(1), false);
        return sToI(str, true);

    }
    public int sToI(String str, boolean flag){
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)<'0' || str.charAt(i)>'9' ){
                return 0;
            }
        }
        long sum =0;
        for (int i=0;i<str.length();i++){
            sum = sum*10+(str.charAt(i)-'0');
        }
        if (flag && sum >Integer.MAX_VALUE){
            return 0;
        }
        if (!flag && -sum <Integer.MIN_VALUE){
            return 0;
        }
        return (int)sum;
    }
}
