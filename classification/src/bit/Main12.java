package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:26
 * LC190 颠倒二进制位
 *
 */
public class Main12 {
    public int reverseBits(int n) {
        int ret =0;
        for(int i=0;i<32;i++){ // 32位
            ret <<=1; // 向前挪一位
            ret |= (n&1);// 插入一位
            n>>>=1; // 删除一位
        }
        return ret;
    }
}
