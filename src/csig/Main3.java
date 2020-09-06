package csig;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/9/6 15:13
 * 作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
 * 老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
 * 例如:
 * 对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
 * 翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
 *
 * 60%
 */
public class Main3 {
    public static void main(String[] args) {
        // int[] ints = reverseCount(new int[]{2, 4, 3, 1});
        // System.out.println(count);
        // System.out.println(Arrays.toString(ints));
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        n = (int)Math.pow(2,n);
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i =0;i<n;i++){
            nums[i] = new Integer(strs[i]);
        }
        int m = new Integer(sc.nextLine());
        String[] strs2 = sc.nextLine().split(" ");
        int[] nums2 = new int[m];
        for (int i =0;i<m;i++){
            nums2[i] = (int)Math.pow(2,new Integer(strs2[i]));
        }

        for (int i=0;i<m;i++){
            int index=0;
            int k = nums2[i];
            while (index+k-1<n){
                int s = index;
                int e = index+k-1;
                while (s<e){
                    int tmp = nums[s];
                    nums[s] = nums[e];
                    nums[e] = tmp;
                    s++;
                    e--;
                }
                index = index+k;
            }
            reverseCount(nums);
            System.out.println(count);
            count=0;
        }

    }

    /**
     * 归并排序计算逆序对
     */
    static int count;
    static int[] reverseCount(int[] nums){
        int n =nums.length;
        if (n==1){
            return nums;
        }
        // 复制
        int mid = n/2;
        int[] nums1= new int[mid];
        int[] nums2 = new int[n-mid];
        for (int i=0;i<mid;i++){
            nums1[i] = nums[i];
        }
        for (int i=0;i<n-mid;i++){
            nums2[i] = nums[mid+i];
        }
        nums1 = reverseCount(nums1);
        nums2 = reverseCount(nums2);
        int[] combain = combain(nums1, nums2);
        return combain;
    }

    static int[] combain(int[] num1, int[] num2){
        int n1 =num1.length;
        int n2 =num2.length;
        int[] nums = new int[n1+n2];
        int i=0,j=0;
        while (i<n1 && j<n2){
            if (num1[i]<=num2[j]){
                nums[i+j] = num1[i];
                i++;
            }else {
                nums[i+j] = num2[j];
                j++;
                count+= (n1-i);
            }
        }
        if (i==n1){
            while (j<n2){
                nums[i+j]= num2[j];
                j++;
            }
        }else {
            while (i<n1){
                nums[i+j]= num1[i];
                i++;
            }
        }
        return nums;
    }

}
