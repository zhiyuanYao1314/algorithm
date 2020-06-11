package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 19:47
 *
 * 数组中除了a出现了1次，其余都出现了三次，找出a
 */
public class Main15 {

    public static void main(String[] args) {
        int i = singleNum(new int[]{1,  3, 3, 3});
        System.out.println(i);
    }

    static int singleNum(int[] nums){
        int ret=0;
        for (int i=0;i<32;i++){
            int cur =0;
            for (int j=0;j<nums.length;j++){
                cur = cur +((nums[j]>>i) &1);
            } // 1
            ret |= ((cur%3)<<i);
        }
        return ret;
    }
}
