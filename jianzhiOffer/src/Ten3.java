/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 12:12
 * Describe:
 * version:1.0
 */
public class Ten3 {

    public static void main(String[] args) {
        Ten3 ten2 = new Ten3();
        System.out.println(ten2.JumpFloor(4));
    }
    public int JumpFloor(int target) {
        if (target<=1) return 1;
        int[] ans = new int[target+1];
        ans[0] =1;
        ans[1] =1;
        for (int i=2;i<=target;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans[target];
    }
}
