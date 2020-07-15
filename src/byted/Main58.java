package byted;

/**
 * 796 旋转字符串
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 */
public class Main58 {

    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if (A.length()==0 || B.length()==0)
            return false;
        for (int i=0;i<A.length();i++){
            A = A.substring(1)+A.charAt(0);
            if (isSameString(A, B))
                return true;
        }
        return false;

    }
    boolean isSameString(String A, String B){
        for (int i=0;i<A.length();i++){
            if (A.charAt(i) != B.charAt(i))
                return false;
        }
        return true;
    }

}
