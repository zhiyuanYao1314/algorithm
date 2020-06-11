package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 14:25
 * Describe:
 * version:1.0
 */
public class MaxInteger {

    public static void main(String[] args) {
        MaxInteger m = new MaxInteger();
        System.out.println(m.solve("012345BZ16"));
    }

    /**
     * 字符串中最大的16进制：
     *  遍历字符串，遇到数字或A到F之间的字母时将其加入一个临时字符串中，
     *  遇到G到Z的字母时将之前的临时字符串变为数字并更新答案。
     *
     * @param s
     * @return
     */
    public int solve (String s) {
            // "012345BZ16"
            // A B C D E F
            //
            String max ="";
            for (int i=0;i<s.length();i++){
                int len =0;
                String temp = "";
                while (i+len<s.length() &&
                        ( (s.charAt(i+len)>='0' && s.charAt(i+len)<='9' )||
                        (s.charAt(i+len)>='A' && s.charAt(i+len)<='F') )
                ){
                    temp =temp + s.charAt(i + len);
                    len++;
                }
                if (compareTwoString(temp, max)) max = temp;
                // System.out.println(max);
                i = i+len;
            }
            return sti(max);
        }

        public boolean compareTwoString(String s1, String s2){
            if (s1.length()>s2.length()){
                // System.out.println(s1+" > "+s2);
                return true;
            }
            if (s1.length()<s2.length()){
                // System.out.println(s1+" < "+s2);
                return false;
            }
            if (s1.length()==s1.length()){
                for (int i=0;i<s1.length();i++){
                    if (s1.charAt(i)>s2.charAt(i)){
                        return true;
                    }
                    if (s1.charAt(i)<s2.charAt(i)){
                        return false;
                    }
                }
            }
            return false;
        }

        public int sti(String s){
            int value =0;
            for (int i=0;i<s.length();i++){
                char c = s.charAt(i);
                int t;
                if (c>='0' && c<='9') t = c-'0';
                else t = c-'A'+10;
                value = value*16+t;
            }
            return value;
        }
        public int intoInt(String s){
            // 2382jasv73162
            //  2382 a 73162
            int value =0;
            for (int i=0;i<s.length();i++){
                char c = s.charAt(i);
                int tmp =0;
                if (c>='0' && c<='9') tmp = Integer.parseInt(c+"");
                else if(c=='A') tmp =10;
                else if (c=='B') tmp =11;
                else if (c=='C') tmp =12;
                else if (c=='D') tmp =13;
                else if (c=='E') tmp =14;
                else if (c=='F') tmp =15;
                value = value*16+tmp;
            }

            return value;
        }
}
