package zhaohang;
import com.sun.javafx.sg.prism.web.NGWebView;

import java.util.Scanner;

public class Mian6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] strs = new String[n];
        int[] anss = new int[n];
        for(int i = 0; i < n; i++){
            String[] tmp= sc.nextLine().split(" ");
            strs[i]= tmp[0];
            anss[i] = Integer.parseInt(tmp[1]);
        }
        for (int i=0;i<n;i++){
            test(strs[i],new StringBuffer(strs[i]),0, anss[i], new StringBuffer());
        }
    }
    // 21 1
    public static void test(String best, StringBuffer s ,int cur ,int k, StringBuffer num) {
        if (cur >= best.length()){
            check(s,num,k);
            return;
        }
        if (cur ==0) test(best,s,cur+1, k,num.append(" "));
        else{
            StringBuffer s1 = new StringBuffer(num);
            StringBuffer s2 = new StringBuffer(num);
            StringBuffer s3 = new StringBuffer(num);
            test(best, s,cur+1, k,s1.append("+"));
            test(best, s,cur+1, k,s2.append("-"));
            test(best, s,cur+1, k,s3.append(" "));
        }
    }
    private static void check(StringBuffer s, StringBuffer num, int k) {
        int sum =0;
        int cur =0;
        StringBuffer total = new StringBuffer();
        for (int i=0;i<s.length();i++){
            total.append(num.charAt(i));
            total.append(s.charAt(i));
        }
        String trim = total.toString().trim();
    }
}
