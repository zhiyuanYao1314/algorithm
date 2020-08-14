package others;

/**
 * 阿拉伯数字转中文
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个数字分成 1 2345 6789几个部分；
 * 1. 每四位为一节，每节有个单位； 如： 8万 12亿 16万亿；
 * 2. 每节里面 又分为单位 十 百 千；
 * 3.
 */
public class Main14 {
    public static void main(String[] args) {
        String s= convert("123456789");
        System.out.println(s);
    }

    static String convert(String str){
        List<String> parts = new ArrayList<>();
        while (str.length()>=4){
            parts.add(str.substring(str.length()-4));
            str = str.substring(0,str.length()-4);
        }
        if (str.length()>0){
            parts.add(str);
        }
        List<String> china = new ArrayList<>();
        // 0 1 2
        for (int i=parts.size()-1;i>=0;i--) {
            china.add(partToChina(parts.get(i)));
            if (i==2){
                china.add("万亿");
            }
            if (i==1){
                china.add("亿");
            }
            if (i==0){
                china.add("万");
            }
        }
        return china.toString();
    }

    static String partToChina(String s){

        String str="";
        Map<Character, String> map = new HashMap<>();
        map.put('1',"一");
        map.put('2',"贰");
        map.put('3',"叁");
        map.put('4',"四");

        for (int i=0;i<=s.length();i++){
            str += map.get(s.charAt(i));
        }
        String res= ""; // 1234 -- 4321
        if (str.length()>=4){
            if ("零".equals(str.charAt(0))){

            }else {
                res +=str.charAt(0)+"千";
            }
        }
        if (str.length()>=3){
            res +=str.charAt(1)+"百";
        }
        if (str.length()>=2){
            res +=str.charAt(0)+"十";
        }
        if (str.length()>=1){
            res +=str.charAt(0);
        }
        return res;
    }

}
