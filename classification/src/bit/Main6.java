package bit;

import java.util.concurrent.CountDownLatch;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 12:54
 * LC342 4的幂
 */
public class Main6 {
    public boolean isPowerOfFour(int num) {
        //
        if (num>0 && (num &(num-1))==0){
            int count =0;
            while (num!=1){
                if ((num&1)==0) count++;
                else break;
                num>>=1;
            }
            if ((count&1)==0) return true;
            else return false;
        }
        return false;
    }

}
