package meiTuanMIan;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine().trim();
        String str2 = in.nextLine().trim();

        // System.out.println(location(str1, str2));
        System.out.println(loc(str1, str2));
    }


    // abckd bck --> 26个字符：
    // bck
    /**
     * KMP算法
     * 1. 计算26个字母的移动位置
     * 2. for循环遍历
     * 3.
     */
    public static int loc(String str1, String pattern){
        int[] move = new int[26];
        for (int i=0;i<move.length;i++){
            int lo = pattern.lastIndexOf(i+'a');
            if (lo != -1){
                move[i] = pattern.length()-(lo+1);
            }else {
                move[i] = pattern.length();
            }
        }
        System.out.println(Arrays.toString(move));
        // for (int i=)
        int i=0;
        // ababc
        //   abc
        //   a
        while (i<=str1.length()-pattern.length()){ //2
            int length = pattern.length()-1; // 2
            while (length>=0 && pattern.charAt(length)== str1.charAt(i+length)){
                length--;
            }
            if (length==-1) return i;
            i +=move[str1.charAt(i+length)-'a']-(pattern.length()-1-length);
            System.out.println(i);
        }
        return -1;
    }

    // abcd bcd KMP
    // 时间复杂度： str1.length()* str2.length()
    public static int location(String str1, String str2){
        if(str1== null || str2 == null || str1.length() < str2.length()){
            return -1;
        }
        int length=0;
        for (int i=0;i<str1.length();i += length){
            length =0;
            //
            while(
                    length<str2.length() &&
                            i+length<str1.length() &&
                            str1.charAt(i+length)==str2.charAt(length) ){
                length++;
            }
            if (length== str2.length()){
                return i;
            }

        }
        return -1;
    }
}