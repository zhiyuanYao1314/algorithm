package 华为;

/**
 * 华为面试2 算法题目；
 *
 */
public class Main2 {
    public static void main(String[] args) {
        String is1 = validate("");
        String is2 = validate("a,Ad,d");
        String is3 = validate("ajsv12767");
        String is4 = validate("ajsvAABC127AHV67");
        String is5 = validate("12767");
        String is6 = validate("12767kaubdgqeiy123e7y837283et246t7346t734673r6r4");
        System.out.println(is1);
        System.out.println(is2);
        System.out.println(is3);
        System.out.println(is4);
        System.out.println(is5);
        System.out.println(is6);

    }

    /**
     * 验证数字 大小写字母
     */
    public static String validate(String str){
        StringBuffer sb = new StringBuffer();
        if (str==null || str.length()==0 )
            return "ERROR";
        if (str.length()==1)
            return "";
        // 1.取出偶数位
        for (int i=1;i<str.length();i+=2){
            sb.append(str.charAt(i));
        }
        // 2. 校验
        for (int i=0;i<sb.length();i++){
            if (!check(sb.charAt(i))){
                return "ERROR";
            }
        }
        // 3. 长度
        if (sb.length()>20){
            return "ERROR";
        }
        return sb.toString();
    }

    public static boolean check(Character c){
        if (Character.isDigit(c))
            return true;
        if (Character.isAlphabetic(c))
            return true;
        return false;
    }

}
