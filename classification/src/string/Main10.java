package string;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/22 14:10
 * 反转单词顺序
 * “student. a am I” -->“I am a student.”
 */
public class Main10 {
    public static void main(String[] args) {
        String s = ReverseSentence("     ");
        System.out.println(s+"|");
    }
    public static String ReverseSentence(String str) {
        if (str==null || str.length()==0) return "";
        String[] s = str.split(" ");
        if (s.length==0) return str; // 只包含空格，返回本身
        System.out.println(s.length);
        StringBuffer sb = new StringBuffer();
        for (int i=s.length-1;i>=0;i--){
            sb.append(s[i]+" ");
        }
        // return sb.toString();
        return sb.substring(0,sb.length()-1);
    }

}
