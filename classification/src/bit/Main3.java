package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 0:59
 * 二进制求和
 */
public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        String s = main3.addBinary("1010", "1011");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j = b.length()-1;
        String ans="";
        int carry =0;
        if (i>j){
            return addBinary(b,a);
        }
        while (i>=0){
            int cur =  a.charAt(i)-'0' + b.charAt(j)-'0'+carry;
            if (cur>1){
                cur= cur-2;
                carry=1;
            }else{
                carry=0;
            }
            ans = cur +ans;
            i--;j--;
        }
        while (j>=0){
            int cur = carry+b.charAt(j)-'0';
            if (cur>1){
                carry =1;
                cur -=2;
            }else carry=0;
            ans  = cur+ans;
            j--;
        }
        if (carry!=0) ans = carry+ans;
        return ans;
    }
}
