package A1SlidingWindow;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 20:44
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 */
public class A4 {

    public static void main(String[] args) {
        A4 a4 = new A4();
        int length = a4.maxLength("aaaaaaakaolkj", 3);
        System.out.println(length);
    }

    /**
     * 滑动窗口+ hashmap
     *  if map.get==null && map.size==k : l=map.remove, count
     *  else count++
     *  map.put(). r++,
     */

    public static int maxLength(String str, int k){
        if (str ==null || str.length()==0) return -1;
        int l =0, r=0; // 左右界限
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(l),l);
        int max=0;
        int count =0;
        while (r<str.length()){
            Integer loc = map.get(str.charAt(r));
            if (loc == null && map.size()==k){ // map已经达到k，
                l = remove(map); // 移除最前面的元素；
                count = r-l+1; // 更新count
            }else
                count++; // r元素存在或者还未达到k，count++
            map.put(str.charAt(r), r);
            r++;
            if (count>max){
                max =count;
            }
        }
        return max;
    }

    private static int remove(HashMap<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        Character move =0;
        for (Character c:map.keySet()){
            if (map.get(c)<min){
                min = map.get(c);
                move =c;
            }
        }
        map.remove(move);
        return min+1;
    }
}
