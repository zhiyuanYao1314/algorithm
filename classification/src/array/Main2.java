package array;

import java.util.ArrayList;

/**
 * 打印数组的所有排列组合
 */
public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        combain(arr1, new ArrayList<>());
    }

    /**
     * 思路：
     * 递归，每一层只取剩余元素中的一个，然后传下去，
     * 当元素取完的时候，打印出来。
     * 注意: 数组需要复制一下，因为数组传递的是引用；
     * time: n^2
     * space:n^2
     */
    public static void combain(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        if (arr1.isEmpty()){
            for (int i=0;i<arr2.size();i++){
                System.out.print(arr2.get(i)+" ");
            }
            System.out.println();
        }
        for (Integer i: arr1){
            ArrayList<Integer> a1Tmp = (ArrayList<Integer>) arr1.clone();
            a1Tmp.remove(i);
            ArrayList<Integer> a2Tmp = (ArrayList<Integer>) arr2.clone();
            a2Tmp.add(i);
            combain(a1Tmp,a2Tmp);
        }
    }
}
