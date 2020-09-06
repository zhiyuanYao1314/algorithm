package csig;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/9/6 12:39
 *
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 *
 * HG[3|B[2|CA]]F HGBCACABCACABCACAF
 *
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = restore(str);
        System.out.println(res);
    }


    static String restore(String str){
        Deque<Character> stack = new ArrayDeque();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=']'){
                stack.addLast(str.charAt(i));
                continue;
            }
            String tmp="";
            char c;
            while ((c= stack.pollLast())!='|'){
                tmp = c+tmp;
            }
            String num = "";
            while ((c= stack.pollLast())!='['){
                num = c+num;
            }
            StringBuffer tmpRes=new StringBuffer();
            for (int j=0;j<new Integer(num);j++){
                tmpRes.append(tmp);
            }
            for (int j=0;j<tmpRes.length();j++){
                stack.addLast(tmpRes.charAt(j));
            }
        }
        StringBuffer res =new StringBuffer();
        while (!stack.isEmpty()){
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

}