package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:47
 * LC137 出现3次，只有一个数出现一次
 *
 * 待研究！！！
 * TODO！
 */
public class Main13 {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice =0;
        for (int i:nums){
            once = ~twice &(once^i);
            twice = ~once & (twice^i);
        }
        return once;
    }
}
