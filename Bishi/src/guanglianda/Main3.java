package guanglianda;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 13:13
 * 输入近几天的股票值，比如：{23,24,25,21,12,22,31,23}
 * 输出至少再过几天股票会增值，如果之后股票一直没有增值，则输出0
 * 例如，对第一天（股票值为23），再过一天就会增值，输出1。
 * 对倒数第二天（股票值为31），再不会有股票增值的情况，输出0.
 * 因此，对于例题的输出应为{1，1,4,2,1,1,0,0}
 */
public class Main3 {

    int[] guss(int[] arr){
        int[] ans = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            int j=i+1;
            while (j<arr.length && arr[j]<=arr[i]){
                j++;
            }
            if (j==arr.length) {
                ans[i]=0;
            }else
                ans[i] = j-i;
        }
        return ans;
    }
}
