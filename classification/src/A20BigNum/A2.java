package A20BigNum;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 12:58
 * 有效数字
 * 正则表达式解法
 *
 *  +/- 127.23e-23
 */
public class A2 {

    public static void main(String[] args) {
        A2 a2 = new A2();
        String s= "e9";
        boolean number = a2.isNumber(s);
        System.out.println(number);
    }

    public boolean isNumber(String s) {
        s = s.trim(); // ? 0,1 + 1,, * 0,,
        if (s.length()==0) return false;
        String regex = "(.\\d+)?((\\d)+[eE][+-]?\\d+)?";
        // [+-]? [\d]+ (.\d+)? (e[+-]?\d+)?
        // String regex = "[+-]?[\\d]*(.\\d+)?([\\d]+e[+-]?\\d+)?";
        return s.matches(regex);
    }
}
