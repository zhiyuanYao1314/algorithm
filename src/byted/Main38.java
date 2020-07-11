package byted;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * lettcode 剑指offer 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 简单
 * 判断差值
 *
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

 * 1 - 13 00
 */
public class Main38 {

    public boolean isStraight(int[] nums) {
        // 1. num of 0
        // 差值；
        Arrays.sort(nums);
        int numOf0 =0;
        int need = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==0){
                numOf0++;
            }else if(nums[i]==nums[i+1]){
                return false;
            }else {
                need += nums[i+1]-nums[i]-1;
            }
        }
        if (need>numOf0)
            return false;
        return true;
    }
}
