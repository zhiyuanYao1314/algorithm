package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:20
 * LC260. 只出现一次的数字 III
 * 给定一个整数数组 nums，
 * 其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。
 */
public class Main11 {
    /**
     * ^抑或所有元素，获得不同的两个元素的抑或；
     * dif &= -dif; 获取最低位用来区分；
     */
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int dif =0;
        for (int i: nums){
            dif ^=i;
        }
        dif &= -dif; // 最低位的数字
        for(int i: nums){
            if ((dif&i)==0) ret[0] ^=i;
            else ret[1] ^=i;
        }
        return ret;
    }
}
