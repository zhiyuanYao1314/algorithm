package byted;

import java.util.Arrays;

/**
 * 283 移动零
 * 双指针 i j
 * i 表示第一个0的位置；
 * j表示当前看到的位置
 * j>=n的时候结束
 */
public class Main25 {
    public static void main(String[] args) {
        int[] a = new int[]{1,20,0,2,3,0,0,9};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));

    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroIndex =-1;
        for (int i=0;i<n;i++){
            if (nums[i]==0){
                zeroIndex =i;
                break;
            }
        }
        if (zeroIndex==-1)
            return;
        for (int i=zeroIndex+1; i<n;i++){
            if (nums[i]!=0){
                nums[zeroIndex++]= nums[i];
                nums[i] = 0;
            }
        }
    }
}
