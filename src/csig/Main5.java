package csig;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/9/6 17:04
 *
 */
public class Main5 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String[] s = sc.nextLine().split(" ");
        // int n= new Integer(s[0]);
        // int len = new Integer(s[1]);
        Integer[][] nums = new Integer[6][2];
        // for (int i=0;i<n;i++){
        //
        // }
        nums = new Integer[][]{
                {0 ,2},

        {2 ,4},
                {3, 6},
        {4, 7}};
        int min = min(nums, 6);
        System.out.println(min);
    }

    static int min(Integer[][] nums,int n){
        // List<Integer[]> used = new ArrayList<>();
        int curRange =0;
        int i=0;
        int hasUsed = 0;
        int max =-1;
        while (i<nums.length){
            if (nums[i][0]<=curRange){
                max = Math.max(nums[i][1],max);
            }else {
                if (max==-1){
                    return -1;
                }
                hasUsed++;
                curRange = max;
                i--;
            }
            if (max>=n){
                return hasUsed+1;
            }
            i++;
        }
        if (curRange>=n){
            return hasUsed;
        }
        return -1;
    }


}
