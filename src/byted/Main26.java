package byted;

/**
 * 415字符串相加
 * 记录 进位
 *
 */
public class Main26 {

    /**
     * 使用｜｜ 代码简便很多
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        String s = addStrings("1234", "56");  //   0921  1290
        System.out.println(s);
    }
    // 只包含 数字0-9 不包含前导0
    public static String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        int up =0;
        int cur=0;
        while (i1>=0 && i2>=0){
            cur =(num1.charAt(i1--)-'0')+(num2.charAt(i2--)-'0')+up;
            if (cur>9){
                up =1;
                cur = cur-10;
            }else {
                up=0;
            }
            res.append(cur);
        }
        String numReamin;
        int remainIndex;
        if (i1==-1){
            remainIndex =i2;
            numReamin = num2;
        }else {
            remainIndex =i1;
            numReamin = num1;
        }
        while (remainIndex>=0){
            cur =(numReamin.charAt(remainIndex--)-'0')+up;
            if (cur>9){
                up =1;
                cur = cur-10;
            }else {
                up=0;
            }
            res.append(cur);
        }
        if (up>0){
            res.append(up);
        }
        res.reverse();
        return res.toString();
    }
}
