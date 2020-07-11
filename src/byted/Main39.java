package byted;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 栈
 */
public class Main39 {
    public static void main(String[] args) {
        Main39 m = new Main39();
        boolean s = m.isValid("[{}]");
        System.out.println(s);
    }
    public boolean isValid(String s) {
        if (s==null || s.length()==0){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                if (stack.isEmpty() || stack.peekLast() !=map.get(s.charAt(i))){
                    return false;
                }else {
                    stack.removeLast();
                }
            }else {
                stack.addLast(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
