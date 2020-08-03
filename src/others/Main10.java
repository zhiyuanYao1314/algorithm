package others;


import java.util.*;

/**
 * 阿维
 * LeetCode 767：
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 思路：
 * 统计每个字母的个数，然后按i =i+2的频率；
 * 从高频到低频放置所有的字母；
 *
 */
public class Main10 {

    class CharAndCount{
        char c;
        int count;
        public CharAndCount(char c,int count){
            this.c = c;
            this.count = count;
        }
    }

    // pq;
//    public String reorganizeString(String s) {
//        Map<Character, CharAndCount> cs = new HashMap<>();
//
//        for (int i=0;i<s.length();i++){
//            CharAndCount cc = cs.get(s.charAt(i));
//            if (cc== null){
//                cc = new CharAndCount(s.charAt(i),0);
//            }
//            cc.count ++;
//            cs.put(s.charAt(i), cc);
//        }
//        Collection<CharAndCount> ccs = cs.values();
//
//    }
}
