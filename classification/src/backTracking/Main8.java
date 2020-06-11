package backTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 17:26
 * 全排列
 */
public class Main8 {
    public static void main(String[] args) {
        Main8 main8 = new Main8();
        List<List<Integer>> permute = main8.permute(new int[]{1, 2, 3});
        for (List<Integer> ins: permute){
            System.out.println(ins);
        }
    }

    //答案 路径 当前选择 结束条件
    List<List<Integer>> ans = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        backtrack(new LinkedList<>(),nums);
        return ans;
    }

    void backtrack(List<Integer> track, int[] nums){
        // 结束条件
        if (track.size()==nums.length){
            ans.add(new LinkedList<>(track));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(track, nums);
            track.remove((Integer) nums[i]);
        }
    }
}
