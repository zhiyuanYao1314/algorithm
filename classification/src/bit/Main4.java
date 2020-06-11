package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 12:47
 * LC461 hammingDistance
 *
 */
public class Main4 {

    public int hammingDistance(int x, int y) {
        int z = x^y;
        int count=0;

        while(z!=0){
            if ((z&1)==1) count++;
            z>>>=1;
        }
        return count;
    }
}