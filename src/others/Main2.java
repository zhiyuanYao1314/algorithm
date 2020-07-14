package others;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/7/12 15:11
 *
 * LC 150 逆波兰表达式
 */
public class Main2 {
    public static void main(String[] args) {

    }
    // ["4","13","5","/","+"]
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque();
        for (String s: tokens){
            if (isOperator(s)){
                int num2 = new Integer(stack.removeLast());
                int num1 = new Integer(stack.removeLast());
                int res=-1;
                switch (s){
                    case "+":
                        res = num1+num2;
                        break;
                    case "-":
                        res = num1-num2;
                        break;
                    case "*":
                        res = num1*num2;
                        break;
                    case "/":
                        res = num1/num2;
                        break;
                }
                stack.addLast(res+"");
            }else {
                stack.addLast(s);
            }
        }
        return new Integer(stack.peek());
    }

    public boolean isOperator(String s){
        if ("+".equals(s))
            return true;
        if ("-".equals(s))
            return true;
        if ("*".equals(s))
            return true;
        if ("/".equals(s))
            return true;
        return false;
    }



}
