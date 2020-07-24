package 跟谁学;

public class Main1 {
    public static void main(String[] args) {

    }

    /**
     * 两个大的正整数相减，返回结果
     * @param a
     * @param b
     * @return
     */
    public String reduce(String a, String b){
        // 0. 特殊值处理；
        if (a==null || b==null){
            return null;
        }
        if (a.length()==0 || b.length()==0){
            return null;
        }
        // 1. 取出两个数的较大值和较小值；
        String max ="";
        String min ="";
        boolean isNegative = false;
        if (a.length()>b.length()){
            max = a;
            min = b;
        }else if (a.length()<b.length()){
            max = b;
            min = a;
            isNegative = true;
        }else {
            int i=0;
            for(;i<a.length();i++){
                if (a.charAt(i)<b.charAt(i)){
                    min = a;
                    max = b;
                    isNegative = false;
                }else if(a.charAt(i)>b.charAt(i)){
                    min = b;
                    max = max;
                }
            }
            if (i==a.length()){
                return "0";
            }
        }
        // 2.
        StringBuffer sb = new StringBuffer();
        int minIndex = min.length()-1;
        int maxIndex = max.length()-1;
        int less =0;
        while (minIndex>=0){
            int first = max.charAt(maxIndex)-'0'-less;
            int second = min.charAt(minIndex)-'0';
            if (first>=second){
                sb.append(first-second);
                less =0;
            }else{
                less =1;
                sb.append(first+10-second);
            }
            minIndex--;
            maxIndex--;
        }
        while (maxIndex>=0){
            int tmp = max.charAt(maxIndex)-less;
            less =0;
            if (tmp<0){
                tmp += 10;
                less=1;
            }
            sb.append(tmp);
            maxIndex--;
        }
        String ret = sb.reverse().toString();
        return isNegative?("-"+ret):ret;
    }
}
