package xiecheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 14:46
 * Describe:
 * version:1.0
 */
public class LinkCycle {

    // a,b,a ;;a,b,c
    // 利用hashset add 成功添加返回true， 否则返回fasle
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        String[]  strs = str.split(",");
        Set<String> sets = new HashSet();
        for (String ele:strs){
            if (! sets.add(ele)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);

    }

}
