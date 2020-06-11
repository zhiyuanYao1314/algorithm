package A1SlidingWindow;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 17:12
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class A5 {

    public int lengthOfLongestSubstring(String s) {

        if (s==null || s.length()==0) return 0;
        int left =0, right =0;
        int max=0;
        HashMap<Character, Integer> map = new HashMap();
        while(right<s.length()){
            left = Math.max(max, map.getOrDefault(s.charAt(right),0));
            if (right-left+1>max) max = right-left+1;
            map.put(s.charAt(right), right+1);
            right++;
        }
        return max;

    }

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //  //TODO
    // }
}
