package backTracking;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 14:06
 *  46 去排列
 *  经典 入门级  回溯算法
 *  三要素：
 *  当前状态， state: depth, path, used
 *  可选择解范围, not used
 *  结束条件:
 */
public class Main12 {
    public List<List<Integer>> permute(int[] nums) {
        // path, depth, used,
        Deque<Integer> path = new ArrayDeque();
        int len = nums.length;
        if (nums==null || nums.length ==0) return ans;
        boolean[] used = new boolean[nums.length];
        dfs(nums, len, 0, path, used);
        return ans;
    }

    private void dfs(int[] nums, int len , int depth, Deque<Integer> path, boolean[] used) {
        if (depth==len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums,len, depth+1,path, used);
            used[i] = false;
            path.removeLast();
        }
    }
    List<List<Integer>> ans = new ArrayList<>();


}
