package Baidu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 18:38
 * Describe:
 * version:1.0
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] price = new int[num];
        int i=0;
        while (sc.hasNext()){
            price[i++] = sc.nextInt();
        }
        Arrays.sort(price);
        System.out.println(Arrays.toString(price));
    }

}
