package string;

/**
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Main4 {
    public static void main(String[] args) {
        Main4 main4 = new Main4();
        String str = "1+23";
        // System.out.println(main4.isNumeric(str.toCharArray()));
    }
    /**
     *
     */
    public boolean isNumeric2(char[] str) {
        String s = new String(str);
        String pattern = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        return s.matches(pattern);
    }


    /**
     * 没有向正则表达式上想，各种情况 调试了很久。
     * 从前往后遍历：所有字符只能是 0-9, + - ，e， .
     * 1. 数字后面不能是+， -
     * 2. + - 后面不能是e和.，+-后面不能在有+-， 除非遇到e
     * 3. e后面不能有.
     * 4. .后面只能是数字
     * 如果不用正则表达式的话，需要考虑所有情况
     *
     */
    // 123.45e+6 -.123, 1+23
    // public boolean isNumeric(char[] str) {
    //     int dotCount =0;
    //     int eCount =0;
    //     boolean afterE = false;
    //     boolean afterDot = false;
    //     int plusMinusCount =0;
    //     for (int i=0;i< str.length;i++){
    //         if (str[i]>='0' && str[i]<='9'){
    //             if (i+1<str.length && (str[i+1]=='+' ||str[i+1]=='+')) return false;
    //             continue;
    //         }
    //         if (str[i]=='+' || str[i]=='-'){
    //             if (afterDot && !afterE) return false;
    //             // + -号后面只能是数字
    //             if ( ++plusMinusCount>1 || i+1>=str.length || !(str[i+1]>='0' && str[i+1]<='9' || str[i+1]=='.') ){
    //                 return false;
    //             }
    //             // e后面只能跟+ - 0-9
    //         }else if(str[i]=='e' ||str[i]=='E' ){
    //             afterE = true;
    //             plusMinusCount=0;
    //             if (++eCount>1|| i+1>=str.length || !((str[i+1]>='0' && str[i+1]<='9') || (str[i+1]=='+'|| str[i+1]=='-'))
    //             ){
    //                 return false;
    //             }
    //         }else if(str[i]=='.'){
    //             afterDot = true;
    //             // e后面有. 返回false
    //             if (afterE){
    //                 return false;
    //             }
    //             if (++dotCount>1 || i+1>=str.length || str[i+1]<'0' || str[i+1]>'9' ){
    //                 return false;
    //             }
    //         }else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
