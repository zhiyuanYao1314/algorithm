package zhoucongAli;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        // 测试案例
        Main2 m = new Main2();
        int[] ns = m.equalTarget(new int[]{1, 2, 3, 4}, 9);
        System.out.println(Arrays.toString(ns));
    }

    public int[] equalTarget(int[] nums, int target){
        // 1.特殊值
        if (nums==null || nums.length<3){
            return null;
        }
        //循环判断
        int n= nums.length;
        int sum =nums[0]+nums[1]+nums[2];
        if (sum==target){
            return new int[]{nums[0],nums[1],nums[2]};
        }
        for (int i=3;i<n;i++){
            sum = sum + nums[i] - nums[i-3];
            if (sum==target){
                return new int[]{nums[i-2], nums[i-1],nums[i]};
            }
        }
        return null;
    }
}
