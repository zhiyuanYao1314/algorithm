package array;


import java.util.Arrays;
import java.util.LinkedList;

import static sort.QuickSort.swap;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Main7 {
    public static void main(String[] args) {
        Main7 main7 = new Main7();
        int[] ints = {1};
        main7.reOrderArray(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void reOrderArray2(int [] array) {
        LinkedList<Integer> even = new LinkedList<>();
        LinkedList<Integer> odd = new LinkedList<>();
        for (int k:array){
            if ((k&1) ==1){
                even.add(k);
            }else {
                odd.add(k);
            }
        }
        int i=0;
        for (int e: even){
            array[i++] = e;
        }
        for (int o:odd){
            array[i++] = o;
        }
    }

    public void reOrderArray(int [] array) {
        //TODO
        if (array == null || array.length==1) return ;
        int len = array.length;
        int i=0, j=1;
        while (!(i>=len || j>=len)){
            while (i<len && array[i]%2 !=0){ // 遇到偶数
                i++;
            }
            while (j<len && array[j]%2==0){ // 遇到奇数
                j++;
            }
            if (i<j && j<len){
                swap(array, i,j);
            }
            if (i>j){
                j =i+1;
            }
        }
    }

}
