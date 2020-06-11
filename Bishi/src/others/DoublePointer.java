package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 16:19
 * Describe:
 * version:1.0
 */
public class DoublePointer {

    public static void main(String[] args) {
        DoublePointer doublePointer = new DoublePointer();
        System.out.println(doublePointer.change1("64"));
        System.out.println(doublePointer.change1("452"));
        System.out.println(doublePointer.change1("426"));
        System.out.println(doublePointer.change1("4136"));
    }

    /**
     * double pointer
     * 注意:
     * 1. 字符串的操作可以转化为char[]  str.toCharArray()... new String(charArray)。 StringBuilder相对charArray不同。
     * 2. double pointer注意边界 可能需要多次判断！
     * @param number
     * @return
     */
    public String change1 (String number){
        char[] ca = number.toCharArray();
        for (int i=0,j=ca.length-1;i<j;i++,j--){
            while (i<ca.length && ca[i]%2 != 0) i++;
            while (j>=0 && ca[j]%2 != 0) j--;
            if (i<j){
                char tmp = ca[i];
                ca[i]= ca[j];
                ca[j] = tmp;
            }
        }
        return new String(ca);
    }

    public String change(String number) {
        StringBuilder sb = new StringBuilder(number);
        int i = 0, j = sb.length()-1;
        for (; i<sb.length() && j>=0 && i<j; i++,j--){
            while (i<sb.length() &&  (sb.charAt(i)-'0')%2!=0) i++; // 直到找到偶数
            while (j>=0 && (sb.charAt(j)-'0')%2!=0) j--;
            // 替换
            if (i<j){
                String tmp = sb.charAt(i)+"";
                sb.replace(i,i+1,sb.charAt(j)+"");
                sb.replace(j,j+1,tmp);
            }
        }
        return sb.toString();
    }

    // String tmp = sb.charAt(i-1)+"";
    // sb.replace(i-1,i,sb.charAt(j+1)+"");
    // sb.replace(j+1,j+2,tmp);
}
