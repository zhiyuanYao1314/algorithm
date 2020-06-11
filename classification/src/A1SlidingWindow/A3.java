package A1SlidingWindow;
import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 19:04
 * 不含有相同字符的最长子串
 * 给定字符串str，计算包括k个不同字符的最长子串的长度。
 * 如给定字符串“eceba”和k=3，则包括3个不同字符的最长子串为“eceb”，其长度为4。
 */
public class A3 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        int length = a3.maxLength("aaabcdeefla", 2);
        // int length = a3.maxLength("abcdefla", 2);
        System.out.println(length);
    }
    public static int maxLength(String str, int k){
        // if (str==null ||str.length()<k) return -1;
        // 用于存放每个元素的位置；
        HashMap<Character, Integer> map= new HashMap<>();
        map.put(str.charAt(0), 0);
        int l = 0;// 左边界
        int r=1; // 右边界
        int count=1; // 数量
        int max =0; // 最大值
        while (r<str.length()){
            Integer location = map.get(str.charAt(r));
            if (location!=null){ // 出现过
                l = location+1; // 更新左边界为出现过的位置的下一个；
                count = r-l+1; // 更新数量
            }else {
                if (++count>max){ // 更新数量并判断
                    max = count;
                }
            }
            map.put(str.charAt(r),r); // 更新出现过的字母的位置
            r++;
        }
        return max;
    }
}
