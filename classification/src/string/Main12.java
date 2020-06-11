package string;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 23:58
 * leetcode125 验证回文串
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class Main12 {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        // String str = "A man, a plan, a canal: Panama";
        // System.out.println(str.length());
        // for (int i=0;i<str.length();i++){
        //     System.out.println(Character.isAlphabetic(str.charAt(i)));
        // }
    }

    public static boolean isPalindrome(String s) {
        if (s==null || s.length()==0) return true;
        int i=0;
        int j = s.length()-1;
        while (j>i){
            while (j>=0 && !Character.isAlphabetic(s.charAt(j))) j--;
            while (i<s.length() && !Character.isAlphabetic(s.charAt(i))) i++;
            // System.out.println(i);
            if (i<=j){
                if (!(s.charAt(i++)+"").equalsIgnoreCase(s.charAt(j--)+""))
                    return false;
            };
        }
        return true;
    }
}
