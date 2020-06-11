package huawei;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ns = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        int n = sc.nextInt();
        int l =sc.nextInt();
        while (!(n==0 && l==0)){
            ns.add(n);
            ls.add(l);
            n= sc.nextInt();
            l =sc.nextInt();
        }
        for(int i = 0; i < ns.size(); i++){
            test(ns.get(i),ls.get(i));
        }
    }

    public static void test(int n, int l){
        if (n==0 || l==0) System.out.println(0);

        BigDecimal sum = new BigDecimal(0);
        BigDecimal bd = new BigDecimal(n);
        for (int i=1;i<=l;i++){
            sum =sum.add(bd.pow(i));
        }
        BigDecimal res = sum.remainder(new BigDecimal(1000000007));
        System.out.println(res);
    }
}