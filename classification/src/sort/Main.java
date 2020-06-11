package sort;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        // int[] arr = new int[]{5,1,3,7,2};
        // insertSort(arr,0,4);
        // System.out.println(Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i=0;i<len;i++)
            arr[i] = sc.nextInt();
        quickSort(arr, 0,len-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r){

        // out
        if (l>=r) return;
        // 优化2：退出条件：当数组很小的时候，改为插入排序
        if (r-l>4){
            insertSort(arr, l,r);
        }
        // 优化1:
        // 是最左边的数成为中间数. 优化得放在退出条件之后。
        int mid = (l+r)>>1;
        swapThree(arr, l,mid,r);

        // divide()
        int index = divide(arr, l, r);
        // recursion
        quickSort(arr, l, index-1);
        quickSort(arr, index+1, r);
    }

    private static void insertSort(int[] arr, int l, int r) {
        for (int i=l+1;i<=r;i++){
            int tmp = arr[i];
            int j=i-1;
            while (j>=l && arr[j]>tmp){
                arr[j+1]=arr[j];
                --j;
            }
            arr[j+1] =tmp;
        }
    }

    private static void swapThree(int[] arr, int l, int mid, int r) {
        int middle = l;
        if (arr[l]>arr[mid]){
            if (arr[r]<arr[l]){
                middle = arr[mid]>arr[r]?mid:r;
            }
        }else { //l<mid
            if (arr[r]>arr[l]){
                middle = arr[r]>arr[mid]?mid:r;
            }
        }
        swap(arr, middle,l);
    }

    public static int divide(int[] arr, int l, int r){
        int i = l;
        int j = r;
        while(i<j){
            while (arr[j]>=arr[l] && i<j) j--; //右侧找到小值或边界
            while (arr[i]<=arr[l] && i<j) i++; // 左侧找到大值或边界
            if(i<j) swap(arr,i,j); // 交换
        }
        swap(arr, l, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}