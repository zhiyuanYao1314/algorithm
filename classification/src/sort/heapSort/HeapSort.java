package sort.heapSort;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/27 13:40
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] ints = {5,3,6,7,4,8,3};
        // buildHeap(ints);
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    static void heapSort(int[] nums){
        buildHeap(nums);
        sort(nums);
    }
    private static void sort(int[] nums) {
        int size = nums.length;
        int i=0;
        while (size>0){
            swap(nums, i, --size);
            heapify(nums, i, size);
        }
    }
    static void buildHeap(int[] nums){
        int n = nums.length;
        int s = n/2-1;
        for (int i=s;i>=0;i--){
            heapify(nums, i,nums.length);// 从当前位置向下过滤
        }
    }
    private static void heapify(int[] nums, int i, int size) {
        int n = 2*i+1;
        while (n<size){
            int maxIndex = n+1<size && nums[n+1]>nums[n]?n+1:n;
            int max = n+1<size && nums[n+1]>nums[n]?nums[n+1]:nums[n];
            if (max<nums[i]) break;
            swap(nums, i, maxIndex);
            i = maxIndex;
            n = 2*i+1;
        }
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
