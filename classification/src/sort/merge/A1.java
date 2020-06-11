package sort.merge;

import sort.MergeSort;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 16:56
 * 5 3 6 4 7
 * 2 0 1 0 0 = 3;
 * 降序对
 */
public class A1 {


    int descendDouble(int[] nums){
        return 0;
    }




    public static void main(String[] args) {
        System.out.println(1>>1);
        int[] ints = {3, 6, 5,34,4,3,2};
        System.out.println(mergeSort(ints));
    }
    public static int mergeSort(int[] nums){
        if (nums==null || nums.length==1) return 0;
        int sort = sort(nums, 0, nums.length - 1);
        return sort;
    }

    //3, 6, 5,34,4,3,2  0 ---6   4---6 6--6
    static int sort(int[] nums,int l,int r){
        if (l>=r) return 0; // == 只有一个元素 直接返回
        int mid = l + ((r-l)>>1);// 注意先后顺序；
        int left = sort(nums, l, mid);
        int right = sort(nums, mid+1, r);
        int cur = merge2(nums, l, mid, r);// 将l..mid 和mid+1...r合并
        return left+right + cur;
    }

    // l..mid; mid+1 ..r
    // 每一层计算这个元素前半段有多少元素比他大
    static int merge2(int[] nums,int  l,int mid,int r){
        int s1 = l;
        int s2 = mid+1;
        int[] tmp = new int[r-l+1];
        int i =0;
        int ret=0;
        while (s1<=mid && s2<=r){
            ret = nums[s2]<nums[s1]?mid-s1+1:0;
            tmp[i++] = nums[s1]<=nums[s2]?nums[s1++]:nums[s2++];
        }
        while (s1<=mid){
            tmp[i++] = nums[s1++];
        }
        while (s2<=r){
            tmp[i++] = nums[s2++];
        }
        for (int j=0;j<tmp.length;j++){
            nums[l+j] = tmp[j];
        }
        return ret;
    }

    static void merge(int[] nums,int  l,int mid,int r){
        int s1 = l;
        int s2 = mid+1;
        int[] tmp = new int[r-l+1];
        int i =0;
        while (s1<=mid && s2<=r){
            tmp[i++] = nums[s1]<=nums[s2]?nums[s1++]:nums[s2++];
        }
        while (s1<=mid){
            tmp[i++] = nums[s1++];
        }
        while (s2<=r){
            tmp[i++] = nums[s2++];
        }
        for (int j=0;j<tmp.length;j++){
           nums[l+j] = tmp[j];
        }
    }
}