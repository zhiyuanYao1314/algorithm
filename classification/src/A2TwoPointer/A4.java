package A2TwoPointer;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 22:16
 * 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 只用到了一个Stack， 没用到双指针；
 */
public class A4 {

    public static void main(String[] args) {
        String S= "ab#c", T = "ad#c";
        S = "ab##"; T = "c#d#";
        S = "a##c"; T = "#a#c";
        boolean compare = compare(S, T);
        System.out.println(compare);
    }

    public static boolean compare (String str1, String str2){
        Stack<Character> stack = new Stack();
        for (int i=0;i<str1.length();i++){
            char cur = str1.charAt(i);
            if (cur=='#' && !stack.isEmpty()){
                stack.pop();
            }else if (cur!='#'){
                stack.add(cur);
            }
        }
        int i=str2.length()-1;
        while (i>=0){
            char c = str2.charAt(i);
            if ( c=='#'){
                i =i-2;
            }else {
                Character pop = stack.pop();
                if (pop != c) return false;
                i--;
            }
        }
        return stack.isEmpty();
    }

}
