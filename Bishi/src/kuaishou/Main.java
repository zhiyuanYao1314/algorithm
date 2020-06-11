package kuaishou;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str = sc.nextLine();

        int first =0;
        int left =0;
        int right =0;
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c=='('){
                stack.push(c);
            }else if (c==')' && !stack.isEmpty()&& stack.peek()=='('){
                stack.pop();
                first++;
            }else if (c==')'){
                right++;
            }
        }
        left = stack.size();
        System.out.println(first+" "+left+" "+right);
    }
}
