package byted;

/**
 * 4 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Main51 {
    public static void main(String[] args) {
        Main51 m = new Main51();
        int[] nums1 = new int[]{1,3,5,9};
        int[] nums2 = new int[]{2,3,5,7};
        double res = m.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
    /**
     *  1 3 5 9
     *  2 3 5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int tar1 = (n1+n2+1)/2;//   7 4 , 8 4
        int tar2 = (n1+n2)/2+1; //7 4   8 5
        int pre = help(nums1, 0, nums1.length-1, nums2,0,nums2.length-1,tar1);
        int post = help(nums1, 0, nums1.length-1, nums2,0,nums2.length-1,tar2);
        return (double)(pre+post)/(double)2;

    }
    public int help(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int tar){
        int mid1 = l1+ ((r1-l1)>>1);
        int mid2 = l2+ ((r2-l2)>>1);
        if (nums1[mid1]<nums2[mid2]){
            tar -= (mid1 - l1+1);
            l1 = mid1+1;
            if (tar==0)
                return nums1[mid1];
        }else {
            tar -=(mid2 - l2+1);
            l2 = mid2+1;
            if (tar==0){
                return nums2[mid2];
            }
        }
        return help(nums1,l1, r1, nums2, l2, r2, tar);
    }


}
