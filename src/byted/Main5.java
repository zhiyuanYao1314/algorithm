package byted;

import java.util.*;

/**
 * lc 15
 * threeSum
 * nums = [-1, 0, 1, 2, -1, -4]，
 * [ -1, 0,1 ]
 *  需要去重，再思考一下！！
 */
public class Main5 {

    public static void main(String[] args) {
        List<List<Integer>>  s = threeSum(new int[]{-1, 0, 1, 2,-1, -4});
        for (List list: s){
            System.out.print(list);
        }

    }

    //
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            List<List<Integer>> cur = twoSum(nums, 0-nums[i], i);
            for (List list: cur){
                list.add(nums[i]);
            }
            ret.addAll(cur);
        }
        return ret;
    }

    // 两数之和等于给定的数 去重；
    public static List<List<Integer>> twoSum(int[] nums, int target ,int used) {
        List<List<Integer>> ret = new ArrayList();
        Map<Integer,Integer> remain = new HashMap();
        for (int i=0;i<nums.length;i++){
            if (i==used) continue;
            List<Integer> cur = new ArrayList<>();
            if (remain.containsKey(nums[i])){
                cur.add(nums[remain.get(nums[i])]);
                cur.add(nums[i]);
                ret.add(cur);
            }else {
                remain.put(target-nums[i],i); // -1 0
            }
        }
        return ret;
    }
}
