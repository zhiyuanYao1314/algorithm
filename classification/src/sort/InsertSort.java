package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/5 13:57
 * Describe:
 * version:1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr){
        if (arr == null || arr.length==1) return;
        for (int i=1;i<arr.length; i++){
            int j=i-1;
            int tmp = arr[i];
            while (j>=0 && arr[j]>tmp){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = tmp;
        }

    }
}
