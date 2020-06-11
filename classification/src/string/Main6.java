package string;

/**
 * 最长回文子序列
 */
public class Main6 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ab1234321abc",12));
    }
    // ab1234321abc
    public static int longestPalindrome(String s, int n){
        int max = 0;
        for (int i=0;i<n;i++){
            int len =0;
            if (i+1<n && s.charAt(i)== s.charAt(i+1)){
                while (i-len>=0 && i+1+len<n &&
                        s.charAt(i-len)==s.charAt(i+1+len)){
                    len++;
                }
                if (2*len>max){
                    max = 2*len;
                }
            }
            // 取变量名一定要取好，
            len =0;
            if (i-1>=0 && i+1<n && s.charAt(i-1) == s.charAt(i+1)){
                while (i-1-len>=0 && i+1+len<n &&
                        s.charAt(i-1-len)== s.charAt(i+1+len)){
                    len++;
                }
                if (2*len+1>max){
                    max = 2*len+1;
                }
            }
        }
        return max;
    }

}
