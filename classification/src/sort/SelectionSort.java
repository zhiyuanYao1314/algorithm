package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        if (arr == null) return;
        for (int i=0;i<arr.length-1;i++){
            int max = 0;
            int j=0;
            for (;j<arr.length-i;j++){
                if (arr[j]>arr[max]) max = j;
            }
            swap(arr, max, arr.length-1-i);
        }
    }
    public  static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
