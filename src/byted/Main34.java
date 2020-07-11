package byted;

/**
 * 344. 反转字符串
 * 简单
 */
public class Main34 {

    public void reverseString(char[] s) {
        if (s==null || s.length==0)
            return;
        int i=0, j=s.length-1;
        while (i<j){
            swap(s, i++,j--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp =s[i];
        s[i]= s[j];
        s[j] = tmp;
    }
}
