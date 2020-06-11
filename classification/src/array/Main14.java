package array;

import java.util.Arrays;

/**
 * Time:2020/4/22 11:10
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Main14 {

    public static void main(String[] args) {
        Main14 main14 = new Main14();
        int[] arr = new int[]{3,2,1,4,5,5,6,3};// 2 1 1 1 1 1
        int i = main14.InversePairs(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(i);
    }

    public int InversePairs(int [] array) {
        if (array==null || array.length<=1) return 0;
        mergeSort(array);
        return (int) (count%1000000007);
    }
    public void mergeSort(int[] array){
        if (array.length==1) return;
        int leftLen = array.length>>1; // 1
        // 3 1 2 4
        int[] left = new int[leftLen];// 0
        int[] right = new int[array.length-leftLen]; // 2
        int k=0;
        for (int i=0;i<leftLen;i++){
            left[k++] = array[i];
        }
        k=0;
        for (int i=leftLen;i<array.length;i++){
            right[k++] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        combain(array, left, right);
    }
    private long count =0;
    private void combain(int[] array, int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int li=0, ri=0;
        int i=0;
        while (li<leftLen && ri<rightLen){
            if (left[li]>right[ri]){
                array[i++] = right[ri++];
                count += leftLen-li; // 前一半有这么多数是逆序对
            }else {
                array[i++] = left[li++];
            }
        }
        if (li==leftLen){
            while (ri<rightLen){
                array[i++] = right[ri++];
            }
        }else {
            while (li<leftLen){
                array[i++] = left[li++];
            }
        }
    }
}
