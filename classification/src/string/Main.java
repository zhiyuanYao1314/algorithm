package string;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.jws.WebParam;

/**
 * 字符串模式匹配算法，要求复杂度n
 */
public class Main {
    public static void main(String[] args) {
        String str = new String("ababc");
        String pattern = new String("abc");
        String str2 = new String("akabc");
        String pattern2 = new String("abc");
        System.out.println(KMP(str,pattern));
        System.out.println(KMP(str2,pattern2));
    }

    /**
     *
     */
    public static int KMP(String str, String pattern){
        int[] move = move(pattern);
        int i=0;
        while (i<=str.length()-pattern.length()){
            int len = pattern.length()-1;
            while (len>= 0 &&pattern.charAt(len) == str.charAt(i+len)){
                len --;
            }
            if (len ==-1) return i;
            i = i+(pattern.length()-1-len)+move[str.charAt(i+len)-'a'];
        }
        return -1;
    }

    /**
     * 计算移动距离
     *
      */
    public static int[] move(String pattern) {
        int[] ints = new int[26];
        for (int i=0;i<26;i++){
            int loc = pattern.lastIndexOf(i + 'a');
            if (loc != -1){
                ints[i] = pattern.length()-1-loc;
            }else ints[i] = pattern.length();
        }
        return ints;
    }
}
