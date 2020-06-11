package xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main22 {

    // return 1;
    // 25%
    // int sum =0;
    // for (int i: birthYear){
    //     if (i<=x)sum += i;
    // }
    // return n*(2^sum);

    // 63%
    static void moveOne(long[] all){
        for (int i=all.length-1;i>=1;i--){
            all[i] = all[i-1];
        }
        all[0] =0;
    }
    static long newOne(long[] all, int[] birthYear,int x){
        int sum =0;
        for (int year:birthYear){
            if (year<=x){
                sum +=all[year];
            }
        }
        return sum;
    }

    static long countDolphin(int n, int m, int[] birthYear, int x) {
        long[] d = new long[x+1];
        d[0] = n;
        for (int i =1;i<=x;i++){
            // move
            moveOne(d);
            // newOne
            long res = newOne(d, birthYear, x);
            d[0] = res;

        }
        int res=0;
        for (long k:d){
            res += k;
        }
        return res;

    }
    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        int _n; // 初始
        _n = Integer.parseInt(in.nextLine().trim());

        int _m; // 寿命
        _m = Integer.parseInt(in.nextLine().trim());

        int _birthYear_size = 0;
        _birthYear_size = Integer.parseInt(in.nextLine().trim());
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for(int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = Integer.parseInt(in.nextLine().trim());
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;  //x年后
        _x = Integer.parseInt(in.nextLine().trim());

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(String.valueOf(res));

    }
}
