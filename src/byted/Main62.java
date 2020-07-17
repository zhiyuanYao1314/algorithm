package byted;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  166 分数到小数
 *
 *  给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 *  如果小数部分为循环小数，则将循环的部分括在括号内。
 */
public class Main62 {


    public static void main(String[] args) {
        System.out.println((double)1/6);
        String s1 = fractionToDecimal(1, 5);
        String s2 = fractionToDecimal(2, 1);
        String s3 = fractionToDecimal(1, 3);
        String s4 = fractionToDecimal(2, 3);
        String s5 = fractionToDecimal(1, 7);
        String s6 = fractionToDecimal(1, 6);
        String s7 = fractionToDecimal(-1, 6);
        String s8 = fractionToDecimal(0, 6);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
    }
    /**
     * 解法：
     * -1
     * -2147483648
     */
    public static String fractionToDecimal(int numerator, int denominator) {
         // 负数的转换
         boolean isNeg = false;
         if (numerator==0)
             return "0";
         if (numerator<0){
             numerator = -numerator;
             isNeg = !isNeg;
         }
         if (denominator<0){
             denominator = -denominator;
             isNeg = !isNeg;
         }

         // 10 1
         int intg = numerator/denominator;
         int remain = numerator%denominator;
         Map<Integer,Integer> contain = new HashMap<>();
//         contain.add(remain);
         String ds = ""; // 小数部分
        int i=-1;
         while (remain!=0 && !contain.containsKey(remain)){
             i++;
             contain.put(remain,i);
             remain = remain*10;
             ds += remain/denominator;
             remain = remain%denominator;
         }

        String ret;
         if (ds.length()==0){ // 没有小数
            ret =intg+"";
         }else if (remain==0){ // 无循环
             ret =intg+"."+ds;
         }else { // 有循环
             int index = contain.get(remain);
             if (index==0)
                ret =intg+".("+ds+")";
             else
                 ret =intg+"."+ds.substring(0,index)+"("+ds.substring(index)+")";
         }
         if (isNeg){
             ret = "-"+ret;
         }
         return ret;
    }
}
