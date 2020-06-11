package sort;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/5 13:50
 * Describe:
 * version:1.0
 */
public class BubboSort {

    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        bubble(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void bubble(int[] arr){
        if (arr == null ) return;
        for (int i=0;i< arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}

