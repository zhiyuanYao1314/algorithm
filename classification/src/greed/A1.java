package greed;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 13:30
 *
 *  贪心算法，每次选择当前最好的解，
 *  可以获得局部最优解，但可能得不到全局最优解
 *
 *  从第一个解开始
 *      while 当还有下一个元素的时候
 *          do 选取下一个元素，更新state
 *      返回解
 *
 * 1，5，10，50，100 五种面额的纸币，
 * 每种纸币对应张数分别为 5，2，2，3，5 张。
 * 若小明需要支付 456 元，则需要多少张纸币？
 */
public class A1 {
    // -1 or num
    public int count(int money){
        int[] value = new int[]{1,5,10,50,100};
        int[] count = new int[]{5,2,2,3,5};
        int sum =0;
        for (int i= value.length-1;i>=0;i--){
            int c = Math.min(money/value[i], count[i]);
            money -= c*value[i];
            sum += c;
        }
        if (money>0) return -1;
        return sum;
    }
}
