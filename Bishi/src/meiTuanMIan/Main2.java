package meiTuanMIan;

import java.util.ArrayList;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        combain(list,new ArrayList<>());
    }

    public static void combain(ArrayList<Integer> a1,ArrayList<Integer> a2){
        if (a1.isEmpty()) {
            for (Integer a: a2){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        for (Integer i: a1){
            ArrayList<Integer> clone = (ArrayList<Integer>) a1.clone();
            clone.remove(i);
            ArrayList<Integer> a2C = (ArrayList<Integer>) a2.clone();
            a2C.add(i);
            combain(clone,a2C);
        }
    }

    public static void combin(ArrayList<Integer> list ){
        if (list.isEmpty()) {
            System.out.println();
            return;
        }
        for(int i=0;i<list.size();i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Integer k:list) tmp.add(k);
            System.out.print(list.get(i)+" ");
            tmp.remove(i);
            combin(tmp);
        }
    }
}