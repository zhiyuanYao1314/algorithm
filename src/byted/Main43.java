package byted;

import java.util.HashSet;

import java.util.Set;

/**
 * 128 最长连续序列
 *
 * 用set记录是否存在，
 * 然后尝试以n开头的元素有多少个连续的元素？
 * 在判断前，判断n-1是否存在，如果存在，则不需要判断了。
 *
 */
public class Main43 {

    public static void main(String[] args) {
        int k = longestConsecutive(new int[]{1,4,3,5});
        System.out.print(k);
    }

    public static int longestConsecutive(int[] nums) {
        // init
        Set<Integer> set = new HashSet<>();
        int max =0;
        for (int n: nums){
            set.add(n);
        }

        for (int n: nums){
            // 不是开始点，不需要计算
            if (set.contains(n-1))
                continue;
            int sum =1;
            // 是起始点，循环计算以该点为开始的连续路径；
            while (set.contains(n+1)){
                sum++;
                n++;
            }
            max = Math.max(sum ,max);
        }

        return max;
    }
}
