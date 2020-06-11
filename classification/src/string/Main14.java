package string;

import javax.xml.stream.events.Characters;
import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 11:55
 * leetcode 387 字符串中的第一个唯一字符
 */

public class Main14 {

    /**
     * hashmap;
     * 求value最小
     * time: n
     * space:
     */
    public int firstUniqChar(String s) {
        if (s==null) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<s.length();i++){
            if (map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }

}
