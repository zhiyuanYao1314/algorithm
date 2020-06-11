package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/19 12:47
 *
 * LC1342. 将数字变成 0 的操作次数
 *
 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class Main5 {
    public int numberOfSteps (int num) {
        int count =0;
        int countOf1 = 0;
        while(num !=0){
            count++;
            if ((num&1)==1) countOf1++;
            num>>=1;
        }
        return count+countOf1-1;
    }
}
