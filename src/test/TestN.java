package test;

import java.util.Arrays;
import java.util.Comparator;

public class TestN {

    public static void main(String[] args) {

        String[] strs = new String[]{"123", "13", "F124", "负1", };
        order(strs);
        System.out.println(Arrays.toString(strs));
    }

    static void order(String[] strs){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 比较第一位数字：
                char c1 = o1.charAt(0);
                char c2 = o2.charAt(0);

                int len = o1.length()-o2.length();
                return len!=0?len:(o1.compareTo(o2));
            }
        });
    }
}

// 1. 取出字符串中
// 2.