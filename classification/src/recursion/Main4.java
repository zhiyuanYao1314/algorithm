package recursion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 16:02
 * 4. 两个排好序的数组的第k个最小值。
 * time: logk
 * space:
 */
public class Main4 {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3,4};
        Main4 main4 = new Main4();
        double ans = main4.findMedianSortedArrays(a,b);
        // double kk = main4.getKth(a,0,b,0,4);
        System.out.println(ans);
        // System.out.println(kk);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length==0)
            return (double)(nums2[nums2.length/2]+nums2[(int)((double)nums2.length/2-0.5)])/2;
        if (nums2==null || nums2.length==0)
            return (double)(nums1[nums1.length/2]+nums1[(int)((double)nums1.length/2-0.5)])/2;
        int k1 = (nums1.length+nums2.length+1)/2;
        int k2 = (int)((double)(nums1.length+nums2.length+1)/2+0.5);
        return  ((double)getKth(nums1,0,nums2,0,k1)+(double)getKth(nums1,0,nums2,0,k2))/2;
    }

    double getKth(int[] a, int as,  int[] b, int bs,  int k){
        // 退出条件1: a或b超出数组界限
        if (as==a.length) return b[bs+k-1];
        if (bs== b.length) return a[as+k-1];
        // 退出条件2: k只剩下一个元素；
        if (k==1) return Math.min(a[as],b[bs]);
        // 递归
        // 取k的一半或者最后一个元素
        int mida = Math.min(as+k/2-1, a.length-1);
        int midb = Math.min(bs+k/2-1, b.length-1);
        if (a[mida]>b[midb]){
            return getKth(a,as,b,midb+1,k- (midb-bs+1));
        }else {
            return getKth(a,mida+1,b,bs,k- (mida-as+1));
        }
    }
}
