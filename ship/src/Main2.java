
import sun.awt.ScrollPaneWheelScroller;

import java.util.*;
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();sc.nextDouble();sc.nextLine();
        while (sc.hasNext()) {
            int k = sc.nextInt();
        }
        // array list
        ArrayList list = new ArrayList();
        list.add(1);
        list.remove(2);
        // foreach 循环 for循环

        Stack stack = new Stack();
        stack.isEmpty();
        stack.push(1);
        stack.pop();

        Queue queue = new LinkedList();
        ((LinkedList) queue).push(1);
        queue.poll();

        class Node{
            int value;
            Node left;
            Node right;
        }

        // 3大排序算法。
        String str = new String("123");

        // 字符串
        String[] strs = str.split("1");
        for (int i=0;i<str.length();i++){
            str.charAt(i);
        }
        str = str.trim();
        str.substring(1,2);
        str.replace("a","b");
        char[] chars = str.toCharArray();

    }
}