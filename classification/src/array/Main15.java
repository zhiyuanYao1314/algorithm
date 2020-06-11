package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Time:2020/4/22 12:42
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Main15 {
    public static void main(String[] args) {
        // int k = 2 & -2 ;// 2
        // int k = 5 & -5 ; //1
        int k = 16 & -16 ; //16
        System.out.println(k);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet();
        for (Integer i:array){
            if (set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        int k=0;
        for (int i: set){
            if (k++ %2 ==0){
                num1[0] =i;
            }else num2[0] =i;

        }
    }
}
