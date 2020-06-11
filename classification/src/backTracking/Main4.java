package backTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 13:39
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class Main4 {
    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0) return ans;
        map.put('2',"abc");map.put('3',"def");
        map.put('4',"ghi");map.put('5',"jkl");map.put('6',"mno");
        map.put('7',"pqrs");map.put('8',"tuv");map.put('9',"wxyz");
        this.digits = digits;
        allcombin(0, new String());
        return  ans;
    }
    String digits;
    HashMap<Character, String> map = new HashMap();
    List<String> ans = new LinkedList<>();
    private void allcombin(int i, String str) {
        if (i==digits.length()) {
            ans.add(str);
            return;
        }
        String s = map.get(digits.charAt(i));
        for (int j=0;j<s.length();j++){
            allcombin(i+1,str+s.charAt(j));
        }
    }

}
