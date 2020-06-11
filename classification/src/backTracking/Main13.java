package backTracking;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 15:35
 * 47 全排列2 元素重复 结果不重复
 *
 */
public class Main13 {

    // List<List<Integer>> ans = new ArrayList<>();
    // HashMap<Integer, Boolean> map = new HashMap<>();
    //
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     if(nums==null || nums.length==0) return ans;
    //     for (Integer i: nums){
    //         map.put(i, false);
    //     }
    //     int len =  nums.length;
    //     Deque<Integer> path = new ArrayDeque();
    //     boolean[] used = new boolean[len];
    //     dfs(nums, len, 0, path,used);
    //     return ans;
    // }
    //
    // private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used) {
    //     HashMap<Integer, Boolean> cur = new HashMap<>(map);
    //     if (depth==len) {
    //         ans.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for (int i=0;i<len;i++){
    //         // 被使用过或者这一层选过
    //         if (used[i] || cur.get(nums[i])) continue;
    //         path.addLast(nums[i]);
    //         used[i] =true;
    //         cur.put(nums[i], true); // 每一层只能选一种元素！
    //         dfs(nums, len,depth+1, path, used);
    //         path.removeLast();
    //         used[i] =false;
    //     }
    // }

    public static void main(String[] args) {
        Main13 main13 = new Main13();
        List<List<Integer>> lists = main13.permuteUnique(new int[]{1, 2, 2});
        for (List<Integer> l: lists){
            System.out.println(l);
        }
    }

    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums){
        if (nums ==null || nums.length==0)
            return ans;
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, path, used);
        return ans;
    }
    private void dfs(int[] nums, Deque<Integer> path, boolean[] used){
        if (path.size()== nums.length){
            ans.add(new ArrayList(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i])  continue;
            // 每一层每一种元素只能使用一次！ i-1 i 如果i-1 和i都每用过，
            if (i-1>=0 && !used[i-1]  && nums[i] == nums[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
