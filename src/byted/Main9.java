package byted;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main9 {
    public static void main(String[] args) {

    }

    // 3[abc]2[a2[c]]ef;
    String decodeString(String str){
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0;i<str.length();i++){
            // []
            Character c = str.charAt(i);
            if (']' != c){
                stack.addLast(str.charAt(i));
            }else { // ]
                Deque<Character> s2 = new ArrayDeque<>();
                Character cur = stack.peekLast();
                while (cur != '['){
                    s2.addLast(stack.removeLast());
                    cur = stack.peekLast();
                }
                stack.removeLast();
                while (!s2.isEmpty()){
                    // 重复 然后重新加回；
                }
            }

        }

        return null;
    }
}
