package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= new int[]{1,3,2,7,5,3,5};
        int[] l = new int[]{1,3};
        int[] r = new int[]{2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        if (arr== null || arr.length==1) return;
        // 分
        int mid = (arr.length-1)>>2; //1,   3  1
        int[] left = new int[mid+1]; // 2
        int[] right = new int[arr.length-(mid+1)];  //1
        for (int i=0;i<mid+1;i++){
            left[i] = arr[i];
        }
        for (int i=0;i<arr.length-(mid+1);i++){
            right[i] = arr[mid+1+i];
        }
        mergeSort(left);
        mergeSort(right);
        // 和
        merge(arr, left,right);
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if (left[i]<right[j]){
                arr[k++] = left[i++];
            }else arr[k++] = right[j++];
        }
        if (i == left.length){
            for (int m= k;m<arr.length; m++){
                arr[m] = right[j++];
            }
        }else {
            for (int m= k;m<arr.length; m++){
                arr[m] = left[i++];
            }
        }
    }
}
