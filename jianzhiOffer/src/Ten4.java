import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 12:18
 * Describe:
 * version:1.0
 */
public class Ten4 {
    public static void main(String[] args) {
        Ten4 ten3 = new Ten4();
        System.out.println(ten3.JumpFloorII(4));
    }
    public int JumpFloorII(int target) {
        if (target<=0) return 0;
        int[] ans = new int[target+1];
        ans[1] =1;
        for (int i=2;i<=target;i++){
            for (int j=1;j<i;j++){
                ans[i] +=ans[j];
            }
            ans[i]++;
        }
        return ans[target];
    }
}
