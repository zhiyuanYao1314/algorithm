package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Time:2020/4/21 22:31
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Main8 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
    // abadbc
    public static int FirstNotRepeatingChar(String str) {
        if (str==null || str.length()==0) return -1;
        HashMap<Character, Integer> map = new HashMap();
        ArrayList<Character> onlys = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            Character cur = str.charAt(i);
            if (map.get(cur)==null){
                map.put(cur, 1);
                onlys.add(cur);
            }else {
                map.put(cur, 2);
                onlys.remove(cur);
            }
        }
        if (onlys.size()==0) return -1;
        return str.indexOf(onlys.get(0));
    }
}
