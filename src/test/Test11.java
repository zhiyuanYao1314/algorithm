package test;

import java.util.Arrays;


/**
 * bubble insertionSort selection
 *
 * quick: 平均nlogN space: logN, swap交换 不稳定
 * merge：nlogn n, space: n 稳定
 * heap nlogn sapce 1 不稳定；
 */
public class Test11 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,5,3,2,0,8,4,9};
//        bubble(arr);
//        insertionSort(arr);
//        selectionSort(arr);
//        quick(arr,0,arr.length-1);
//        merge(arr, 0, arr.length-1);
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }


    // n2; 稳定；
    static  void bubble(int[] arr){
        int n = arr.length;
        for (int i=n-1;i>=1;i--){ // i表示这次确定哪个元素的位置；
            for (int j=0;j<=i-1;j++){// 当前对比哪两个元素
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= tmp;
                }
            }
        }
    }

    // n2, n, 稳定
    static void insertionSort(int[] arr){
        int n= arr.length;
        for (int i=1;i<n;i++){ // i表示现在考虑前面第n个元素
            int tmp = arr[i];
            for (int j=i-1;j>=0;j--){// 当前对比的i前面的第j个元素
                if (tmp>=arr[j]){
                    arr[j+1] = tmp;
                    break;
                }
                arr[j+1] =arr[j];
            }
            if (tmp<arr[0])
                arr[0] = tmp;
        }
    }

    // n2, 稳定；
    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i=0;i<n-1;i++){
            int minIndex = i;
            for (int j=i;j<n;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }


    static void quick(int[] arr, int s, int e){
        // []
        if (s>=e) return;
        int i = partition(arr, s, e); // left<= i ; right>i;
        quick(arr, s, i-1);
        quick(arr, i+1,e);

    }

    private static int partition(int[] arr, int s, int e) {
        int r = s;
        int t = arr[s];
        while (s<e){
            while (e>s && arr[e]>t) e--;
            while (s<e && arr[s]<=t) s++;
            if (s>=e) break;
            swap(arr, s, e);
        }
        swap(arr, r, s);
        return s;
    }

    public static void merge(int[] arr, int s, int e){
        if (s>=e) return;
        // 再一次注意： 位移运算符的优先顺序；
        int mid = s + ((e-s)>>1);
        merge(arr, s, mid);
        merge(arr, mid+1, e);
        combine(arr, s,mid, e);

    }

    // 两边都是有序的，进行combain
    private static void combine(int[] arr, int s, int mid, int e) {
        int s1 = s;
        int s2 = mid+1;
        int[] tmp = new int[e-s+1];
        int index = 0;
        while (s1<=mid && s2<=e){
            if (arr[s1]<arr[s2]){
                tmp[index++] = arr[s1++];
            }else {
                tmp[index++] = arr[s2++];
            }
        }
        if (s1==mid+1){
            while (s2<=e){
                tmp[index++] = arr[s2++];
            }
        }else {
            while (s1<=mid){
                tmp[index++] = arr[s1++];
            }
        }
        for (int i=0;i<tmp.length;i++){
            arr[s++] = tmp[i];
        }
    }

    // 5 2..
    private static void buildHeap(int[] arr) {
        int n = arr.length;
        int half = n/2-1;
        while (half>=0){
            //下沉
            int cur = half;
            int next = cur*2+1;
            while (next<n){
                if (next+1<n && arr[next+1]<arr[next]){
                    next = next+1;
                }
                if (arr[cur]<arr[next]){
                    break;
                }
                swap(arr, cur,next);
                cur = next;
                next = cur*2+1;
            }
            half--;
        }

    }


    private static void swap(int[] arr, int minIndex, int i) {
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }

}
