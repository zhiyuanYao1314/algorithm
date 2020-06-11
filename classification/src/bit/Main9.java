package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:17
 * LC136数组中唯一一个不重复的数字
 *
 */
public class Main9 {
    public int singleNumber(int[] nums) {
        int ret=0;
        for (int i: nums){
            ret ^=i;
        }
        return ret;
    }
}
