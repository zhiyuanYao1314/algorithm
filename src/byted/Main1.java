package byted;

import java.util.HashMap;
import java.util.Map;

/**
 * 子串连续；
 * 无重复字符的最长子串
 * abcabcbb 3
 */

public class Main1 {

    public static void main(String[] args) {

        System.out.println(noDuplicateSubString("abcabcaas"));
    }

    public static int noDuplicateSubString(String str){
        int s =0;// 当前的开始起点，每当i的字母出现在loc中的时候，更新；
        Map<Character, Integer> loc = new HashMap<>();
        loc.put(str.charAt(0), s);
        int ret=1;
        for (int i =1;i<str.length();i++){
            if (!loc.containsKey(str.charAt(i))){
                ret = Math.max(ret, i-s+1);
            }else {
                s = loc.get(str.charAt(i))+1;
            }
            loc.put(str.charAt(i), i);
        }
        return ret;
    }
}
