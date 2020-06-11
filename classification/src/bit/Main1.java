package bit;

/**
 * Time:2020/4/22 13:10
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Main1 {
    /**
     * 所有元素抑或的结果是不重复的两个元素的抑或结果dif;
     * dif &=dif 得到的是两个元素不同的最右边的位，
     * 再dif ^ array[i]==0 区分这两个元素
     */
    public int[] FindNumsAppearOnce(int [] array) {
        int[] ans = new int[2];
        int dif =0;
        for (int i: array){
            dif ^= i;
        }
        dif &= dif; //最右侧为1的元素
        for (int i: array){
            if ((i&dif) ==0) ans[0] ^=i;
            else ans[1] ^=i;
        }
        return ans;
    }
}
