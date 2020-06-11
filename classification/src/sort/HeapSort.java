package sort;
import javafx.util.Builder;

import java.util.Arrays;

/**
 * 堆排序：
 * time: O(n)+O(n logN)
 * space: O(1)
 * 最大复杂度O(nlogN),
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,7,4,8,1}; // 3 2 1
        // buildHeap(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){
        buildHeap(arr); // O(n)
        System.out.println(Arrays.toString(arr));
        int r = arr.length-1;
        while (r>0){ // nlog(N)
            pop(arr, r--);
        }
    }

    // r表示当前未排序的数组的最后一个元素
    // O(logN)
    public static void pop(int[] arr, int r){
        // 交换最后一个元素和第一个最大的元素
        int tmp = arr[r];
        arr[r] = arr[0];
        arr[0] = tmp;
        //下滤道正确位置
        int i=0;
        while (i*2+1<r ){
            int bigger = i*2+1;
            if (bigger+1<r && arr[bigger+1]>arr[bigger]) bigger +=1;
            if (arr[bigger]>arr[i]){
                swap(arr,i,bigger);
                i = bigger;
            }else break;
        }
    }
    // n
    public static void buildHeap(int[] arr){
        if (arr == null || arr.length ==1) return;
        int len = arr.length;
        for (int i=(len-1)>>1; i>=0;i--){
            int index = i;
            while (index*2+1<len){
                int bigger = index*2+1;
                if (bigger+1<len && arr[bigger+1]>arr[bigger]){
                    bigger = bigger+1;
                }
                if (arr[bigger]>arr[index]){
                    swap(arr, index, bigger);
                    index = bigger;
                }else break;
            }
        }
    }
    private static void swap(int[] arr, int index, int bigger) {
        if (index == bigger) return;
        arr[index] = arr[index]^arr[bigger];
        arr[bigger] = arr[index]^arr[bigger];
        arr[index] =  arr[index]^arr[bigger];
    }

}
