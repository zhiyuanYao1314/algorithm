package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 14:01
 * LC 338 比特位计数
 */
public class Main14 {

    /**
     * 取出最右边一位，在之前的数上+1
     */
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        ret[0] = 0;
        for (int i=1;i<=num;i++){
            ret[i] = ret[i&(i-1)]+1;
        }
        return ret;
    }
}
