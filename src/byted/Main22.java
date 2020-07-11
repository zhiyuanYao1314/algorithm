package byted;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394 字符串解码
 * s = "2[abc]3[cd2[]e]f]]"
 * 输出："abcabccdcdcdef"
 */
public class Main22 {

    public static void main(String[] args) {
//        String s = decodeString("2[abc]3[cd2[ef]]");
        String s = decodeString("100[leetcode]");

        System.out.print(s);

    }

    public static String decodeString(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if (']'!= c){
                stack.addLast(c);
            }else {// 开始弹出；
                Deque<Character> q = new ArrayDeque();
                while (!s.isEmpty()){
                    int num =1;
                    Character cur = stack.removeLast();
                    if (cur!='['){
                        q.addLast(cur);
                    }else {
                        String nums ="";
                        Character numP = stack.peekLast();
                        while (numP!=null && Character.isDigit(numP)){
                            numP = stack.removeLast();
                            nums =numP+nums;
                            numP = stack.peekLast();
                        }
                        num = new Integer(nums);
                        // 重新加回去；
                        for(int j=0;j<num;j++){
                            Deque<Character> copy = new ArrayDeque<>();
                            while (!q.isEmpty()){
                                Character cc = q.removeLast();
                                stack.addLast(cc);
                                copy.addFirst(cc);
                            }
                            q = copy;
                        }
                        break;
                    }

                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
