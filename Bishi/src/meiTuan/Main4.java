package meiTuan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 有时候，申请大的全局数组会导致超时，
 * 如果有此类情况，请检查您的全局数组是否超过题目要求的内存大小。
 * 排除这个错误后，
 * 再检查别的情况引起的超时错误：
 * 例如死循环、循环结束条件错误等，或者需要更好的算法
 *  %55
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(5^3);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i =0;i<n;i++){
            p[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> minMap = new HashMap<>();
        for (int i =0;i<n-1;i++){
            int max=p[i];
            int min=p[i];
            for (int j =i+1;j<n;j++){
                if (p[j]>max){
                    max = p[j];
                }
                if (p[j]<min){
                    min = p[j];
                }
                if (map.get(max) == null){
                    map.put(max,1);
                }else map.put(max, map.get(max)+1);

                if (minMap.get(min) == null){
                    minMap.put(min,1);
                }else minMap.put(min, minMap.get(min)+1);
            }
        }

        int res =0;
        for (Integer s: map.keySet()){
            if (map.get(s)%2!= 0){
                res ^= s;
                // System.out.println("max: "+s); //5
            }
        }
        for (Integer s: minMap.keySet()){
            if (minMap.get(s) %2 != 0){
                // System.out.println("minV: "+minMap.get(s));
                // System.out.println("min: "+s);
                res ^= s;
            }
        }
        System.out.println(res);
    }
}
