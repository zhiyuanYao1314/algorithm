package string;

import java.util.logging.Level;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/21 23:48
 * 左旋转字符串
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class Main9 {

    public static void main(String[] args) {
        String s = LeftRotateString("16", 0);
        System.out.println(s);
    }

    /**
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     */
    public static String LeftRotateString(String str,int n) {
        if (str ==null || n>str.length()) return "";
        if (n==0) return str;
        StringBuffer sb = new StringBuffer(str);
        for (int i=0,j=n-1;j>i;i++,j--){
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
        for (int i=n,j=sb.length()-1;j>i;i++,j--){
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
        for (int i=0,j=sb.length()-1;j>i;i++,j--){
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
        return sb.toString();
    }

}
