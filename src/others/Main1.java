package others;


import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/7/12 13:11
 *
 * LC 224 基本计算器
 * 四则运算：
 * 1. 中缀表达式转 后缀表达式；
 * 2. 后缀表达式计算；
 */
public class Main1 {
    public static void main(String[] args) {
        Integer integer = new Integer('1');
        System.out.println(integer);
        Main1 main1 = new Main1();
        // int c = main1.calculate("(1+(4+5+2)-3)+(6+8)");
        // System.out.println(c);
    }

    // public int calculate(String s){
    //     List<Character> cs = toPostExpression(s);
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     for (Character c: cs){
    //         if (c<='9' && c>='0'){
    //             stack.addLast(c-'0');
    //             continue;
    //         }
    //         int num1 = stack.removeLast();
    //         int num2 = stack.removeLast();
    //         int res=0;
    //         switch (c){
    //             case '+':
    //                 res = num1+num2;
    //                 break;
    //             case '-':
    //                 res = num2-num1;
    //                 break;
    //             case '*':
    //                 res = num1*num2;
    //                 break;
    //             case '/':
    //                 res = num2/num1;
    //                 break;
    //         }
    //         stack.addLast(res);
    //     }
    //     return stack.peek();
    // }

    /**
     * 数字 输出到list，
     * 符号：()
     *  1.( 加入
     *  2.) 输出到list直到(
     * 运算符 +-*\//
     *  弹出stack的首位和当前的运算符对比，
     *  如果当前的优先级大，则输出
     *  若小于等于，则先弹出栈，在对比；
     *
     *  注意: 全部使用String
     */
    // public List<Integer> toPostExpression(String s){
    //     List<Integer> ans = new ArrayList<>();
    //     Deque<Character> stack = new ArrayDeque<>();
    //     Map<Character, Integer> map = new HashMap<>();
    //     map.put('+', 1);
    //     map.put('-', 1);
    //     map.put('*', 2);
    //     map.put('/',2);
    //     for (int i=0;i<s.length();){
    //         char c = s.charAt(i);
    //         if (c==' '){
    //             i++;
    //             continue;
    //         }
    //         if (c>='0' && c<='9'){
    //             Integer cur = 0;
    //             while (c>='0' && c<='9'){
    //                 cur = cur*10+(c-'0');
    //                 i++;
    //                 if (i<s.length())
    //                     c= s.charAt(i);
    //                 else
    //                     break;
    //             }
    //             ans.add(cur);
    //             continue;
    //         }
    //         if (c=='('){
    //             stack.addLast('(');
    //             continue;
    //         }
    //         if (c==')'){
    //             while (!stack.isEmpty()){
    //                 Character cur = stack.removeLast();
    //                 if (cur == '(')
    //                     break;
    //                 ans.add(new Integer(cur));
    //             }
    //             continue;
    //         }
    //         if (map.containsKey(c)){
    //             while (!stack.isEmpty() && (map.containsKey(stack.peekLast()) && map.get(stack.peekLast())>=map.get(c) )){
    //                 ans.add(stack.removeLast());
    //             }
    //             stack.addLast(c);
    //         }
    //     }
    //     while (!stack.isEmpty()){
    //         ans.add(stack.removeLast());
    //     }
    //     return ans;
    // }


}
