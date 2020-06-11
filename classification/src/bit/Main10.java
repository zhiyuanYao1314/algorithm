package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:18
 * LC268. 缺失数字
 */
public class Main10 {
    public int missingNumber(int[] nums) {
        // 0-n ^ nums[0]-nums[n-1]
        int ret =0;
        int n = nums.length;
        for (int i=0;i<n;i++){
            ret ^= i^nums[i];
        }
        return ret^n;
    }

}
