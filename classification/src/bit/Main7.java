package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 13:03
 * LC231 2的幂
 */
public class Main7 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
