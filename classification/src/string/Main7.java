package string;


import com.sun.xml.internal.ws.message.stream.StreamAttachment;

import java.nio.channels.Channel;
import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Main7 {
    public static void main(String[] args) {
        Main7 main7 = new Main7();
        ArrayList<String> abc = main7.Permutation("abc");
        for(String s : abc){
            System.out.println(s);
        }
    }
    Set<String> ans =new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        if (str==null || str.length()==0) return new ArrayList<>();
        String s = new String();
        combain(str,s);
        String[] tmp = new String[ans.size()];
        int i=0;
        for (String t: ans){
            tmp[i++] = t;
        }
        Arrays.sort(tmp);
        ArrayList list = new ArrayList<>();
        for (String t: tmp){
            list.add(t);
        }
        return list;
    }
    public void combain(String str, String sb) {
        if (str.length()==0) ans.add(sb);
        for (int i=0;i<str.length();i++){
            String newSb= sb +str.charAt(i);
            String newS=str.substring(0,i)+str.substring(i+1,str.length());
            combain(newS,newSb);
        }
    }
}
