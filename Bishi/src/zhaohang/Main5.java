package zhaohang;

import java.util.HashMap;
import java.util.Scanner;

public class Main5 {

    // 100%
    static HashMap<Character, Character> map = new HashMap<>();
    public static void main(String[] args) {
        map.put('1','1');
        map.put('2','5');
        map.put('3','8');
        map.put('4','7');
        map.put('6','9');
        map.put('5','2');
        map.put('8','3');
        map.put('7','4');
        map.put('9','6');
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] strs = new String[n];
        // sc.nextLine();
        for(int i = 0; i < n; i++){
            String str = sc.nextLine().trim();
            strs[i]= str;
        }

        for (String s : strs){
            test(s);
        }
    }

    public static void test(String str){
        if (str.length()==1 && str.charAt(0) != '1') {
            System.out.println("NO");
            return;
        }
        int l =0;
        int r = str.length()-1;
        while (l<=r && l<str.length() && r>=0){
            if (map.get(str.charAt(l)) == str.charAt(r)){
                l++;
                r--;
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}