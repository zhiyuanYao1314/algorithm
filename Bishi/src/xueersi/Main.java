package xueersi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 18:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s= s.trim();
        int len = s.length();
        int i=0;
        StringBuffer ans= new StringBuffer();
        while (i<len){
            if (s.charAt(i)<='9' && s.charAt(i)>='0'){
                ans.append(s.charAt(i));
                i++;
            }
            else break;
        }
        if (ans.length()==0)
            System.out.println("0-0");
        else System.out.println("1-"+ans);
    }
}
