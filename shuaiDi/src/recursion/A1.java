package recursion;

import java.util.Arrays;

/**
 * 在两个⻓长度相等的排序数组中找到上中位数
 * 如[1 2 3 4] [3 4 5 6]  可能包括
 * 如果[1 2 3 4 5 ] [2 4 5 6 7] 不包括
 * 如果只有一个元素[1]  [3]则返回较小值
 * time O(logN)
 * space O(1)
 */
public class A1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,5};
        int[] arr2 = new int[]{3,4,5,6};
        int[] arr3 = new int[]{1,2,3,4,5};
        int[] arr4 = new int[]{3,4,5,6,7};
        int[] arr5 = new int[]{1,2};
        int[] arr6 = new int[]{1,2};
        System.out.println( getUpMedian(arr1, arr2));
        System.out.println( getUpMedian(arr3, arr4));
        // System.out.println( getUpMedian(arr5, arr6));
        System.out.println( getMin(arr1, arr2));
        System.out.println( getMin(arr3, arr4));
    }

    public static int getUpMedian(int[] arr1, int[] arr2) {
        return getMin(arr1, arr2, 0,arr1.length-1,0,arr2.length-1);
    }

    /**
     * 递归
     */
    private static int getMin(int[] arr1, int[] arr2, int a1l,int a1r, int a2l, int a2r ){
        if (a1l>= a1r) {
            return Math.min(arr1[a1l], arr2[a2l]);
        }
        int midL = (a1l+a1r)/2;
        int midR = (a2l+a2r)/2;
        int len = a1r-a1l+1;
        if (len %2==0){
            if (arr1[midL]>arr2[midR]){
                return getMin(arr1,arr2,a1l,midL,midR+1,a2r);
            }else return getMin(arr1, arr2, midL+1, a1r,a2l,midR);
        }else {
            if (arr1[midL]>arr2[midR]){
                return getMin(arr1,arr2,a1l,midL,midR,a2r);
            }else return getMin(arr1, arr2, midL, a1r,a2l,midR);
        }
    }

    /**
     * 迭代
     */
    private static int getMin(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int a1l =0;
        int a1r =len1-1;
        int a2l =0;
        int a2r = len2-1;
        int mid1 =(a1r-a1l)/2;
        int mid2 =(a2r-a2l)/2;
        while (a1l<a1r && a2l<a2r){
            if (len1%2==0){
                if (arr1[mid1]>arr2[mid2]) {
                    a1r = mid1;
                    a2l = mid2+1;
                }else {
                    a1l = mid1+1;
                    a2r = mid2;
                }
                // 奇数
            }else {
                if (arr1[mid1]>arr2[mid2]) {
                    a1r = mid1;
                    a2l = mid2;
                }else {
                    a1l = mid1;
                    a2r = mid2;
                }
            }
            mid1 =(a1r-a1l)/2;
            mid2 =(a2r-a2l)/2;
            len1 = a1r-a1l+1;
        }
        return Math.min(arr1[a1l], arr2[a2l]);
    }



}
